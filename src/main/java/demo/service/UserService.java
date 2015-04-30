package demo.service;

import demo.domain.User;
import demo.domain.UserCreateForm;


public interface UserService {

	User create(UserCreateForm form);

	User getUserByUsername(String username);

}
