package com.sp.dao;

import com.sp.model.AddOn;
import com.sp.model.User;

public interface AddOnDao {

	
	 AddOn save(AddOn admin_user);
		
		void delete(int addonId);
		
		AddOn saveorupdate(AddOn addon);
		
		//AddOn findByEmail(String email);
		
		AddOn findById(int addonId);

	
	
}
