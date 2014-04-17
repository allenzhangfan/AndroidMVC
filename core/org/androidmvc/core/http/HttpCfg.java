package org.androidmvc.core.http;

public class HttpCfg {
	//调式时，本机IP
//	private static final String BS_IP="http://192.168.2.18:8080/";
	//215服务器内网地址
//	private static final String BS_IP="http://192.168.7.215:8181/";
	//215服务器外网地址
	private static final String BS_IP="http://59.175.109.250:8181/";
	//潜江外网地址
//	private static final String BS_IP="http://218.200.159.26:8080/";
	
	//开发环境后台
	private static final String BS_PROJECT_NAME="OVIT_MOA_BS/";
	//测试环境后台
//	private static final String BS_PROJECT_NAME="MOA_TEST/";
	private static String getURL(){
		return new StringBuilder(BS_IP).append(BS_PROJECT_NAME).toString();
	}
	public static String getFullURL(String subUrl){
		return new StringBuilder(getURL()).append(subUrl).toString();
	}
}
