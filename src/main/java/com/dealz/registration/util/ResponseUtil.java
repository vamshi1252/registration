package com.dealz.registration.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Data;

@Data
class ResponseUtil {
	
	private String mesg;
	
	public ResponseUtil(String mesg) {
		this.mesg = mesg;
	}
}


//public class ResponseUtil {
//	
//	private static final GsonBuilder builder = new GsonBuilder();
//	private static final Gson gson = builder.create();
//	
//	public static String getResponse(String stats, String mesg) throws Exception {
//		Status status =  new Status( mesg);
//		return gson.toJson(status);
//	}
//}



