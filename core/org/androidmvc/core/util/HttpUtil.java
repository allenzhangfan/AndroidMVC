package org.androidmvc.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

public class HttpUtil extends FinalHttp{

    private DefaultHttpClient httpClient;
    private HttpContext httpContext;
	private Map<String,String> params;
	private String BasePath = null;
	
	public String getBasePath() {
		return BasePath;
	}

	public void setBasePath(String basePath) {
		BasePath = basePath;
	}

	@Override
	  public void addHeader(String header, String value) {
		params.put(header, value);
    }
	
	public void httpGet(){
		HttpClient client = new DefaultHttpClient(); 
		StringBuilder sb = new StringBuilder();
		HttpParams param = client.getParams();

		try {
			HttpResponse response = client.execute(new HttpGet(BasePath));
			HttpEntity entity = response.getEntity();
			if(entity!=null){
				BufferedReader bf = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
				String value = null;
				while((value = bf.readLine())!=null){
					sb.append(value);
				}
				bf.close();
			}
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	}
 
	 
}
