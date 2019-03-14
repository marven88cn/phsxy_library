package com.phsxy.utils.utils;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.widget.PopupWindow;

/**
 * Description:
 * Copyright  : Copyright (c) 2018
 * Company    : 普华
 * Author     : marven
 * Date       : 2019/3/13 19:30
 */
public class PopupWinowFixed extends PopupWindow {

    public PopupWinowFixed(View contentView, int width, int height) {
        super(contentView, width, height, false);
    }

    /**
     * 修复popwindow不同sdk版本中高度不一样bug
     * @param anchor 显示popwindow view
     */
    @Override
    public void showAsDropDown(View anchor) {
        if (Build.VERSION.SDK_INT >= 24) {
            Rect rect = new Rect();
            anchor.getGlobalVisibleRect(rect);
            int h = anchor.getResources().getDisplayMetrics().heightPixels - rect.bottom;
            setHeight(h);
        }
        super.showAsDropDown(anchor);
    }
}