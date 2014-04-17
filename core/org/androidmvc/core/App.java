package org.androidmvc.core;

import java.io.IOException;

import org.apache.http.ParseException;


import android.app.Application;

public class App extends Application {

	private static App instance = null;
	public ControllerFactory srvcFactory;
	
	public AppManager manager=AppManager.getAppManager();

	@Override
	public void onCreate() {
		instance = this;
		srvcFactory=ControllerFactory.getInstance(this);
//		if(this.user==null){
//			user=srvcFactory.getUserSrvc().getSQLITEUser();
//		}
		
	}

	public static App getInstance() {
		return instance;
	}
//	/**
//	 * 当前用户
//	 */
//	public MobUser user;
//
//	public MobUser getUser() {
//		return user;
//	}
//
//	public void setUser(MobUser user) {
//		this.user = user;
//	}


	public ControllerFactory getSrvcFactory() {
		return srvcFactory;
	}

	public void setSrvcFactory(ControllerFactory srvcFactory) {
		this.srvcFactory = srvcFactory;
	}

}
