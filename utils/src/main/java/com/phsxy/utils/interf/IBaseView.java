package com.phsxy.utils.interf;

/**
 * author: Marven
 * date: 2018/7/17
 * dec: view基类
 **/
public interface IBaseView<T> {
    /**
     * 显示网络加载框
     */
    void showDialog();

    /**
     * 隐藏网络加载框
     */
    void hideDialog();
    /**
     *  请求数据成功
     * @param tData 数据类型
     *  @param type 标识请求
     */
    void loadDataSuccess(int type, T tData);

    /**
     *  请求数据错误
     * @param throwable 异常类型
     */
    void loadDataError(Throwable throwable);

}
