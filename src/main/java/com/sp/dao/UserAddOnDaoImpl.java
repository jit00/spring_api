package com.sp.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sp.model.AddOn;
import com.sp.model.UserAddOn;

@Transactional
@Repository("UserAddOnDao")
public class UserAddOnDaoImpl implements UserAddOnDao {

	
	
	@Autowired
    private SessionFactory sessionFactory;
	
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
	
   
	public UserAddOn save(UserAddOn uaddon) {
    	getSession().persist(uaddon);
	        return uaddon;
	}
	
	public void delete(int addonId) {
    	Criteria criteria = getSession().createCriteria(AddOn.class);
        criteria.add(Restrictions.eq("addonId", addonId));
        AddOn u= (AddOn) criteria.uniqueResult();
    	getSession().delete(u);
		
	}
	
	public AddOn saveorupdate(AddOn addon) {
		 getSession().saveOrUpdate(addon);
	        return addon;
	}
	
//	public User findByEmail(String email) {
//		Criteria criteria = getSession().createCriteria(AddOn.class);
//		  criteria.add(Restrictions.eq("email", email));
//		  User e= (User) criteria.uniqueResult();
//	        System.out.println(e);
//	        return (User) criteria.uniqueResult();
//	}
	
	public AddOn findById(int addonId) {
		  Criteria criteria = getSession().createCriteria(AddOn.class);
	        criteria.add(Restrictions.eq("addonId", addonId));
	        AddOn e= (AddOn) criteria.uniqueResult();
	        System.out.println(e);
	        return (AddOn) criteria.uniqueResult();
	}
	
	
	
	
	
}
