package com.cfuture.xiaozhi.example.uncatchexception;

import android.app.Application;
import android.util.Log;

/**
 * @author cfuture_小智
 * @Description
 */
public class CrashApplation extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Log.v("xiaozhi", "Application onCreate");
		
	}

}
