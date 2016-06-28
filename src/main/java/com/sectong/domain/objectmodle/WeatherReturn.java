package com.sectong.domain.objectmodle;

import java.io.Serializable;

/**
 * Created by xueyong on 16/6/27.
 * demo.
 */
public class WeatherReturn implements Serializable {

    private String weatherstation = "cloud";
    private String device_MAC;
    private String collect_data = "received";
    private String device_software_updateflag;

    public String getCollect_data() {
        return collect_data;
    }

    public void setCollect_data(String collect_data) {
        this.collect_data = collect_data;
    }

    public String getWeatherstation() {
        return weatherstation;
    }

    public void setWeatherstation(String weatherstation) {
        this.weatherstation = weatherstation;
    }

    public String getDevice_MAC() {
        return device_MAC;
    }

    public void setDevice_MAC(String device_MAC) {
        this.device_MAC = device_MAC;
    }

    public String getDevice_software_updateflag() {
        return device_software_updateflag;
    }

    public void setDevice_software_updateflag(String device_software_updateflag) {
        this.device_software_updateflag = device_software_updateflag;
    }
}
