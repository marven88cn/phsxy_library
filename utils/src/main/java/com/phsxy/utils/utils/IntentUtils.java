package com.phsxy.utils.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/**
 * Description:activity之间跳转
 * Copyright  : Copyright (c) 2018
 * Company    : 普华
 * Author     : marven
 * Date       : 2019/3/13 19:50
 */
public class IntentUtils {
    /**
     * activity 跳转工具方法
     * @param cxt 上下文
     * @param intentActivity 意图Activity
     * @param mBundle Bundle对象 用户传值 可以为空
     * @param isFinish 是否销毁 当前类对象
     */
    public static void goNextActivity(Context cxt, Class intentActivity, Bundle mBundle, boolean isFinish){
        Intent intent = new Intent(cxt,intentActivity);
        if(mBundle != null){
            intent.putExtra("bundle",mBundle);
        }
        ((Activity)cxt).startActivity(intent);
        if(isFinish)
            ((Activity)cxt).finish();
    }

    /**
     * activity 跳转工具方法
     * @param cxt 上下文
     * @param intentActivity 意图Activity
     * @param mBundle Bundle对象 用户传值 可以为空
     * @param resultCode resultCode
     */
    public static void goNextActivityResult(Context cxt, Class intentActivity, Bundle mBundle, int resultCode){
        Intent intent = new Intent(cxt,intentActivity);
        if(mBundle != null){
            intent.putExtra("bundle",mBundle);
        }
        ((Activity)cxt). startActivityForResult(intent, resultCode);



    }

    /**
     * 跳转到其他平台
     * @param appName       跳转的应用名称
     * @param packageName   应用包名
     * @param activityName  应用中的某个activity全路径
     * @param versionCode   应用的可以跳转的最小的versionCode（>=跳转）
     * @param bundle        传递的数据
     */
    public  static void toOtherPlatform(Context context,String appName, String packageName, String activityName, int versionCode, Bundle bundle) {
        if (ApkUtils.isAvailable(context, packageName)) {
            int jiCaiMaoVersionCode = ApkUtils.getVersionCode(context, packageName);
            if (jiCaiMaoVersionCode >= versionCode) {
                try {
                    Intent intent = new Intent();
                    intent.setClassName(packageName, activityName);
                    intent.putExtras(bundle);
                    context.startActivity(intent);
                }catch (Exception e){
                 ToastUtils.show(appName+"不是最新版，无拉取权限");
                }
            } else {
                ToastUtils.show("请更新最新版本的" + appName);
            }
        } else {
            ToastUtils.show("请先安装" + appName);
        }
    }

}
