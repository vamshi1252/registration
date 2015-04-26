package com.dealz.registration.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Data
@Entity
@Table(name = "userprofile")
public class UserProfile implements Serializable{
	
	private static final long         serialVersionUID = 1L;

////	@Id
////	@GeneratedValue(strategy=GenerationType.AUTO, generator="userprofile_id_seq")
//	@Id
//    @Column(name = "id", columnDefinition = "serial", unique = true, nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
////	@Column(name = "id")
//	private String id;
	
//	@Id
//    @Column(columnDefinition = "serial", unique = true, nullable = false)
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long              id;

	@Column(name = "fname")
	private String fname;
	
	@Column(name = "lname")
	private String lname;
	
	@Id
	@Column(name = "uuid")
	private String uuid;
	
	@Column(name = "password")
	private String password;

	@Column(name = "emailid")
	private String emailId;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "homepageurl")
	private String homepageurl;
	
	@Column(name = "profilepicurl")
	private String profilepicurl;
	

	@Column(name = "mobile")
	private String mobile;
	
	@Column(name = "add1")
	private String add1;
	
	@Column(name = "add2")
	private String add2;
	
	@Column(name = "add3")
	private String add3;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "pin")
	private String pin;

	public static void main(String args[]) {
		
		
		
		UserProfile up = new UserProfile();
		up.setUuid("adsfdsf");
		up.setFname("sdaf");
		up.setLname("dsfa");
		up.setPassword("");
		up.setEmailId("");
		up.setMobile("");
		up.setAdd1("");
		up.setAdd2("");
		up.setAdd3("");
		up.setCity("");
		up.setPin("");
		up.setGender("M");
		up.setHomepageurl("asdfa");
		up.setProfilepicurl("dsafrfewfea");
		
	 GsonBuilder builder = new GsonBuilder();
	 Gson gson = builder.create();
	 System.out.println(gson.toJson(up));
	 
		
	}
	
}

