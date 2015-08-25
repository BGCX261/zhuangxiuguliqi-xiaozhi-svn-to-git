package com.cfuture.xiaozhi.example.uncatchexception;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Properties;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

/**
 * @author cfuture_小智
 * @Description
 */
/**
 * @author cfuture_小智
 * @Description
 */
public class CrashHandler implements UncaughtExceptionHandler {

	private Context mContext;
	private static CrashHandler crashHandler;
	private static final boolean DEBUG = true;

	private Properties mDeviceCrashInfo = new Properties();
	private static final String VERSION_NAME = "versionName";
	private static final String VERSION_CODE = "versionCode";
	private static final String STACK_TRACE = "STACK_TRACE";

	private CrashHandler(Context c) {
		mContext = c;
	}

	private CrashHandler getCrashHandler(Context c) {
		if (crashHandler == null) {
			crashHandler = new CrashHandler(c);
		}
		return crashHandler;
	}

	/**
	 * 当UncaughtException发生时会转入该函数来处理 (non-Javadoc)
	 * 
	 * @see java.lang.Thread.UncaughtExceptionHandler#uncaughtException(java.lang.Thread,
	 *      java.lang.Throwable)
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		Log.v("xiaozhi", "catch UncaughtException");

	}

	private boolean handlerException(Throwable ex) {

		return true;
	}

	/**
	 * 收集设备信息
	 * 
	 * @param c
	 */
	private void collectCrashDeviceInfo(Context c) {
		PackageManager pm = c.getPackageManager();
		try {
			PackageInfo pi = pm.getPackageInfo(c.getPackageName(),
					PackageManager.GET_ACTIVITIES);
			mDeviceCrashInfo.put(VERSION_NAME,
					pi.versionName == null ? "not set" : pi.versionName);
			mDeviceCrashInfo.put(VERSION_NAME, pi.versionCode);
			
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}
}
