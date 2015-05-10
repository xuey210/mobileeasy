package demo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.Api;

import demo.domain.UserCreateForm;
import demo.domain.UserRegister;
import demo.message.Message;
import demo.repository.UserRepository;
import demo.service.UserRegisterService;
import demo.validator.UserCreateFormValidator;

/**
 * 处理用户类接口
 * 
 * @author jiekechoo
 *
 */
@RestController
@PropertySource("classpath:message.properties")
@Api(basePath = "/api", value = "user API", description = "用户", produces = "application/json")
@RequestMapping("/api")
public class UserController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserController.class);
	private UserRegisterService userRegisterService;
	private UserCreateFormValidator userCreateFormValidator;
	private UserRepository userRepository;

	private Message message = new Message();

	@Value("${myapp.value}")
	private String myvalue;

	@Autowired
	private Environment env;

	@Autowired
	public UserController(UserRegisterService userRegisterService,
			UserCreateFormValidator userCreateFormValidator,
			UserRepository userRepository) {
		this.userRegisterService = userRegisterService;
		this.userCreateFormValidator = userCreateFormValidator;
		this.userRepository = userRepository;
	}

	@InitBinder("form")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(userCreateFormValidator);
	}

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String handleUserCreateForm(@Valid @RequestBody UserCreateForm form,
			BindingResult bindingResult) {
		LOGGER.debug("Processing user create form={}, bindingResult={}", form,
				bindingResult);
		if (bindingResult.hasErrors()) {
			// failed validation
			return "user_create error: failed validation ";
		}
		try {
			userRegisterService.create(form);
		} catch (DataIntegrityViolationException e) {
			// probably email already exists - very rare case when multiple
			// admins are adding same user
			// at the same time and form validation has passed for more than one
			// of them.
			LOGGER.warn(
					"Exception occurred when trying to save the user, assuming duplicate username",
					e);
			bindingResult.reject("username.exists", "username already exists");
			return "user_create error: username already exists";
		}
		// ok, redirect
		return "create user success";
	}

	/**
	 * 使用 ResponseBody作为结果 200
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public UserRegister findByUserId(@PathVariable long id) {
		UserRegister user = userRepository.findOne(id);
		// HttpStatus status = user != null ? HttpStatus.OK :
		// HttpStatus.NOT_FOUND;
		return user;
	}

	/**
	 * 使用ResponseEntity作为返回结果 404
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserRegister> findById(@PathVariable long id) {
		UserRegister user = userRepository.findOne(id);
		HttpStatus status = user != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<UserRegister>(user, status);
	}

	/**
	 * 使用 ResponseEntity 返回自定义错误结果
	 * 
	 * @return
	 */

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findByUsersId(@PathVariable long id) {
		UserRegister user = userRepository.findOne(id);
		if (user == null) {
			message.setMsg(106, env.getProperty("106"));
			return new ResponseEntity<Message>(message, HttpStatus.NOT_FOUND);
		}
		message.setMsg(101, "Get user info", user);
		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		String myvalue1 = env.getProperty("myapp.value1");

		return "myapp.value: " + myvalue + ", myapp.value1: " + myvalue1;

	}

}
