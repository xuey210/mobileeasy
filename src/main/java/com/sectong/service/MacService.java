package com.sectong.service;

import com.sectong.domain.mongomodle.UserMac;

import java.util.Collection;

/**
 * Created by xueyong on 16/7/8.
 * demo.
 */
public interface MacService {
    UserMac insertUserMac(UserMac userMac);

    void remove(String id);

    Collection<UserMac> findByNameAndMac(String name, String mac);

    Collection<UserMac> findByName(String name);
}
