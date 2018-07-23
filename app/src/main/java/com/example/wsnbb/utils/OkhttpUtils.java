package com.example.wsnbb.utils;


import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpUtils {
    //private static OkhttpUtils okhttpUtils = new OkhttpUtils();//饿汉式
    private static OkhttpUtils instance;
    private final OkHttpClient okHttpClient;
    private final Handler handler;

    //构造方法要私有化
    private OkhttpUtils() {
        //创建OkhttpClient对象
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)//连接超时
                .writeTimeout(20, TimeUnit.SECONDS)//写入超时
                .readTimeout(20, TimeUnit.SECONDS)//读取超时
                .build();
        handler = new Handler(Looper.getMainLooper());
    }
    //单例模式
    //懒汉式
    public static OkhttpUtils getInstance() {
        if (instance == null) {
            instance = new OkhttpUtils();
        }
        return instance;
    }
    /*饿汉式
        public static OkhttpUtils getInstance(){
            return okhttpUtils;
        }*/

    /**
     * GET请求
     *
     * @param url
     */
    public void doGet(String url, final OnNetListener onNetListener) {
        //创建Request
        final Request request = new Request.Builder()
                .url(url)
                .build();
        //发送请求
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onFailed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //拿到服务器返回的数据
                final String string = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(string);
                    }
                });
            }
        });
    }

    /**
     * doget 请求
     *
     * @param url
     * @param params
     * @param onNetListener
     */
    public void doGet(String url, Map<String, String> params, final OnNetListener onNetListener) {
        //判断params是否为null
        if (params != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("?");
            //拼接参数
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append("&");
            }
            //?mobile=12354678954&password=123456&
            String s = sb.toString();
            String strParam = s.substring(0, s.length() - 1);
            url += strParam;
            Log.e("sdfasdf", "url = " + url);
        }
        //创建Request对象
        Request request = new Request.Builder().url(url).build();
        //发送请求
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onFailed(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                Log.e("MainActivity", "string = " + string);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(string);
                    }
                });
            }

        });
    }

    /**
     * dopsot 请求
     *
     * @param url
     * @param params
     * @param onNetListener
     */
    public void doPost(String url, Map<String, String> params, final OnNetListener onNetListener) {
        if (params != null) {
            //创建FormBody用于封装参数
            FormBody.Builder fBuilder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                fBuilder.add(entry.getKey(), entry.getValue());
            }
            FormBody formBody = fBuilder.build();
            Request.Builder builder = new Request.Builder();
            builder.url(url);
            builder.post(formBody);
            //创建Request
            Request request = builder.build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, final IOException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            onNetListener.onFailed(e);
                        }
                    });
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String string = response.body().string();
                    Log.e("MainActivity", "string = " + string);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            onNetListener.onSuccess(string);
                        }
                    });
                }
            });
        }
    }
}