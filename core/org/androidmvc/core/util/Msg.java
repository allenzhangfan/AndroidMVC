package org.androidmvc.core.util;

public final class Msg {
	public static final int TIMEOUT = 10001;
	public static final int DONE = 10002;
	public static final int LOGIN=10003;
	public static final int NO_LOGIN=10004;
	public static final int REFRESH = 10005;
	public static final int DEL_DONE=10006;
	public static final int SAVE_DONE=10007;
	public static final int YIJIAO_DONE=10008;
	public static final int SHOW_LOG=10009;
	public static final int LOADING_DONE=10010;
	public static final int LOADING_START=10011;
	
	public static final class HeartRate {
		public static final int FOUND_BT_DEVICE=11001;
		public static final int REFRESH_ALL=11002;
		public static final int REFRESH_TIME=11003;
	}

	public static final class History {
		public static final int HIGH_CHART_DONE=12001;
		public static final int LOW_CHART_DONE=12002;
		public static final int HEART_RATE_CHART_DONE=12003;
	}
	
	public static final class ScheduleEdit {
		public static final int DEL_DONE=13001;
	}
	
	public static final class SplashScreen{
		
	}
	public static final class LoginAct{
		public static final int UPDATE_LOGIN_STATE=15001;
	}

}
