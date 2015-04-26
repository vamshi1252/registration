package com.dealz.registration.helper;

import lombok.Data;


@Data
public class Status {

	private String mesg;
	
	public Status(String mesg) {
		this.mesg = mesg;
	}
	
}
