package com.miw.presentation;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.business.userManager.UserManagerService;
import com.miw.model.User;
import com.miw.validators.RegisterValidator;

@Controller
@RequestMapping("register")
public class RegisterUserController {
	
	@Autowired
	private UserManagerService userManagerService;
	
	@Autowired
	private RegisterValidator validator;
		
	public UserManagerService getUserManagerService() {
		return userManagerService;
	}

	public void setUserManagerService(UserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getRegisterView() {
		return "register";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, 
			BindingResult result) throws Exception {
				
		if(result.hasErrors()) {
			return "register";
		}
		else {
			validator.validate(user, result);
			if(result.hasErrors()) {
				return "register";
			}
			else {
				userManagerService.saveUser(user);
				return "redirect:login";
			}
		}
	}
	
	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}

}
