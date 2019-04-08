package com.sp.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sp.dao.AddOnDao;
import com.sp.dao.UserAddOnDao;
import com.sp.dao.UserDao;
import com.sp.model.AddOn;
import com.sp.model.User;
import com.sp.model.UserAddOn;
import com.sp.model.UserAddOnListModel;

@RestController
@RequestMapping("/api")
public class UserController {

	
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private AddOnDao addondao;
	
	@Autowired
	private UserAddOnDao uaddondao;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json;charset=UTF-8")
	public ResponseEntity<?> addUser(@RequestBody User model)  {
		
		
		User u = new User();
		u.setUserId(model.getUserId());
		u.setName(model.getName());
		u.setEmail(model.getEmail());
		  Gson gson = new Gson();
	        String json = gson.toJson(u);
	        
	        try (FileWriter writer = new FileWriter("src/main/resources/users.json")) {

	            gson.toJson(u, writer);

	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        return new ResponseEntity<>(u,HttpStatus.CREATED);
      
//		User userObj = userdao.findByEmail(model.getEmail());
//		if (userObj == null) {
//
//			try {
//				
//				userdao.saveUser(model);
//							
//				//Admin userdata=admindao.findByEmail(model.getEmail());				
//			    return new ResponseEntity<>(model, HttpStatus.CREATED);		
//				
//			} catch (Exception e) {
//
//				e.printStackTrace();
//				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//			}
//				
//		} else {
//			return new ResponseEntity<>(HttpStatus.CONFLICT);
//		}	
	}	
		

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT, headers = "Accept=application/json;charset=UTF-8")
	public ResponseEntity<?> updateDriver(@RequestBody User model) {
	
		User existingUser = userdao.findById(model.getUserId());
		if (existingUser == null) {

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
				
			existingUser.setName(model.getName()==null?existingUser.getName():model.getName());
			existingUser.setEmail(model.getEmail()==null?existingUser.getEmail():model.getEmail());
			userdao.saveorupdateUser(existingUser);
			return new ResponseEntity<>(HttpStatus.OK);
		}

	}
	
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE,headers = "Accept=application/json")
	public ResponseEntity<?> deleteUser(@RequestParam int userId) {
		
		User userObj = userdao.findById(userId);
		if (userObj == null) {
			

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			
			userdao.deleteUser(userId);

			return new ResponseEntity<>(HttpStatus.GONE);
		}
	}
	
	@RequestMapping(value = "/addAddon", method = RequestMethod.POST, headers = "Accept=application/json;charset=UTF-8")
	public ResponseEntity<?> addUser(@RequestBody AddOn model)  {

	
		
	AddOn Obj = addondao.findById(model.getAddonId());
		if (Obj == null) {

			try {
				
				addondao.save(model);
				
				
				//Admin userdata=admindao.findByEmail(model.getEmail());	
			   
				
			    return new ResponseEntity<>(model, HttpStatus.CREATED);		
				
			} catch (Exception e) {

				e.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

			}
				
	
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);

		}
		
	}	
		
	
	@RequestMapping(value = "/deleteAddOn", method = RequestMethod.DELETE,headers = "Accept=application/json")
	public ResponseEntity<?> deleteAddOn(@RequestParam int addonId) {
		
		AddOn Obj = addondao.findById(addonId);
		if (Obj == null) {
			

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			
			addondao.delete(addonId);

			return new ResponseEntity<>(HttpStatus.GONE);
		}
	}
	
	
	
	
	@RequestMapping(value = "/addEditUserAddon", method = RequestMethod.POST, headers = "Accept=application/json;charset=UTF-8")
	public ResponseEntity<?> addEditUserAddon(@RequestBody List<UserAddOnListModel> model)  {
	
	for(int i=0; i<model.size();i++) {
		
		User us= userdao.findById(model.get(i).getUserId());
		AddOn Obj = addondao.findById(model.get(i).getAddOnId());
		
		if(model.get(i).getName()==null && model.get(i).getAddonName()==null) {
		
		UserAddOn uaddon = new UserAddOn();
		uaddon.setUser(us);
		uaddon.setAddon(Obj);
		uaddon.setUserName(us.getName());
		uaddon.setUseraddonName(Obj.getAddonName());
		uaddondao.save(uaddon);
		}
		else {
			
			us.setName(model.get(i).getName()==null?us.getName():model.get(i).getName());
			userdao.saveorupdateUser(us);
			Obj.setAddonName(model.get(i).getAddonName()==null?Obj.getAddonName():model.get(i).getAddonName());
			addondao.saveorupdate(Obj);
			
			UserAddOn uaddon = uaddondao.findByuserIdandaddonId(model.get(i).getUserId(),model.get(i).getAddOnId());
			if(uaddon!=null) {
			uaddon.setUser(us);
			uaddon.setAddon(Obj);
			uaddon.setUserName(model.get(i).getName());
			uaddon.setUseraddonName(model.get(i).getAddonName());
			uaddondao.saveorupdate(uaddon);
			}
			
			
		}
	}
	
	return new ResponseEntity<>(HttpStatus.CREATED);
	
		
	}	
	
	
	
	
	
}
