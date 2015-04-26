package com.dealz.registration.service;

import com.dealz.registration.dao.entity.UserProfile;

public interface RegistrationService {
	
	public String createUser(UserProfile userProfile) throws Exception;
	
	public UserProfile getUser(String id) throws Exception;

}
