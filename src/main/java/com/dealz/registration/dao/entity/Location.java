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
@Table(name = "location")
public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_id_seq")
    @SequenceGenerator(name = "location_id_seq", sequenceName = "location_id_seq", allocationSize = 1)
	private Integer id;

	@Id
	@Column(name = "state")
	private String state; // uuid of user who created ad

	@Column(name = "city")
	private String city;

	@Column(name = "place")
	private String place;

	@Column(name = "category")
	private int category;

}
