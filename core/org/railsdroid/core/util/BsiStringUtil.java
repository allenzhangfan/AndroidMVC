package org.railsdroid.core.util;

import java.util.HashMap;
import java.util.Map;

public class BsiStringUtil {
	
	public static String getCnDayOfWeek(int dayOfWeek){
		String week="";
		switch (dayOfWeek) {
		case 1:
			week = "周日";
			break;
		case 2:
			week = "周一";
			break;
		case 3:
			week = "周二";
			break;
		case 4:
			week = "周三";
			break;
		case 5:
			week = "周四";
			break;
		case 6:
			week = "周五";
			break;
		case 7:
			week = "周六";
			break;
		default:
			week = "------------";
			break;
		}
		return week;
	}

}
