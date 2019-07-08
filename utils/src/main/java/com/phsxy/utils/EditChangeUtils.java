package com.phsxy.utils;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;


/**
 * Description:监听edittext输入
 *      支持多个edittext
 *      通过 addAllEditText
 * Copyright  : Copyright (c) 2018
 * Company    : 普华
 * Author     : marven
 * Date       : 2019/3/13 14:33
 */
public class EditChangeUtils {

    public interface IEditTextChangeListener {
        void textChange(boolean ischange);
    }
    static IEditTextChangeListener mChangeListener;

    /**
     * 设置多个EditText改变监听
     * @param changeListener 监听器
     */
    public static void setChangeListener(IEditTextChangeListener changeListener) {
        mChangeListener = changeListener;
    }

    /**
     * 检测输入框是否都输入了内容
     * 从而改变按钮的是否可点击
     * 以及输入框后面的X的可见性，X点击删除输入框的内容
     */
    public static class textChangeListener{
        private EditText[] editTexts;
        public textChangeListener addAllEditText(EditText... editTexts){
            this.editTexts=editTexts;
            initEditListener();
            return this;
        }

        private void initEditListener() {
            for (EditText editText:editTexts){
                editText.addTextChangedListener(new textChange());
            }
        }

        /**
         * edit输入的变化来改变按钮的是否点击
         */
        private class textChange implements TextWatcher {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (checkAllEdit()){
                    mChangeListener.textChange(true);
                }else {
                    mChangeListener.textChange(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        }

        /**
         * 检查所有的edit是否输入了数据
         * @return 是否输入数据
         */
        private boolean checkAllEdit() {
            for (EditText editText:editTexts){
                String tempStr = editText.getText().toString().trim();
                if (!TextUtils.isEmpty(tempStr)){
                    continue;
                }else {
                    return false;
                }
            }
            return true;
        }
    }
}
