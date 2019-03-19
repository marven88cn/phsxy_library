package com.phsxy.utils;

import com.google.gson.Gson;
/**
 * Description: 解析工具类
 * Copyright  : Copyright (c) 2018
 * Company    : 普华
 * Author     : marven
 * Date       : 2019/3/19 19:29
 */

public class ParseUtils {

    /**
     * @param cls 实体类
     * @param jsonString json串
     * @param <T> 返回泛型
     * @return 返回泛型
     */
    public static <T> T getPerson(Class<T> cls, String jsonString) {
        T t = null;
        try {
            Gson gson = new Gson();
            t = gson.fromJson(jsonString, cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }



}
