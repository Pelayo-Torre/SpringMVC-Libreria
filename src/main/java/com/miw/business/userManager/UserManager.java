package com.miw.business.userManager;

import org.apache.log4j.Logger;

import com.miw.model.User;
import com.miw.persistence.user.UserDataService;

public class UserManager implements UserManagerService{
	
	Logger logger = Logger.getLogger(this.getClass());
	private UserDataService userDataService;
	
	public void saveUser(User user) throws Exception {
		logger.debug("Asking for save user");
		userDataService.saveUser(user);
	}

	public User getUserByLogin(String login) throws Exception {
		logger.debug("Asking for user by Login");
		return userDataService.getUserByLogin(login);
	}

	public boolean userExists(String login, String password) throws Exception{
		logger.debug("Asking for user by Login and password");
		return userDataService.userExists(login, password);
	}

	public UserDataService getUserDataService() {
		return userDataService;
	}

	public void setUserDataService(UserDataService userDataService) {
		this.userDataService = userDataService;
	}
	
}
