package com.sectong.service;

import com.sectong.domain.mongomodle.UserMac;
import com.sectong.repository.MacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by xueyong on 16/7/8.
 */

@Service
public class MacServiceImpl implements MacService {

    @Autowired
    @Qualifier(value = "macRep")
    MacRepository macRepository;

    @Override
    public UserMac insertUserMac(UserMac userMac) {
        return macRepository.insert(userMac);
    }

    @Override
    public void remove(String id) {
        macRepository.delete(id);
    }

    @Override
    public Collection<UserMac> findByNameAndMac(String name, String mac) {
        return macRepository.findByNameAndMac(name, mac);
    }

    @Override
    public Collection<UserMac> findByName(String name) {
        return macRepository.findByName(name);
    }
}
