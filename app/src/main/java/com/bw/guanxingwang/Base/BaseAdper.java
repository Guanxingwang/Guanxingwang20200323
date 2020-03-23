package com.bw.guanxingwang.Base;

import android.content.Context;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.guanxingwang.R;

import java.util.List;

public class BaseAdper extends BaseAdapter {
    Context context;
    List<Base.DataBean> data;

    public BaseAdper(Context context, List<Base.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cess cess=null;
        if (convertView==null){
            convertView = View.inflate(context, R.layout.yi, null);
            cess=new Cess();
            cess.tupian=convertView.findViewById(R.id.tupiana);
            cess.wenben=convertView.findViewById(R.id.wenbena);
            convertView.setTag(cess);
        }else {
           cess= (Cess) convertView.getTag();
        }

        Base.DataBean dataBean = data.get(position);
        String goods_name = dataBean.getGoods_name();
        cess.wenben.setText(goods_name);
        cess.tupian.setImageBitmap(dataBean.getCurrency_price());
        return convertView;
    }
   public class Cess{
        ImageView tupian;
        TextView wenben;
   }
}
