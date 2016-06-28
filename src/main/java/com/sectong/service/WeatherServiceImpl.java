package com.sectong.service;

import com.sectong.domain.mongomodle.WeatherModle;
import com.sectong.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xueyong on 16/6/28.
 * demo.
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public void insertWeather(WeatherModle weatherModle) {
        weatherRepository.insert(weatherModle);
    }

    @Override
    public WeatherModle getWeatherByMac(String mac) {
        return weatherRepository.findFirstByDeviceMACOrderByCreateDateDesc(mac);
    }
}
