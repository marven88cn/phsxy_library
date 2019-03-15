package com.phsxy.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description: MD5工具类
 * Copyright  : Copyright (c) 2018
 * Company    : 普华
 * Author     : marven
 * Date       : 2019/3/11 19:29
 */

public class Md5Tool {

    private static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    /**
     * key唯一性检查
     * @param key key
     * @return 是否唯一
     */
    public static String hashKey(String key) {
        String hashKey;
        try {
            final MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(key.getBytes());
            hashKey = bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            hashKey = String.valueOf(key.hashCode());
        }
        return hashKey;
    }

}
