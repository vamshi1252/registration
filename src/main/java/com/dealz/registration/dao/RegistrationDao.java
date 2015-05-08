package com.dealz.registration.dao;

import java.util.List;

import com.dealz.registration.dao.entity.Ad;
import com.dealz.registration.dao.entity.Location;
import com.dealz.registration.dao.entity.UserProfile;
import com.dealz.regitration.dto.AdDetail;

public interface RegistrationDao {
	
	public UserProfile getUser(String id) throws Exception;
	
	public String createUser(UserProfile userProfile) throws Exception;
	
	public String createAd(Ad ad) throws Exception;
	
	public List<AdDetail> getAdByUid() throws Exception;
	
	public AdDetail getAdByid(int id) throws Exception;
	
	public int createLocation(Location location) throws Exception;
	
	public Location getLocationByid (int id) throws Exception;
	
}
