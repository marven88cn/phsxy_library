package com.phsxy.utils.interf;

import android.os.Message;

/**
 * author: Marven
 * date: 2018/6/6
 * dec:Handler 返回处理
 **/
public interface IHandler {
    /**
     * 应用程序退出
     */
    int APP_EXIT = 999999;

    /**
     * Handler消息事件驱动
     *
     * @param msg
     */
    void onMessage(Message msg);
}
