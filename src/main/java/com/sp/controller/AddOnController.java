package com.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.dao.AddOnDao;
import com.sp.model.AddOn;

@RestController
@RequestMapping("/api")
public class AddOnController {

	
	@Autowired
	private AddOnDao addondao;
	
	
	@RequestMapping(value = "/addAddon", method = RequestMethod.POST, headers = "Accept=application/json;charset=UTF-8")
	public ResponseEntity<?> addUser(@RequestBody AddOn model)  {

	
		
	AddOn Obj = addondao.findById(model.getAddonId());
		if (Obj == null) {
				
				addondao.save(model);
				
				
			    return new ResponseEntity<>(model, HttpStatus.CREATED);		
				
	
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);

		}
		
	}	
	
	
	@RequestMapping(value = "/updateAddon", method = RequestMethod.POST, headers = "Accept=application/json;charset=UTF-8")
	public ResponseEntity<?> updateAddon(@RequestBody AddOn model) {
	
		AddOn existingAddon = addondao.findById(model.getAddonId());
		if (existingAddon == null) {

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
				
			existingAddon.setAddonName(model.getAddonName()==null?existingAddon.getAddonName():model.getAddonName());
			addondao.saveorupdate(existingAddon);
			return new ResponseEntity<>(HttpStatus.OK);
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
		
	
	
	
	
}
