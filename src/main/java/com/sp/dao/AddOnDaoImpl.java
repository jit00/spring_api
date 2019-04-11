package com.sp.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sp.model.AddOn;
import com.sp.model.User;

@Transactional
@Repository("AddOnDao")
public class AddOnDaoImpl implements AddOnDao {

	
	@Autowired
    private SessionFactory sessionFactory;
	
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
	
   
	public AddOn save(AddOn addon) {
    	getSession().save(addon);
	        return addon;
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
	

	public AddOn findById(int addonId) {
		  Criteria criteria = getSession().createCriteria(AddOn.class);
	        criteria.add(Restrictions.eq("addonId", addonId));
	        AddOn e= (AddOn) criteria.uniqueResult();
	        System.out.println(e);
	        return (AddOn) criteria.uniqueResult();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
