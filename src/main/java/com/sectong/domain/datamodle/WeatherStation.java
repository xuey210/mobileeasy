package com.sectong.domain.datamodle;

import java.io.Serializable;

/**
 * Created by xueyong on 16/6/27.
 * demo.
 */
public class WeatherStation implements Serializable {

    private transient static final long serialVersionUID = -9182832278137388583L;
    private String weatherstation;
    private Version[] version;
    private String collect_data;
    private String AP_MAC;
    private String Device_MAC;
    private String IP;
    private String TM;
    private String HI;
    private String LI;
    private String PM;
    private String VC;
    private String TO;

    public String getAP_MAC() {
        return AP_MAC;
    }

    public void setAP_MAC(String AP_MAC) {
        this.AP_MAC = AP_MAC;
    }

    public String getCollect_data() {
        return collect_data;
    }

    public void setCollect_data(String collect_data) {
        this.collect_data = collect_data;
    }

    public String getDevice_MAC() {
        return Device_MAC;
    }

    public void setDevice_MAC(String device_MAC) {
        Device_MAC = device_MAC;
    }

    public String getHI() {
        return HI;
    }

    public void setHI(String HI) {
        this.HI = HI;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getLI() {
        return LI;
    }

    public void setLI(String LI) {
        this.LI = LI;
    }

    public String getPM() {
        return PM;
    }

    public void setPM(String PM) {
        this.PM = PM;
    }

    public String getTM() {
        return TM;
    }

    public void setTM(String TM) {
        this.TM = TM;
    }

    public String getTO() {
        return TO;
    }

    public void setTO(String TO) {
        this.TO = TO;
    }

    public String getVC() {
        return VC;
    }

    public void setVC(String VC) {
        this.VC = VC;
    }

    public Version[] getVersion() {
        return version;
    }

    public void setVersion(Version[] version) {
        this.version = version;
    }

    public String getWeatherstation() {
        return weatherstation;
    }

    public void setWeatherstation(String weatherstation) {
        this.weatherstation = weatherstation;
    }

}

class Version implements Serializable {
    private transient static final long serialVersionUID = -9025607975965670960L;
    private String device_software;
    private String device_hardware;
    private String wifi_module;

    public String getDevice_hardware() {
        return device_hardware;
    }

    public void setDevice_hardware(String device_hardware) {
        this.device_hardware = device_hardware;
    }

    public String getDevice_software() {
        return device_software;
    }

    public void setDevice_software(String device_software) {
        this.device_software = device_software;
    }

    public String getWifi_module() {
        return wifi_module;
    }

    public void setWifi_module(String wifi_module) {
        this.wifi_module = wifi_module;
    }
}
