package com.example.myyikezhong.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myyikezhong.MainActivity;
import com.example.myyikezhong.R;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {
    private ImageView mSplash;
    /**
     * 倒计时3秒
     */
    private TextView mDaojishi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
        //跳转主页面
        final Intent intent=new Intent(WelcomeActivity.this, MainActivity.class);

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(timerTask,3*1000);//此处3*1000代表3秒
    }
    /**
     *初始化控件
     */
    private void initView() {
        mSplash = (ImageView) findViewById(R.id.splash);

    }
}
