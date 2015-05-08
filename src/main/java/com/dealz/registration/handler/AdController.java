package com.dealz.registration.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dealz.registration.helper.Status;
import com.dealz.registration.service.RegistrationService;
import com.dealz.regitration.dto.AdDetail;
import com.dealz.regitration.dto.AdRequestDTO;


@Controller
@RequestMapping("/ad")
public class AdController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdController.class);
	
	@Autowired
	private RegistrationService registrationService;
	
	@RequestMapping(value = "/create", method=RequestMethod.POST, consumes="application/json")  
	 public @ResponseBody  
	 Status createUser(@RequestBody AdRequestDTO adRequestDTO) {
		 try {
			String mesg = registrationService.createAd(adRequestDTO);
			return new Status(mesg); 
		} catch (Exception ex) {
			logger.error("Exception while creating User",ex);
			return new Status(ex.getMessage());
		}
	 }  
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)  
	 public @ResponseBody  
	 AdDetail getAd(@PathVariable("id") String id) throws Exception { 
		if(id == null) {
			throw new Exception("id cannot be null");
		}
			return registrationService.getAd(Integer.valueOf(id));
	 }  
}
