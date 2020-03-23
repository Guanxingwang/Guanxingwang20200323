package com.bw.guanxingwang.Bean;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 *
 *
 * @姓名: 关兴旺
 * @日期: 2020/3/23 14:03
 * @作用: 方法描述
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        getLayoutId();
        getLayoutIdChange();
    }



    protected abstract int getLayout();
    protected abstract void getLayoutId();
    protected abstract void getLayoutIdChange();


}
