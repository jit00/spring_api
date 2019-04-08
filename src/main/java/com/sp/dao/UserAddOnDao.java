package com.sp.dao;

import com.sp.model.AddOn;
import com.sp.model.UserAddOn;

public interface UserAddOnDao {

	public UserAddOn save(UserAddOn uaddon);
	public UserAddOn saveorupdate(UserAddOn uaddon);
	  public UserAddOn findByuserIdandaddonId(int userId,int addonId);
	
}
