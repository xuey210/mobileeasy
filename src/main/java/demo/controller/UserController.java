package demo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.domain.UserCreateForm;
import demo.service.UserRegisterService;
import demo.validator.UserCreateFormValidator;

/**
 * 处理用户类接口
 * 
 * @author jiekechoo
 *
 */
@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserController.class);
	private UserRegisterService userRegisterService;
	private UserCreateFormValidator userCreateFormValidator;

	@Value("${myapp.value}")
	private String myvalue;

	@Autowired
	public UserController(UserRegisterService userRegisterService,
			UserCreateFormValidator userCreateFormValidator) {
		this.userRegisterService = userRegisterService;
		this.userCreateFormValidator = userCreateFormValidator;
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

	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {

		return "LIST " + myvalue;

	}

}
