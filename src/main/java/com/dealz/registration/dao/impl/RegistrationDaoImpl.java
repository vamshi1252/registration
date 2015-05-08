package com.dealz.registration.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dealz.registration.dao.RegistrationDao;
import com.dealz.registration.dao.entity.Ad;
import com.dealz.registration.dao.entity.Location;
//import com.dealz.registration.dao.commons.AbstractDaoImpl;
import com.dealz.registration.dao.entity.UserProfile;
import com.dealz.regitration.dto.AdDetail;
import com.dealz.regitration.dto.LocationDTO;

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
	
	@Override
	public String createAd(Ad ad) throws Exception {
		try {
			getCurrentSession().save(ad); 
			return "adid :" + ad.getId();
//		return (String) getCurrentSession().save(ad);
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public int createLocation(Location location) throws Exception {
		try {
		getCurrentSession().save(location); return location.getId();
//		return (Integer) getCurrentSession().save(location);
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public List<AdDetail> getAdByUid() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdDetail getAdByid(int id) throws Exception {
		try {
		Criteria criteria = getCurrentSession().createCriteria(
				Ad.class);
		criteria.add(Restrictions.eq("id", id));
		Ad ad = (Ad) criteria.uniqueResult();
		Location lc = getLocationByid(ad.getLocation());
		UserProfile user = getUser(ad.getUid());
		AdDetail adDetail = new AdDetail();
		adDetail.setId(ad.getId());
		adDetail.setCategory(ad.getCategory());
		adDetail.setCurrenrolls(ad.getCurrenrolls());
		adDetail.setDescription(ad.getDescription());
		adDetail.setEnddate(ad.getEnddate());
		adDetail.setEnrolledusers(ad.getEnrolledusers());
		adDetail.setImages(ad.getImages());
		adDetail.setMaxenrolls(ad.getMaxenrolls());
		adDetail.setStartdate(ad.getStartdate());
		adDetail.setSubject(ad.getSubject());
		adDetail.setUid(ad.getUid());
		
		/*
		 * set UserProfile information
		 */
		adDetail.setEmailId(user.getEmailId());
		adDetail.setFname(user.getFname());
		adDetail.setLname(user.getLname());
		adDetail.setHomepageurl(user.getHomepageurl());
		adDetail.setProfilepicurl(user.getProfilepicurl());
		
		/*
		 * set location information
		 */
		LocationDTO location = new LocationDTO();
		location.setCity(lc.getCity());
		location.setPlace(lc.getPlace());
		location.setState(lc.getState());
		location.setCategory(lc.getCategory());
		
		adDetail.setLocation(location);
		
		return adDetail;
		
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	@Override
	public Location getLocationByid (int id) throws Exception  {
		try {
			Criteria criteria = getCurrentSession().createCriteria(
					Location.class);
			criteria.add(Restrictions.eq("id", id));
			return (Location) criteria.uniqueResult();
			}catch(Exception ex) {
				throw ex;
			}
	}

}
