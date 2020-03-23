package com.bw.guanxingwang.Activity;

import android.widget.Toast;

import com.bw.guanxingwang.Bean.BaseActivity;
import com.bw.guanxingwang.P.NewsPreSernter;
import com.bw.guanxingwang.R;
import com.bw.guanxingwang.Util.NewUtil;
import com.bwei.xlistview.XlistView;

/**
 *
 *
 * @姓名: 关兴旺
 * @日期: 2020/3/23 15:04
 * @作用: 方法描述
 * 主页
 * 这是第一次上传
 *
 */

public class Mainactivity extends BaseActivity {

    XlistView puss;
    int page=1;
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void getLayoutId() {
        puss = findViewById(R.id.puss);
    }

    @Override
    protected void getLayoutIdChange() {
        Boolean aBoolean = NewUtil.getInstance().IsPan(this);
        final NewsPreSernter newsPreSernter=new NewsPreSernter();
        if (aBoolean){
            puss.setPullLoadEnable(true);
            puss.setPullRefreshEnable(true);
            puss.setXListViewListener(new XlistView.IXListViewListener() {
                @Override
                public void onRefresh() {
                    page=1;
                    newsPreSernter.equals(page);
                }

                @Override
                public void onLoadMore() {
                    page++;
                    newsPreSernter.equals(page);
                }
            });
        }else {
            Toast.makeText(this, "网络获取失败", Toast.LENGTH_SHORT).show();
        }

    }
}
