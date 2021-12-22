package com.greenqbit.dao;

import com.greenqbit.model.User;

public interface UserDao {
	
	void registration(User user) throws Exception;
	boolean validateUser(String username, String password);

}
