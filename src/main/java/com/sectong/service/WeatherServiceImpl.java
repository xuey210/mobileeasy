package com.sectong.service;

import com.sectong.domain.mongomodle.WeatherModle;
import com.sectong.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;

/**
 * Created by xueyong on 16/6/28.
 */

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final int PAGE_SIZE = 10;

    @Autowired
    private WeatherRepository weatherRepository;

//    @Autowired
//    private WeatherSpecRepository weatherSpecRepository;


    @Override
    public void insertWeather(WeatherModle weatherModle) {
        weatherRepository.insert(weatherModle);
    }

    @Override
    public WeatherModle getWeatherByMac(String mac) {
        return weatherRepository.findFirstByDeviceMACOrderByCreateDateDesc(mac);
    }

    @Override
    public Page<WeatherModle> getWeatherByPage(String deviceMAC, Integer pageNumber) {

        PageRequest request =
                new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "createDate");
        Specification<WeatherModle> specification = (root, criteriaQuery, criteriaBuilder) -> {
            if ("".equals(deviceMAC) && null != deviceMAC) {
                Predicate predicateMac = criteriaBuilder.equal(root.get("deviceMac").as(String.class), deviceMAC);
                criteriaBuilder.and(predicateMac);
            }
            return criteriaQuery.getRestriction();
        };
        return weatherRepository.findByDeviceMAC(deviceMAC, request);
    }
}
