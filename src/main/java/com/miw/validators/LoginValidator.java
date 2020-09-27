package com.miw.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.miw.business.userManager.UserManagerService;
import com.miw.model.LoginData;

@Component
public class LoginValidator implements Validator{
	
	@Autowired
	private UserManagerService userManagerService;

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginData.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginData login = (LoginData) target;
		
		try {
			if(!userManagerService.userExists(login.getLogin(), login.getPassword())) 
				errors.rejectValue("password", "login.credentials");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
