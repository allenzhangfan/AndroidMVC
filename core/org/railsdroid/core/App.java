package org.railsdroid.core;

import java.io.IOException;

import org.apache.http.ParseException;


import android.app.Application;

public class App extends Application {

	private static App instance = null;
	public SrvcFactory srvcFactory;
	
	public AppManager manager=AppManager.getAppManager();

	@Override
	public void onCreate() {
		instance = this;
		srvcFactory=SrvcFactory.getInstance(this);
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


	public SrvcFactory getSrvcFactory() {
		return srvcFactory;
	}

	public void setSrvcFactory(SrvcFactory srvcFactory) {
		this.srvcFactory = srvcFactory;
	}

}
