package demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import demo.domain.User;
import demo.domain.UserCreateForm;
import demo.repository.UserRepository;

/**
 * 用户服务接口实现
 * 
 * @author jiekechoo
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserServiceImpl.class);
	private final UserRepository userRepository;

	/**
	 * 装载userRepository
	 * 
	 * @param userRepository
	 */
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * 查找用户名
	 */
	@Override
	public User getUserByUsername(String username) {
		LOGGER.debug("Getting user by username={}", username);
		return userRepository.findByUsername(username);
	}

	/**
	 * 创建新用户
	 */
	@Override
	public User create(UserCreateForm form) {
		User user = new User();
		user.setUsername(form.getUsername());
		user.setPassword(new BCryptPasswordEncoder(10).encode(form
				.getPassword()));
		user.setEnabled(1);

		System.out.println(form);
		return userRepository.save(user);
	}

}
