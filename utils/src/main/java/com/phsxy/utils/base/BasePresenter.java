package com.phsxy.utils.base;

import com.phsxy.utils.interf.IBaseRequestCallBack;
import com.phsxy.utils.interf.IBaseView;

/**
 * author: Marven
 * date: 2018/7/20
 * dec:代理对象的基础实现 ：  一些基础的方法
 * @param <V> 视图接口对象(view) 具体业务各自继承自IBaseView
 * @param <T> 业务请求返回的具体对象
 **/
public class BasePresenter<V extends IBaseView, T> implements IBaseRequestCallBack<T> {

    private IBaseView iBaseView = null;  //基类视图

    /**
     * 构造方法
     * @param view 具体业务的视图接口对象
     */
    public BasePresenter(V view) {
        this.iBaseView = view;
    }

    /**
     * 请求之前显示progress
     */
    @Override
    public void beforeRequest(boolean isshow) {
        if(isshow)
           iBaseView.showDialog();
    }

    /**
     * 请求异常显示异常信息
     * @param throwable 异常信息

     */
    @Override
    public void requestError(Throwable throwable) {
        iBaseView.loadDataError(throwable);
        iBaseView.hideDialog(); //请求错误，提示错误信息之后隐藏progress
    }

    /**
     * 	请求完成之后隐藏progress
     */
    @Override
    public void requestComplete() {
        iBaseView.hideDialog();
    }

    /**
     * 请求成功获取成功之后的数据信息
     * @param callBack 回调的数据
     */
    @Override
    public void requestSuccess(int type,T callBack) {
        iBaseView.loadDataSuccess(type,callBack);
    }

}
