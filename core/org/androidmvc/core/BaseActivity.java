package org.androidmvc.core;


import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public abstract class BaseActivity extends FinalActivity implements IHasTitleBar {
	private static final String TAG = "activityInfo";
	protected SrvcFactory srvcFactory = SrvcFactory.getInstance(this);
	protected App app=App.getInstance();
	private long waitTime = 8000;
	private long touchTime = 0;
	
	/**
	 * 该页面的状态，是新增、编辑或显示
	 */
	public int status;
	protected TextView tvTopTitle;
	protected Button btnBack;
	protected ProgressBar pbInProgress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setCurrentContentView();
		initTitleBar();
		AppManager.getAppManager().addActivity(this);
		Log.i(TAG, this.getLocalClassName() + " : onCreate");

	}

	
	

	@Override
	protected void onStart() {
		Log.i(TAG, this.getLocalClassName() + " : onStart");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		Log.i(TAG, this.getLocalClassName() + " : onRestart");

		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.i(TAG, this.getLocalClassName() + " : onResume");
	//	 monitorOnTouchEvent();
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.i(TAG, this.getLocalClassName() + " : onPause");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.i(TAG, this.getLocalClassName() + " : onStop");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.i(TAG, this.getLocalClassName() + " : onDestory");
	}

	protected void toActivity(Class clazz) {
		Intent intent = new Intent(this, clazz);
		this.startActivity(intent);
	}

	/**
	 * 初始化titlebar顶栏
	 * <p>
	 * 
	 * @author zhangfan
	 * @version 2013-9-3
	 */
	private void initTitleBar() {
		if (findViewById(R.id.topBar) != null) {
			btnBack = (Button) findViewById(R.id.btnBack);
			tvTopTitle = (TextView) findViewById(R.id.tvTopTitle);
			pbInProgress = (ProgressBar) findViewById(R.id.pbInProgress);
			if (btnBack != null) {
				btnBack.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						finish();
					}
				});
			}
		}
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		try {
			super.onConfigurationChanged(newConfig);
			if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
				Log.v("Himi", "onConfigurationChanged_ORIENTATION_LANDSCAPE");
			} else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
				Log.v("Himi", "onConfigurationChanged_ORIENTATION_PORTRAIT");
			}
		} catch (Exception ex) {
		}
	}
	 
	public String subStringTitle(String title,int length){
		StringBuilder  sb=new StringBuilder(title);
		if(sb.length()>length){
		sb=sb.delete(length, title.length());
		}
		sb=sb.append("...");
		return sb.toString();
	}

	/**
	 * 是否启用返回键
	 */
	protected boolean isEnableBackKey = true;

	// 屏蔽返回键
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (!isEnableBackKey) {
			switch (keyCode) {
			case KeyEvent.KEYCODE_BACK:
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	 
}
