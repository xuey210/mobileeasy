package com.sectong.domain.mongomodle;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by xueyong on 16/6/28.
 * demo.
 */

@Document
public class WeatherModle implements Serializable {

    @Id
    private String id;
    private Object weatherData;
    private String deviceMAC;
    private Long createDate;

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public String getDeviceMAC() {
        return deviceMAC;
    }

    public void setDeviceMAC(String deviceMAC) {
        this.deviceMAC = deviceMAC;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(Object weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public String toString() {
        return "WeatherModle{" +
                "createDate=" + createDate +
                ", id='" + id + '\'' +
                ", weatherData='" + weatherData + '\'' +
                '}';
    }
}
