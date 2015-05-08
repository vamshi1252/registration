package com.dealz.regitration.dto;

import lombok.Data;

@Data
public class LocationDTO {

	private String state; // uuid of user who created ad

	private String city;

	private String place;

	private int category;
}
