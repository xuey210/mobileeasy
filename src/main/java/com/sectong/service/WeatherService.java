package com.sectong.service;

import com.sectong.domain.mongomodle.WeatherModle;
import org.springframework.data.domain.Page;

/**
 * Created by xueyong on 16/6/28.
 * demo.
 */
public interface WeatherService {

    void insertWeather(WeatherModle weatherModle);

    WeatherModle getWeatherByMac(String mac);

    Page<WeatherModle> getWeatherByPage(String deviceMAC, Integer pageNumber);
}
