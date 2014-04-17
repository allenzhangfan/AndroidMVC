package org.androidmvc.core.util;

import java.lang.reflect.Field;

import org.railsdroid.R;

public class ResourceUtil {

	public static int getResourceId(String resourceName) {
		// public static int getValue(String sqlName) throws SecurityException,
		// NoSuchFieldException, IllegalArgumentException,
		// IllegalAccessException {
		int id = 0;
		try {
			Field f = R.drawable.class.getField(resourceName);
			id = Integer.valueOf(f.get(null).toString());

		} catch (NoSuchFieldException e) {

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

}
