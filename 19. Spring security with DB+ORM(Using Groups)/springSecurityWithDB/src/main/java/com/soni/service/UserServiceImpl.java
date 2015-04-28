package com.soni.service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soni.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public User getUserDetails(String userName){
		User user;
		String sql = "select usr from User usr "
				+ " where usr.userName=:userName ";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(sql);
		query.setParameter("userName", userName);
		user = (User) query.uniqueResult();
		return user;
	}
}
