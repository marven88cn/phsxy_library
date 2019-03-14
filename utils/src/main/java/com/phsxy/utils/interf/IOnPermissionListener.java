package com.phsxy.utils.interf;

/**
 * Description:权限监听回调
 * Copyright  : Copyright (c) 2018
 * Company    : 普华
 * Author     : marven
 * Date       : 2019/3/14 17:42
 */
public interface IOnPermissionListener {

    /**
     * 授权成功
     */
    void onPermissionGranted();
    /**
     * 拒绝授权
     */
    void onPermissionDenied();
}
