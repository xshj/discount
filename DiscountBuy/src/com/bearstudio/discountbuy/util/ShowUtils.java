package com.bearstudio.discountbuy.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * ��ʾ��صĹ�����
 * 
 * @author hubin
 * @email 7629654@qq.com
 * @date 2014-11-07
 */
public class ShowUtils {

	/** ��dpת����px */
	public static int dip2px(Context context,float dipValue) {
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

	/** pxת��Ϊdp */
	public static int px2dip(Context context,float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

	/**
	 * ��ȡ��Ļ���
	 * 
	 * @param context
	 * @return
	 */
	public static DisplayMetrics getScreenSize(Context context) {
		DisplayMetrics localDisplayMetrics = new DisplayMetrics();
		((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(localDisplayMetrics);
		return localDisplayMetrics;
	}

	/**
	 * ��ʾToast
	 * 
	 * @param message
	 */
	private static Toast toast;

	public static void showToast(Context context,String message) {
		if (toast != null)
			toast.cancel();
		toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
		toast.show();
	}
	@SuppressWarnings("deprecation")
	public static int[] getScreenDispaly(Context context){
		WindowManager wm=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		int width=wm.getDefaultDisplay().getWidth();//手机屏幕的宽度
		int height=wm.getDefaultDisplay().getHeight();//手机屏幕的高度
		int result[] = {width,height};
		return result;
	}
	/**
	 * ��ʾToast
	 * 
	 * @param resID
	 */
	public static void showToast(Context context,int resID) {
		if (toast != null)
			toast.cancel();
		toast = Toast.makeText(context, resID, Toast.LENGTH_SHORT);
		toast.show();
	}

}
