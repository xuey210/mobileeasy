package demo.service;

import demo.domain.User;
import demo.domain.UserCreateForm;

/**
 * 用户服务网接口定义
 * 
 * @author jiekechoo
 *
 */
public interface UserService {

	User create(UserCreateForm form);

	User getUserByUsername(String username);

}
