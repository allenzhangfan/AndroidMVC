package org.androidmvc.core.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

	public static Gson getMyGson() {
		return new GsonBuilder().setDateFormat(DATE_FORMAT).create();
	}
	
}
