package com.miw.persistence.user;

import com.miw.model.User;

public interface UserDataService {
	
	public void saveUser(User user) throws Exception ;
	public User getUserByLogin(String login) throws Exception ;
	public boolean userExists(String login, String password) throws Exception;

}
