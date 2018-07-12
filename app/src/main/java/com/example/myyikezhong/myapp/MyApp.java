package com.example.myyikezhong.myapp;

import android.app.Application;
import android.content.Context;

import com.example.myyikezhong.utils.CrashHandler;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 撩个小媳妇 on 2018/7/6.
 */

public class MyApp extends Application {

    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //全局捕获异常
        CrashHandler.getInstance().init(this);
    }

}
