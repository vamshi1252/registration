package com.dealz.regitration.dto;

import lombok.Data;


@Data
public class AdDetail {
	
	private String fname;
	
	private String lname;
	
	private String emailId;
	
	private String homepageurl;
	
	private String profilepicurl;
	
	private long id;
	
	private String uid; //uuid of user who created ad
	
	private String subject;
	
	private String description;
	
	private int maxenrolls;
	
	private int currenrolls;
	
	private String enrolledusers;
	
	private long startdate;
	
	private long enddate;
	
	private String images;
	
	private LocationDTO location;
	
	private int category;
}
