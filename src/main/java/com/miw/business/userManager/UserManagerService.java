package com.miw.business.userManager;

import com.miw.model.User;

public interface UserManagerService {
	
	public void saveUser(User user) throws Exception ;
	public User getUserByLogin(String login) throws Exception ;
	public boolean userExists(String login, String password) throws Exception;

}
