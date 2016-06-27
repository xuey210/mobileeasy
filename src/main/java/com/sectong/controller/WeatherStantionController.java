package com.sectong.controller;

import com.sectong.constant.APIEm;
import com.sectong.domain.datamodle.WeatherReturn;
import com.sectong.domain.datamodle.WeatherStation;
import com.sectong.message.Message;
import com.sectong.utils.JsonUtil;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 处理用户类接口
 * 
 * @author jiekechoo
 *
 */
@RestController
@PropertySource("classpath:message.properties")
@Api(basePath = "/weatherstation", value = "天气业务API", description = "天气相关", produces = "application/json")
@RequestMapping("/weatherstation")
public class WeatherStantionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherStantionController.class);
//    private static final String RESULTMESSAGE = "{\"weatherstation\":\"cloud\",\"device_MAC\":%s,\"collect_data\":\"received\",\"device_software_updateflag\":\"%s\"}";


	private Message message = new Message();

	@ApiOperation(httpMethod = "POST", value = "提交天气数据(<font color='blue'>release</font>)",
            notes = "post weather 数据到 server。")
	@RequestMapping(method = RequestMethod.POST, value = "/postWeather")
	public ResponseEntity<Message> postWeather(HttpServletRequest request) {
        WeatherStation weatherStation = null;
        WeatherReturn weatherReturn = new WeatherReturn();
        try {
            String requestString = IOUtils.toString(request.getInputStream());
            LOGGER.debug("requestString:{}", requestString);
            weatherStation = JsonUtil.parseObject(requestString, WeatherStation.class);

            weatherReturn.setDevice_MAC(weatherStation.getDevice_MAC());
            weatherReturn.setDevice_software_updateflag("true");
//            message.setMsg(APIEm.SUCCESS.getCode(), APIEm.SUCCESS.getMessage(), JsonUtil.toJSONString(weatherReturn));
        } catch (IOException e) {
            LOGGER.error("post exception :{}", e);
            e.printStackTrace();
            weatherStation = new WeatherStation();
            weatherReturn.setDevice_MAC(weatherStation.getDevice_MAC());
            weatherReturn.setDevice_software_updateflag("fault");
        }
        message.setMsg(APIEm.SUCCESS.getCode(), APIEm.SUCCESS.getMessage(), JsonUtil.toJSONString(weatherReturn));
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

}
