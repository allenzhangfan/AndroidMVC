package org.androidmvc.core.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	public static Date getDateAfter(Date date, int afterDays){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, afterDays);// 把日期往后增加一天.整数往后推,负数往前移动
		return calendar.getTime();
	}
}
