package com.phsxy.utils.base;

import android.app.Activity;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description:app管理类
 * Copyright  : Copyright (c) 2018
 * Company    : 普华
 * Author     : marven
 * Date       : 2019/3/13 20:13
 */
public class AppManager {
    private static Stack<Activity> activityStack;
    private static AppManager instance;

    /**
     * 单一实例
     */
    public static AppManager getAppManager() {
        if (instance == null) {
            synchronized (AppManager.class){
                if (instance==null){
                    instance = new AppManager();
                }
            }
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        if(activity != null && !activity.toString().contains("MainTabActivity")){//过滤主MainTabActivity
            activityStack.add(activity);
        }
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        if (activityStack == null && activityStack.size() == 0) {
            return null;
        }
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        if (activityStack == null && activityStack.size() == 0) {
            return;
        }
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
        //activityStack.remove(0);
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activityStack == null && activityStack.size() == 0) {
            return;
        }
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定Activity
     * @param cls
     */
    public void popActivityOne(Class<?> cls) {
        if (activityStack == null && activityStack.size() == 0) {
            return;
        }
        if ("".equals(cls) || cls == null)
            return;

        for (int i = 0; i < activityStack.size(); i++) {
            if (activityStack.get(i).getClass().equals(cls)) {
                activityStack.get(i).finish();
            }
        }
    }

    /**
     * 关闭除了指定activity以外的全部activity 如果cls不存在于栈中，则栈全部清空
     *
     * @param cls
     */
    public void finishOthersActivity(Class<?> cls) {
        List<Activity> list = new ArrayList<>();
        list.addAll(activityStack);
        for (int i = 0; i < list.size(); i++) {
            Activity activity = list.get(i);
            if (!(activity.getClass().equals(cls))) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        if (activityStack == null && activityStack.size() == 0) {
            return;
        }
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        if (activityStack == null && activityStack.size() == 0) {
            return;
        }
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 获得所有IdeaCodeActivity
     * @return 集合
     */
    public List<BaseActivity> getAllActivity() {
        if (activityStack == null && activityStack.size() == 0) {
            return null;
        }
        ArrayList<BaseActivity> listActivity = new ArrayList<BaseActivity>();
        for (Activity activity : activityStack) {
            listActivity.add((BaseActivity) activity);
        }
        return listActivity;
    }

    @Deprecated
    public void AppExit(Context cxt) {
        appExit();
    }

    /**
     * 根据Activity名称返回指定的Activity
     *
     * @param name activity name
     * @return 当前activity
     */
    public BaseActivity getActivityByName(String name) {
        if (activityStack == null && activityStack.size() == 0) {
            return null;
        }
        for (Activity ia : activityStack) {
            if (ia.getClass().getName().indexOf(name) >= 0) {
                return (BaseActivity) ia;
            }
        }
        return null;
    }

    /**
     * 应用程序退出
     */
    public void appExit() {
        try {
            finishAllActivity();
        } catch (Exception e) {
            Runtime.getRuntime().exit(-1);
        }
    }

}

