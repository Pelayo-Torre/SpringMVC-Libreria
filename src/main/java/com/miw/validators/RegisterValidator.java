package com.miw.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.miw.business.userManager.UserManagerService;
import com.miw.model.User;

@Component
public class RegisterValidator implements Validator{

	@Autowired
	private UserManagerService userManagerService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if(user.getLogin().equals(user.getPassword()))
			errors.rejectValue("password","register.err.loginAndPassword");
		
		if(!user.getPassword().equals(user.getRepeatPassword()))
			errors.rejectValue("repeatPassword","register.err.passwords");
		
		if(errors.getErrorCount() == 0) {
			try {
				if(userManagerService.getUserByLogin(user.getLogin()) != null)
					errors.rejectValue("login", "register.err.loginAlreadyExists");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

}
