package org.railsdroid.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import net.tsz.afinal.FinalHttp;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

public class NetValidate extends FinalHttp {

	
	public static String getBody(String url)throws Exception{
		HttpClient client = new DefaultHttpClient(); 
		StringBuilder sb = new StringBuilder();
		HttpParams param = client.getParams();

		try {
			HttpResponse response = client.execute(new HttpGet(url));
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
		
		return sb.toString();
	}
}
