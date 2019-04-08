package com.sp.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sp.model.User;
@Transactional
@Repository("UserDao")
public class UserDaoImpl implements UserDao{

	@Autowired
    private SessionFactory sessionFactory;
	
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
	
   
	public User saveUser(User user) {
    	getSession().persist(user);
	        return user;
	}
	
	public void deleteUser(int userId) {
    	Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("userId", userId));
        User user= (User) criteria.uniqueResult();
    	getSession().delete(user);
		
	}
	
	public User saveorupdateUser(User user) {
		 getSession().saveOrUpdate(user);
	        return user;
	}
	
	public User findByEmail(String email) {
		Criteria criteria = getSession().createCriteria(User.class);
		  criteria.add(Restrictions.eq("email", email));
		  User e= (User) criteria.uniqueResult();
	        System.out.println(e);
	        return (User) criteria.uniqueResult();
	}
	
	public User findById(int userId) {
		  Criteria criteria = getSession().createCriteria(User.class);
	        criteria.add(Restrictions.eq("userId", userId));
	        User e= (User) criteria.uniqueResult();
	        System.out.println(e);
	        return (User) criteria.uniqueResult();
	}
    
 
	
	
}
