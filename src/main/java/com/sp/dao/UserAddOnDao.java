package com.sp.dao;

import java.util.List;

import com.sp.model.AddOn;
import com.sp.model.UserAddOn;

public interface UserAddOnDao {

	public UserAddOn save(UserAddOn uaddon);
	public UserAddOn saveorupdate(UserAddOn uadd);
	  public UserAddOn findByuserId(int userid);
	  public UserAddOn findById(int uaddonId);
}
