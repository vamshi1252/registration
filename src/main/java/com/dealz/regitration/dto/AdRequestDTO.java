package com.dealz.regitration.dto;

import lombok.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Data
public class AdRequestDTO {
	
	private String uid; //uuid of user who created ad
	
	private String subject;
	
	private String description;
	
	private int maxenrolls;
	
	private long startdate; //in milliseconds
	
	private long enddate;  //in milliseconds
	
	private String images;
	
	private String state; // uuid of user who created ad

	private String city;

	private String place;
	
	private int category;
	
public static void main(String args[]) {
	
		AdRequestDTO ad = new AdRequestDTO();
		ad.setUid("123456");
		ad.setSubject("");
		ad.setDescription("");
		ad.setStartdate(12345);
		ad.setEnddate(67890);
		ad.setMaxenrolls(100);
		ad.setImages("json");
		ad.setState("state");ad.setCity("city");ad.setPlace("place");
		ad.setCategory(1);
		
		
		
	 GsonBuilder builder = new GsonBuilder();
	 Gson gson = builder.create();
	 System.out.println(gson.toJson(ad));
}
}
