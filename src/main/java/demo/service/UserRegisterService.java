package demo.service;

import demo.domain.UserCreateForm;
import demo.domain.UserRegister;

/**
 * 用户服务网接口定义
 * 
 * @author jiekechoo
 *
 */
public interface UserRegisterService {

	UserRegister create(UserCreateForm form);

	UserRegister getUserByUsername(String username);

}
