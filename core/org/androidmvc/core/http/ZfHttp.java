package org.androidmvc.core.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class ZfHttp {
	private static DefaultHttpClient httpClient;
	private static DefaultHttpClient createHttpClient(){
		if(httpClient==null){
			httpClient=new DefaultHttpClient();
		}
		return httpClient;
	}
	
	public static HttpResponse doPost(String url, ZfParams params) throws ClientProtocolException, IOException,ZfHttpException{
		DefaultHttpClient mHttpClient = createHttpClient();
		Log.d("http", "request http POST: "+url);
		HttpPost mPost = new HttpPost(url);
		mPost.setEntity(params.getEntity());
		HttpResponse response = mHttpClient.execute(mPost);
		afterResponse(response);
		return response;
	}
	
	public static HttpResponse doGet(String url) throws ClientProtocolException, IOException,ZfHttpException{
		DefaultHttpClient mHttpClient = createHttpClient();
		Log.d("http", "request http GET: "+url);
		HttpGet mGet=new HttpGet(url);
		HttpResponse response = mHttpClient.execute(mGet);
		afterResponse(response);
		return response;
	}
	
	public static HttpResponse doGet(String url, ZfParams params) throws ClientProtocolException, IOException,ZfHttpException{
		DefaultHttpClient mHttpClient = createHttpClient();
		String fullUrl=new StringBuilder(url).append("?").append(params.getParamString()).toString();
		Log.d("http", "request http GET: "+fullUrl);
		HttpGet mGet=new HttpGet(fullUrl);
		HttpResponse response = mHttpClient.execute(mGet);
		afterResponse(response);
		return response;
	}
	
	private static boolean afterResponse(HttpResponse response ) throws ZfHttpException {
		boolean flag=false;
		int res = response.getStatusLine().getStatusCode();
		if(res==200){
			flag=true;
		}else{
			String msg="ZfHttpException! http response status is "+res;
			Log.d("http", msg);
			throw new ZfHttpException(msg);
		}
		return flag;
	}
	
	public static String post(String url, ZfParams params) throws ClientProtocolException, IOException,ZfHttpException{
		HttpResponse response = doPost(url, params);
		String resStr=EntityUtils.toString(response.getEntity(), params.ENCODING);
		Log.d("http", "response is: "+resStr);
		return resStr;
	}
	
	public static String get(String url, ZfParams params) throws ClientProtocolException, IOException,ZfHttpException{
		HttpResponse response = doGet(url, params);
		String resStr=EntityUtils.toString(response.getEntity(), params.ENCODING);
		Log.d("http", "response is: "+resStr);
		return resStr;
	}
	public static String get(String url) throws ParseException, IOException,ZfHttpException{
		HttpResponse response = doGet(url);
		String resStr=EntityUtils.toString(response.getEntity());
		Log.d("http", "response is: "+resStr);
		return resStr;
	}
}
