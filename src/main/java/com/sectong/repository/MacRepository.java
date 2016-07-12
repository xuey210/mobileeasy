package com.sectong.repository;

import com.sectong.domain.mongomodle.UserMac;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by xueyong on 16/7/2.
 */

@Repository("macRep")
public interface MacRepository extends MongoRepository<UserMac, String> {

    Collection<UserMac> findByNameAndMac(String name, String mac);

    Collection<UserMac> findByName(String name);
}
