package demo;


public interface UserService {

	User create(UserCreateForm form);

	User getUserByUsername(String username);

}
