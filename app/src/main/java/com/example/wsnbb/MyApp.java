package com.example.wsnbb;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

/**
 * Created by 撩个小媳妇 on 2018/7/6.
 */

public class MyApp extends Application {
    {
        //  PlatformConfig.setWeixin("wx396ea2b17e2f8938", "a33aae6c6649257cbb48de80ddb0bf90");
        PlatformConfig.setQQZone("1106856414", "dHByyWjizkOJihqy");

    }
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //图片
        Fresco.initialize(context);
        //友盟
        UMConfigure.init(this, "5b4c8e5cb27b0a06280001a0", "umeng", UMConfigure.DEVICE_TYPE_PHONE, "");
        //腾讯Bugly
        CrashReport.initCrashReport(getApplicationContext(), "bccdda1e3c", false);
    }

}
