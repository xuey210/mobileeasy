package com.sectong.service;

import com.sectong.domain.mongomodle.WeatherModle;

/**
 * Created by xueyong on 16/6/28.
 * demo.
 */
public interface WeatherService {

    void insertWeather(WeatherModle weatherModle);

    WeatherModle getWeatherByMac(String mac);
}
