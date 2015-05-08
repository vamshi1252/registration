package com.dealz.registration.dao.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ad")
public class Ad implements Serializable {
	
	private static final long         serialVersionUID = 1L;
	
//	@Id
//	@Column(columnDefinition = "serial", unique = true, nullable = false)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ad_id_seq")
    @SequenceGenerator(name = "ad_id_seq", sequenceName = "ad_id_seq", allocationSize = 1)
	private Integer id;
	
	@Id
	@Column(name = "uid")
	private String uid; //uuid of user who created ad
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "maxenrolls")
	private int maxenrolls;
	
	@Column(name = "currenrolls")
	private int currenrolls;
	
	@Column(name = "enrolledusers")
	private String enrolledusers;
	
	@Column(name = "startdate")
	private long startdate;
	
	@Column(name = "enddate")
	private long enddate;
	
	@Column(name = "images")
	private String images;
	
	@Column(name = "location")
	private int location;
	
	@Column(name = "category")
	private int category;
	
}
