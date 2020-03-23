package com.bw.guanxingwang.M;

import android.os.Handler;

import com.bw.guanxingwang.Base.Base;
import com.google.gson.Gson;

import java.util.List;

/**
 *
 *
 * @姓名: 关兴旺
 * @日期: 2020/3/23 14:57
 * @作用: 方法描述
 */
public class Model {
    Handler handler=new Handler();
    String path="http://blog.zhaoliang5156.cn/api/shop/shop1.json";
    public Model(){
        new Thread(new Runnable() {
            @Override
            public void run() {

               Gson gson= new Gson();
                Base base = gson.fromJson(path, Base.class);
                List<Base.DataBean> data = base.getData();

            }
        }).start();
    }
}
