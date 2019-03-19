package com.phsxy.utils;

import android.content.Context;

/**
 * Description: App 上下文
 * Copyright  : Copyright (c) 2018
 * Company    : 普华
 * Author     : marven
 * Date       : 2019/3/11 21:05
 */
public class AppContextUtil {
    static Context sContext;

    /**
     * 基类中初始化上下文
     * @param context 上下文
     */
    public static void init(Context context) {
        sContext = context;
    }

    /**
     * 初始化工具类中上下文对象
     * @return 上下文
     */
     public static Context getInstance() {
        if (sContext == null) {
            throw new NullPointerException("the context is null,please init AppContextUtil in Application first.");
        }
        return sContext;
    }
}
