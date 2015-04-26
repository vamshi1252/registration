package com.dealz.registration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealz.registration.dao.RegistrationDao;
import com.dealz.registration.dao.entity.UserProfile;
import com.dealz.registration.service.RegistrationService;

@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	private RegistrationDao registrationDao; 
	
	@Override
	public UserProfile getUser(String id) throws Exception {
		return registrationDao.getUser(id);
	}
	
	@Override
	public String createUser(UserProfile userProfile) throws Exception {
		return registrationDao.createUser(userProfile);
		 
	}
}
