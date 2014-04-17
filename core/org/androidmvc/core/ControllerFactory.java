package org.androidmvc.core;

import android.content.Context;

public class ControllerFactory {
	/**
	 * 单例的实现
	 */
	public static ControllerFactory singleton = null;

	private ControllerFactory(Context context) {
		this.context = context;
	}

	public static synchronized ControllerFactory getInstance(Context context) {
		if (singleton == null) {
			singleton = new ControllerFactory(context);
		}
		return singleton;
	}

	public Context context;

	// public ScheduleSrvc getScheduleSrvc() {
	// return ScheduleSrvc.getInstance(context);
	// }

}
