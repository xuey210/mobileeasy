package com.sectong.controller;

import com.sectong.constant.APIEm;
import com.sectong.domain.mongomodle.UserMac;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * 处理用户类接口
 * 
 * @author jiekechoo
 *
 */
@RestController
@PropertySource("classpath:message.properties")
@Api(basePath = "/mac", value = "设置相关API", description = "设备", produces = "application/jsnn")
@RequestMapping("/mac")
public class MacController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MacController.class);

    @Autowired
    private MacService macService;

    @ApiOperation(httpMethod = "POST", value = "绑定mac(<font color='blue'>release</font>)",
            notes = "用户绑定mac")
    @RequestMapping(method = RequestMethod.POST, value = "/bindingMac")
    public ResponseEntity<Message> bindingMac(HttpServletRequest request, UserMac userMac) {
        Message message = new Message();
        Object result;
        try {

            //查询是否绑定。绑定
            Collection<UserMac> userMacs = macService.findByNameAndMac(userMac.getName(), userMac.getMac());
            if (userMacs != null && userMacs.size() != 0) {
                result = "already bind";
            }else {
                UserMac user = macService.insertUserMac(userMac);
                result = user;
            }

        } catch (Exception e) {
            LOGGER.error("post exception :{}", e);
            result = e.getMessage();
        }
        message.setMsg(APIEm.SUCCESS.getCode(), APIEm.SUCCESS.getMessage(), result);
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/removeBindindMac")
    public ResponseEntity<Message> removeBindindMac(HttpServletRequest request, UserMac userMac) {
        Message message = new Message();
        String result = "";
        try {
            Assert.notNull(userMac, "userMac is null");
            Assert.notNull(userMac.getId(), "userMac.getId() is null");
            macService.remove(userMac.getId());
        } catch (Exception e) {
            LOGGER.error("post exception :{}", e);
            result = e.getMessage();
        }
        message.setMsg(APIEm.SUCCESS.getCode(), APIEm.SUCCESS.getMessage(), result);
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }
}
