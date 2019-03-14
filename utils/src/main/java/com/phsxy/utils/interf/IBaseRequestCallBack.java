package com.phsxy.utils.interf;

/**
 * author: Marven
 * date: 2018/7/20
 * dec:请求网络回调接口基类
 **/
public interface IBaseRequestCallBack<T> {
    /**
     * 	请求之前的操作
     * @param  isshow 是否显示加载框
     */
    void beforeRequest(boolean isshow);

    /**
     * @	请求异常
     * @param throwable 异常类型
     */
    void requestError(Throwable throwable);

    /**
     * 请求完成
     */
    void requestComplete();

    /**
     * 	请求成功
     * @param callBack 根据业务返回相应的数据
     */
    void requestSuccess(int type, T callBack);
}
