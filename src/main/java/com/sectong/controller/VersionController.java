package com.sectong.controller;

import com.sectong.constant.APIEm;
import com.sectong.domain.mongomodle.VersionFactory;
import com.sectong.message.Message;
import com.sectong.service.MacService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理用户类接口
 * 
 * @author jiekechoo
 *
 */
@RestController
@PropertySource("classpath:message.properties")
@Api(basePath = "/v", value = "设置相关API", description = "版本信息", produces = "application/jsnn")
@RequestMapping("/v")
public class VersionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(VersionController.class);

    @Autowired
    private MacService macService;

    @ApiOperation(httpMethod = "GET", value = "绑定mac(<font color='blue'>release</font>)",
            notes = "用户绑定mac")
    @RequestMapping(method = RequestMethod.GET, value = "/preUpdate")
    public ResponseEntity<Message> preUpdate(HttpServletRequest request) {
        Message message = new Message();
        Object result;
        try {
            result = VersionFactory.versionV1_0();
        } catch (Exception e) {
            LOGGER.error("post exception :{}", e);
            result = e.getMessage();
        }
        message.setMsg(APIEm.SUCCESS.getCode(), APIEm.SUCCESS.getMessage(), result);
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

    @ApiOperation(httpMethod = "GET", value = "绑定mac(<font color='blue'>release</font>)",
            notes = "用户绑定mac")
    @RequestMapping(method = RequestMethod.GET, value = "/update/{v}/{num}")
    public ResponseEntity<Message> update(HttpServletRequest request, @PathVariable String v,
                                          @PathVariable Integer num) {
        Message message = new Message();
        Object result;
        try {
            Assert.notNull(v);
            Assert.notNull(num);
            result = VersionFactory.versionSegment(v, num);
        } catch (Exception e) {
            LOGGER.error("post exception :{}", e);
            result = e.getMessage();
        }
        message.setMsg(APIEm.SUCCESS.getCode(), APIEm.SUCCESS.getMessage(), result);
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

}
