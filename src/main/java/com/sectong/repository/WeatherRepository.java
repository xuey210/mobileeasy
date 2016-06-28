package com.sectong.repository;

import com.sectong.domain.mongomodle.WeatherModle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by xueyong on 16/6/28.
 */

@RestResource(exported = false) // 禁止暴露REST
@Repository
public interface WeatherRepository extends MongoRepository<WeatherModle, String> {

    WeatherModle findFirstByDeviceMACOrderByCreateDateDesc(String deviceMAC);
}
