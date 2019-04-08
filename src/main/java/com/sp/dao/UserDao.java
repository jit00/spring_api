package com.sp.dao;

import org.springframework.stereotype.Component;

import com.sp.model.User;
public interface UserDao {
	
	 User saveUser(User admin_user);
		
		void deleteUser(int userId);
		
		User saveorupdateUser(User admin_user);
		
		User findByEmail(String email);
		
		User findById(int userId);

}
