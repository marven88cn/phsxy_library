package com.phsxy.utils.base;

import android.os.Handler;
import android.os.Message;

import com.phsxy.utils.interf.IHandler;

import java.lang.ref.WeakReference;

/**
 * Description:handler基类
 * Copyright  : Copyright (c) 2018
 * Company    : 普华
 * Author     : marven
 * Date       : 2019/3/13 20:15
 */
public class BaseHandler<T> extends Handler {

    // 注意下面的“PopupActivity”类是MyHandler类所在的外部类，即所在的activity
    private WeakReference<T> mActivity ;

    public BaseHandler(T activity) {
        mActivity = new WeakReference<T>(activity);
    }
    @Override
    public void handleMessage(Message msg) {
        T theActivity = mActivity.get();
        if (theActivity != null) {
            if (msg.what == IHandler.APP_EXIT) {

                AppManager.getAppManager().finishAllActivity();
                System.exit(0);
            } else {
                ((IHandler) theActivity).onMessage(msg);
            }
        }
    }

}
