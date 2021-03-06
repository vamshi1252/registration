package com.dealz.registration.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dealz.registration.dao.entity.UserProfile;
import com.dealz.registration.helper.Status;
import com.dealz.registration.service.RegistrationService;

@Controller
public class MVCController {

	private static final Logger logger = LoggerFactory.getLogger(MVCController.class);
	
	@Autowired
	private RegistrationService registrationService;

	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public ModelAndView welcome(@PathVariable("name") String name) {

		logger.debug("welcome() - name {}", name);

		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		model.addObject("name", name);

		return model;
	}
	
	
	@RequestMapping(value="/hellos/{name}", method=RequestMethod.GET)  
	 public @ResponseBody  
	 User getStudent1(@PathVariable("name") String name) {  
	  return new User(name, "meghna@gmail.com");
	 }  
	

//	@RequestMapping(value = "createUser", method=RequestMethod.POST)  
//	 public @ResponseBody  
//	 Status createUser(HttpServletRequest request) {
//		 try {
//			 String uuid = request.getParameter("uuid");
//			 String fname = request.getParameter("fname");
//			 String lname = request.getParameter("lname");
//			 
//			 UserProfile userProfile = new UserProfile();
//			 userProfile.setUuid(uuid);
//			 userProfile.setFname(fname);
//			 userProfile.setLname(lname);
//			String mesg = registrationService.createUser(userProfile);
//			return new Status(mesg); 
//		} catch (Exception ex) {
//			logger.error("Exception while creating User",ex);
//			return new Status(ex.getMessage());
//		}
//	 }  

	@RequestMapping(value = "createUser", method=RequestMethod.POST, consumes="application/json")  
	 public @ResponseBody  
	 Status createUser(@RequestBody UserProfile userProfile) {
		 try {
			String mesg = registrationService.createUser(userProfile);
			return new Status(mesg); 
		} catch (Exception ex) {
			logger.error("Exception while creating User",ex);
			return new Status(ex.getMessage());
		}
	 }  
	
	@RequestMapping(value = "getUser/{id}", method=RequestMethod.GET)  
	 public @ResponseBody  
	 UserProfile getUser(@PathVariable("id") String id) {
		 try {
			return  registrationService.getUser(id);
		} catch (Exception ex) {
			logger.error("Exception while creating User",ex);
		}
		 
		 return null;
	 }  
	
	
//	@RequestMapping(value = "/user/{id}", method=RequestMethod.GET)  
//	 public @ResponseBody  
//	 UserProfile getStudent(@PathVariable("id") String id) {
//		return registrationService.getUser(id);
//	 }  

}