package com.phsxy.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Description: 屏幕像素工具类
 * Copyright  : Copyright (c) 2018
 * Company    : 普华
 * Author     : marven
 * Date       : 2019/3/11 19:49
 */
public class ScreenUtils {
    private static DisplayMetrics mMetrics = new DisplayMetrics();
    private static ScreenUtils instance;
    private Context context;
    /**
     * 判断是否是全面屏
     */
    private volatile static boolean mHasCheckAllScreen;

    private volatile static boolean mIsAllScreenDevice;
    private ScreenUtils(Context _context) {
        context = _context.getApplicationContext();
        mMetrics = context.getResources().getDisplayMetrics();
    }



    /**
     * 判断是否是全面屏幕
     * @param context 上下文
     * @return 返回是否是全屏
     */
    public static boolean isAllScreenDevice(Context context) {
        if (mHasCheckAllScreen) {
            return mIsAllScreenDevice;
        }
        mHasCheckAllScreen = true;
        mIsAllScreenDevice = false;
        // 低于 API 21的，都不会是全面屏
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return false;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            Display display = windowManager.getDefaultDisplay();
            Point point = new Point();
            display.getRealSize(point);
            float width, height;
            if (point.x < point.y) {
                width = point.x;
                height = point.y;
            } else {
                width = point.y;
                height = point.x;
            }
            if (height / width >= 1.97f) {
                mIsAllScreenDevice = true;
            }
        }
        return mIsAllScreenDevice;
    }

    //获取单例对象
    public static ScreenUtils getInstance(Context context) {
        if (instance == null){
            synchronized (ScreenUtils.class){
                if (instance==null){
                    instance = new ScreenUtils(context);
                }
            }
        }
        return instance;
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @param dipValue （DisplayMetrics类中属性density）
     * @return 转化之后px值
     */
    public static int dp2px(Context context, float dipValue) {
        final float scale = mMetrics.density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 获取屏幕高
     * */
    public int getScreenHeight() {
        return mMetrics.heightPixels;
    }
    /**
     * 获取屏幕宽
     * */
    public int getScreenWidth() {
        return mMetrics.widthPixels;
    }
    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变（DisplayMetrics类中属性density）
     * @return 转化之后px值
     */
    public int dip2px(float dpValue) {
        final float scale = mMetrics.density;
        return (int) (dpValue * scale + 0.5f);
    }
    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     *
     * @param pxValue （DisplayMetrics类中属性density）
     * @return 转化之后dip值
     */
    public int px2dip(float pxValue) {
        final float scale = mMetrics.density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取状态栏高度
     * @return 高度
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 获取屏幕适配DisplayMetrics值
     * @param context 上下文
     * @return value
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(
                Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(
                displaymetrics);
        return displaymetrics;
    }
}


