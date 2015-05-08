package com.dealz.registration.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dealz.registration.dao.RegistrationDao;
import com.dealz.registration.dao.entity.Ad;
import com.dealz.registration.dao.entity.Location;
import com.dealz.registration.dao.entity.UserProfile;
import com.dealz.registration.service.RegistrationService;
import com.dealz.regitration.dto.AdDetail;
import com.dealz.regitration.dto.AdRequestDTO;

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
	
	@Override
	public String createAd(AdRequestDTO adRequestDTO) throws Exception {
		Ad ad = new Ad();
		
		ad.setUid(adRequestDTO.getUid());
		ad.setSubject(adRequestDTO.getSubject());
		ad.setDescription(adRequestDTO.getDescription());
		ad.setStartdate(adRequestDTO.getStartdate());
		ad.setEnddate(adRequestDTO.getEnddate());
		ad.setMaxenrolls(adRequestDTO.getMaxenrolls());
		ad.setImages(adRequestDTO.getImages());
		ad.setCategory(adRequestDTO.getCategory());
		
		Location location = new Location();
		location.setState(adRequestDTO.getState());
		location.setCity(adRequestDTO.getCity());
		location.setPlace(adRequestDTO.getPlace());
		location.setCategory(adRequestDTO.getCategory());
		int locationId = registrationDao.createLocation(location);
		
		ad.setLocation(locationId);
		return registrationDao.createAd(ad);
	}

	@Override
	public AdDetail getAd(int id) throws Exception {
		return registrationDao.getAdByid(id);
	}
}
