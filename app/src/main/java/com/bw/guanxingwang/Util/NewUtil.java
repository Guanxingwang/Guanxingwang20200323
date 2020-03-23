package com.bw.guanxingwang.Util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telecom.Conference;
import android.telecom.Connection;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 *
 * @姓名: 关兴旺
 * @日期: 2020/3/23 14:57
 * @作用: 方法描述
 */
public class NewUtil {
  private static   NewUtil newUtil=new NewUtil();

    public NewUtil() {
    }

    public static NewUtil getInstance() {
        return newUtil;
    }

    public Boolean IsPan(Context context){
      @SuppressLint("ServiceCast") Connection connection = (Connection) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
        Conference conference = connection.getConference();
        if (conference!=null){
            return true;
        }else {
            return false;
        }
    }

    public String GetJson(String path){
        try {
            URL url=new URL(path);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            int responseCode = urlConnection.getResponseCode();
            if (responseCode==200){
                InputStream inputStream = urlConnection.getInputStream();
                int len=0;
                StringBuilder stringBuilder=new StringBuilder();
                byte[] bytes=new byte[1024];
                while ((len=inputStream.read(bytes))!=-1){
                    String s = new String(bytes, 0, len);
                    stringBuilder.append(s);
                }
                String s = stringBuilder.toString();
                return s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }
}
