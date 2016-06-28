package com.sectong.controller;

import com.sectong.constant.APIEm;
import com.sectong.domain.mongomodle.WeatherModle;
import com.sectong.domain.objectmodle.WeatherReturn;
import com.sectong.domain.objectmodle.WeatherStation;
import com.sectong.message.Message;
import com.sectong.service.WeatherService;
import com.sectong.utils.JsonUtil;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
@Api(basePath = "/weatherstation", value = "天气业务API", description = "天气相关", produces = "application/jsnn")
@RequestMapping("/weatherstation")
public class WeatherStationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(WeatherStationController.class);

    @Autowired
    private WeatherService weatherService;

	@ApiOperation(httpMethod = "POST", value = "提交天气数据(<font color='blue'>release</font>)",
            notes = "post weather 数据到 server。")
	@RequestMapping(method = RequestMethod.POST, value = "/postWeather")
	public ResponseEntity<Message> postWeather(HttpServletRequest request) {
        Message message = new Message();
        WeatherStation weatherStation;
        String _tempString;
        WeatherReturn weatherReturn = new WeatherReturn();
        try {
            String requestString = IOUtils.toString(request.getInputStream());
            LOGGER.debug("requestString:{}", requestString);
            weatherStation = JsonUtil.parseObject(requestString, WeatherStation.class);

            weatherReturn.setDevice_MAC(weatherStation.getDevice_MAC());
            weatherReturn.setDevice_software_updateflag("true");
            _tempString = JsonUtil.toJSONString(weatherStation);

            WeatherModle weatherModle = new WeatherModle();
            weatherModle.setDeviceMAC(weatherStation.getDevice_MAC());
            weatherModle.setWeatherData(_tempString);
            weatherModle.setCreateDate(System.currentTimeMillis());
            weatherService.insertWeather(weatherModle);
        } catch (IOException e) {
            LOGGER.error("post exception :{}", e);
            e.printStackTrace();
            weatherStation = new WeatherStation();
            weatherReturn.setDevice_MAC(weatherStation.getDevice_MAC());
            weatherReturn.setDevice_software_updateflag("fault");
            _tempString = JsonUtil.toJSONString(weatherStation);
        }
        message.setMsg(APIEm.SUCCESS.getCode(), APIEm.SUCCESS.getMessage(), _tempString);
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

    @ApiOperation(httpMethod = "GET", value = "获取天气数据(<font color='blue'>release</font>)",
            notes = "获取某个mac的天气数据。")
    @RequestMapping(method = RequestMethod.GET, value = "/getWeather/{mac}")
    public ResponseEntity<Message> getWeather(@PathVariable String mac,HttpServletRequest request) {
        Message message = new Message();
        try {
            WeatherModle weatherModle = weatherService.getWeatherByMac(mac);
            message.setMsg(APIEm.SUCCESS.getCode(), APIEm.SUCCESS.getMessage(), weatherModle.getWeatherData());
        } catch (Exception e) {
            LOGGER.error("post exception :{}", e);
            e.printStackTrace();
            message.setMsg(APIEm.FAIL.getCode(), APIEm.FAIL.getMessage(), "");
        }
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

}
