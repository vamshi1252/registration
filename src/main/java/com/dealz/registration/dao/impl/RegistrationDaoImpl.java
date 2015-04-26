package com.dealz.registration.dao.impl;

import lombok.Data;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;




import org.springframework.transaction.annotation.Transactional;

import com.dealz.registration.dao.RegistrationDao;
//import com.dealz.registration.dao.commons.AbstractDaoImpl;
import com.dealz.registration.dao.entity.UserProfile;

@Repository("registrationDao")
@Transactional(propagation=Propagation.REQUIRED)
public class RegistrationDaoImpl implements RegistrationDao { // extends AbstractDaoImpl<UserProfile>
									// implements RegistrationDao{

	@Autowired
	private SessionFactory sessionFactory;

	public RegistrationDaoImpl() {
		// super(UserProfile.class);
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public String createUser(UserProfile userProfile) throws Exception {
		try {
			 getCurrentSession().save(userProfile);
		return "Success";
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public UserProfile getUser(String id) throws Exception {
		try {
		Criteria criteria = getCurrentSession().createCriteria(
				UserProfile.class);
		criteria.add(Restrictions.eq("uuid", id));
		return (UserProfile) criteria.uniqueResult();
		}catch(Exception ex) {
			throw ex;
		}
		
	}

}
