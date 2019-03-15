package com.phsxy.utils;
/**
 * Description: 按钮防止多点
 * Copyright  : Copyright (c) 2018
 * Company    : 普华
 * Author     : marven
 * Date       : 2019/3/13 19:29
 */

public class ButtonClickUtils {

    private static long lastClickTime;

    /**
     * 防止过快点击
     * @return 是否点击过快
     */
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if ( 0 < timeD && timeD < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
