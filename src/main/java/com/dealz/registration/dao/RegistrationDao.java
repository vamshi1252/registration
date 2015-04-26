package com.dealz.registration.dao;

import com.dealz.registration.dao.entity.UserProfile;

public interface RegistrationDao {
	
	public UserProfile getUser(String id) throws Exception;
	
	public String createUser(UserProfile userProfile) throws Exception;

}
