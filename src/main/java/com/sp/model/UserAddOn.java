package com.sp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="T_User_Add_On")
public class UserAddOn {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "useraddonid", unique = true, nullable = false)	
    private int useraddonId;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User user;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addonid")
    private AddOn addon;
	
	
	
	@Column(name = "username", length = 255)
	private String userName;
	
	
	@Column(name = "useraddonname", length = 255)
	private String useraddonName;


	public int getUseraddonId() {
		return useraddonId;
	}


	public void setUseraddonId(int useraddonId) {
		this.useraddonId = useraddonId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUseraddonName() {
		return useraddonName;
	}


	public void setUseraddonName(String useraddonName) {
		this.useraddonName = useraddonName;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public AddOn getAddon() {
		return addon;
	}


	public void setAddon(AddOn addon) {
		this.addon = addon;
	}
	
	
	
	
}
