package org.railsdroid.core.util;

import android.telephony.TelephonyManager;
import android.content.Context;

public class DeviceInfo {
	/**
	 * 获取手机号码，只适用于2G的GSM卡
	 * @author zhangfan 2014-3-28
	 * @param contxt
	 * @return
	 */
	public static String getTelephoneNumber(Context contxt){
		String telephone ="00000000000";
		TelephonyManager telephonemanager = (TelephonyManager)contxt.getSystemService(Context.TELEPHONY_SERVICE);
		if(telephonemanager.getSimState() == TelephonyManager.SIM_STATE_READY ){
		return telephonemanager.getLine1Number();
		}else{
			return telephone;
		}
	}
	/**
	 * 获取手机的IMEI
	 * @author zhangfan 2014-3-28
	 * @param context
	 * @return
	 */
	public static String getMIME(Context context){
		String imei ="000000000000000";
		TelephonyManager telephonemanager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		if(telephonemanager.getSimState() == TelephonyManager.SIM_STATE_READY ){
		return telephonemanager.getDeviceId();
		}else{
			return imei;
		}

	}
	/**
	 * 判断该设备是否有sim卡
	 */
	public static boolean hasSim(Context context){
		TelephonyManager telephonemanager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
		return telephonemanager.getSimState() == TelephonyManager.SIM_STATE_READY;
	}
}
