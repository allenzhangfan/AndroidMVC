package org.railsdroid.core;

import android.content.Context;

public class SrvcFactory {
	/**
	 * 单例的实现
	 */
	public static SrvcFactory singleton = null;

	private SrvcFactory(Context context) {
		this.context = context;
	}

	public static synchronized SrvcFactory getInstance(Context context) {
		if (singleton == null) {
			singleton = new SrvcFactory(context);
		}
		return singleton;
	}

	public Context context;

	// public ScheduleSrvc getScheduleSrvc() {
	// return ScheduleSrvc.getInstance(context);
	// }

}
