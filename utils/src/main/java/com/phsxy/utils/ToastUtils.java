package com.phsxy.utils;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Description: toast提示工具类
 * Copyright  : Copyright (c) 2018
 * Company    : 普华
 * Author     : marven
 * Date       : 2019/3/13 19:05
 */

public class ToastUtils {

    static Toast toast;

    private static View toastView;

    /**
     * 设置toast 弹出框样式
     * @param view view中TextView id设置为tv_toast
     */
    public static void setToastView(View view){
        toastView = view;
    }

    /**
     * 自定义显示Toast
     * @param message 提示信息
     */
    public static void show(String message) {
        showMes(message);
    }


    /**
     * 显示toast
     * @param message 显示文本内容
     * */
    private static void showMes(String message) {
        if (toast != null)
            toast.cancel();
        if(AppContextUtil.sContext == null){
            Log.e("ToastUtils","请先在application中初始化AppContextUtil");
            return;
        }
        if(toastView == null){
            toastView =  LayoutInflater.from(AppContextUtil.sContext).inflate(R.layout.library_toast_layout, null);
        }

        TextView textView = toastView.findViewById(R.id.tv_toast);
        textView.setText(message);
        toast = new Toast(AppContextUtil.sContext);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,200);
        toast.setView(toastView);
        toast.show();
    }

    /**
     * 取消toast显示
     * */
    public static void cancleToast(){
        if (toast!=null)
            toast.cancel();
    }


}

