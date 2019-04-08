package com.sp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_Add_On")
public class AddOn {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "addonid", unique = true, nullable = false)	
    private int addonId;	
	
	@Column(name = "addonname", length = 255)
	private String addonName;
		
//	@ManyToOne
//	@JoinColumn(name = "userid")
//	private User user;
	
	@OneToMany(mappedBy="addon", cascade=CascadeType.PERSIST)
	private List<UserAddOn> useraddon=new ArrayList<UserAddOn>();

	public int getAddonId() {
		return addonId;
	}

	public void setAddonId(int addonId) {
		this.addonId = addonId;
	}

	public String getAddonName() {
		return addonName;
	}

	public void setAddonName(String addonName) {
		this.addonName = addonName;
	}

	public List<UserAddOn> getUseraddon() {
		return useraddon;
	}

	public void setUseraddon(List<UserAddOn> useraddon) {
		this.useraddon = useraddon;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	
	
	
	
	
	
}
