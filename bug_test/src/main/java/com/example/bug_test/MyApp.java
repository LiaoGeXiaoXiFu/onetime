package com.example.bug_test;

import android.app.Application;
import android.content.Context;

/**
 * Created by 撩个小媳妇 on 2018/7/12.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //注册全局捕获异常
        CrashHandler.getInstance().init(this);
    }
}
