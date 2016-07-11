package com.sectong.domain.objectmodle;

import java.io.Serializable;

/**
 * Created by xueyong on 16/7/11.
 * demo.
 */
public class WeatherBase implements Serializable {

    private String weatherstation;
    private String deviceMAC;

    public WeatherBase(String deviceMAC, String weatherstation) {
        this.deviceMAC = deviceMAC;
        this.weatherstation = weatherstation;
    }

    public String getDeviceMAC() {
        return deviceMAC;
    }

    public void setDeviceMAC(String deviceMAC) {
        this.deviceMAC = deviceMAC;
    }

    public String getWeatherstation() {
        return weatherstation;
    }

    public void setWeatherstation(String weatherstation) {
        this.weatherstation = weatherstation;
    }
}
