package com.dealz.registration.service;

import com.dealz.registration.dao.entity.UserProfile;
import com.dealz.regitration.dto.AdDetail;
import com.dealz.regitration.dto.AdRequestDTO;

public interface RegistrationService {
	
	public String createUser(UserProfile userProfile) throws Exception;
	
	public UserProfile getUser(String id) throws Exception;
	
	public String createAd(AdRequestDTO adRequestDTO) throws Exception;
	
	public AdDetail getAd(int id) throws Exception;
}
