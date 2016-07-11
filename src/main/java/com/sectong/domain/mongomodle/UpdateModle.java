package com.sectong.domain.mongomodle;

import com.sectong.domain.objectmodle.WeatherBase;

import java.io.Serializable;

/**
 * Created by xueyong on 16/7/11.
 * demo.
 */
public class UpdateModle extends WeatherBase implements Serializable {

    private String update;
    private String deviceSoftware;
    private String lastversion;
    private Integer number;
    private Integer size;

    public UpdateModle(String deviceMAC, String weatherstation, String deviceSoftware, String lastversion, Integer number, Integer size, String update) {
        super(deviceMAC, weatherstation);
        this.deviceSoftware = deviceSoftware;
        this.lastversion = lastversion;
        this.number = number;
        this.size = size;
        this.update = update;
    }

    public String getDeviceSoftware() {
        return deviceSoftware;
    }

    public void setDeviceSoftware(String deviceSoftware) {
        this.deviceSoftware = deviceSoftware;
    }

    public String getLastversion() {
        return lastversion;
    }

    public void setLastversion(String lastversion) {
        this.lastversion = lastversion;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }
}
