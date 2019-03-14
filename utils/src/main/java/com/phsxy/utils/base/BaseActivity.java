package com.phsxy.utils.base;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import com.gyf.barlibrary.ImmersionBar;
import com.phsxy.utils.interf.IBaseView;
import com.phsxy.utils.interf.IHandler;


/**
 * author: Marven
 * date: 2018/7/17
 * dec: activity 基类
 **/
public abstract class BaseActivity extends AppCompatActivity
    implements IHandler, IBaseView<String> {


    /**
     * 初始化布局
     *
     * @return view
     */
    protected abstract int initLayout();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    //AppManager初始化 懒汉
    protected AppManager manager = AppManager.getAppManager();
    //初始化Handler
    protected BaseHandler<BaseActivity> handler = new BaseHandler<>(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局
        setContentView(initLayout());
        manager.addActivity(this);

        //初始化沉浸式
        if (isImmersionBarEnabled()) {
            initImmersionBar();
        }

    }


    protected boolean isImmersionBarEnabled() {
        return true;
    }

    protected void initImmersionBar() {
        ImmersionBar.with(this)
                .statusBarColor("#ffffff")
                .fitsSystemWindows(true)
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    public void onMessage(Message msg) {

    }

    /**
     *
     */

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //根据 Tag 取消请求
        manager.finishActivity(this);

        // 必须调用该方法，防止内存泄漏
        ImmersionBar.with(this).destroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }





    /**
     * 点击空白区域隐藏键盘.
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (BaseActivity.this.getCurrentFocus() != null) {
                if (BaseActivity.this.getCurrentFocus().getWindowToken() != null) {
                    imm.hideSoftInputFromWindow(BaseActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        }
        return super.onTouchEvent(event);
    }


}
