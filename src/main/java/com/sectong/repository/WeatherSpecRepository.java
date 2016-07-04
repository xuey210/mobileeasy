package com.sectong.repository;

import com.sectong.domain.mongomodle.WeatherModle;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;

/**
 * Created by xueyong on 16/7/2.
 */

@Component
public interface WeatherSpecRepository extends JpaSpecificationExecutor<WeatherModle> {

}
