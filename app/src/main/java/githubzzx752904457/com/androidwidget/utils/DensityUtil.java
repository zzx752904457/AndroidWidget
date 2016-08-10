package githubzzx752904457.com.androidwidget.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;

import githubzzx752904457.com.androidwidget.application.MyApplication;


public class DensityUtil {

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dip2px(int value) {
		DisplayMetrics dm = MyApplication.getInstance().getResources().getDisplayMetrics();
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, dm);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dip(float pxValue) {
		final float scale = MyApplication.getInstance().getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}

//	public static int sp2px(int value) {
//		DisplayMetrics dm = MyApplication.getInstance().getResources().getDisplayMetrics();
//		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, dm);
//	}

	/**
	 * 将sp值转换为px值，保证文字大小不变
	 * 
	 * @param spValue
	 * @param fontScale
	 * （DisplayMetrics类中属性scaledDensity）
	 * @return
	 */
	public static int sp2px(int spValue) {
		float fontScale = MyApplication.getInstance().getResources().getDisplayMetrics().scaledDensity;
		return (int)(spValue * fontScale + 0.5f);
	}

	public static int getScreenWidth() {
		WindowManager wm = (WindowManager)MyApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.widthPixels;
	}

	public static int getScreenHeight() {
		WindowManager wm = (WindowManager)MyApplication.getInstance().getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics);
		return outMetrics.heightPixels;
	}

	public static int getHeight(View view) {
		int w = View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED);
		int h = View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED);
		view.measure(w, h);
		return view.getMeasuredHeight();
	}
}
