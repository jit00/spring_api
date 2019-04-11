package com.sp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_User")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "userid", unique = true, nullable = false)	
    private int userId;			
	
	
	@Column(name = "name", length = 255)
	private String Name;
	
	@Column(name = "email", length = 255)
	private String email;
	
@OneToMany(mappedBy="user", cascade=CascadeType.PERSIST)
private List<UserAddOn> useraddon=new ArrayList<UserAddOn>();


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}







	public List<UserAddOn> getUseraddon() {
		return useraddon;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setUseraddon(List<UserAddOn> useraddon) {
		this.useraddon = useraddon;
	}



	
	
	
	
	
	
}
