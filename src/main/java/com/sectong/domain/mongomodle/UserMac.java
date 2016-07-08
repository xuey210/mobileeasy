package com.sectong.domain.mongomodle;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by xueyong on 16/7/8.
 */

@Document
public class UserMac implements Serializable {

    @Id
    private String id;
    private String name;
    private String mac;

    public UserMac(String mac, String name) {
        this.mac = mac;
        this.name = name;
    }

    public UserMac() {

    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserMac{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", mac='" + mac + '\'' +
                '}';
    }
}
