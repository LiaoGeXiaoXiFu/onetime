package com.example.wsnbb;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.wsnbb.fragment.crosstalk.CrossTalk;
import com.example.wsnbb.fragment.funny.FunnyImg;
import com.example.wsnbb.fragment.recommend.Recommend;
import com.example.wsnbb.fragment.video.VideoPlay;
import com.example.wsnbb.page.IssueActivity;
import com.example.wsnbb.view.CircleImageView;
import com.nineoldandroids.view.ViewHelper;
import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.container)
    FrameLayout mContainer;
    @BindView(R.id.recommend_page)
    RadioButton mRecommendPage;
    @BindView(R.id.cross_talk)
    RadioButton mCrossTalk;
    @BindView(R.id.video_page)
    RadioButton mVideoPage;
    @BindView(R.id.funny_page)
    RadioButton mFunnyPage;
    @BindView(R.id.toolbar_left_btn)
    CircleImageView mToolbarLeftBtn;
    @BindView(R.id.toolbar_right_tv)
    ImageView mToolbarRightTv;
    @BindView(R.id.toolbar_title_tv)
    TextView mToolbarTitleTv;
    private DrawerLayout drawerLayout;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDrawerLayout();
        ButterKnife.bind(this);
        inIdImg();
        //默认加载布局
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, new Recommend()).commit();
    }

    private void initDrawerLayout() {
        drawerLayout = (DrawerLayout) this.findViewById(R.id.drawerLayout);
        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {

            // 当我们打开菜单的时候，先执行onDrawerStateChanged，然后不断执行onDrawerSlide，第三步会执行onDrawerOpened，最后执行onDrawerStateChanged
            // 当我们关闭菜单的时候，先执行onDrawerStateChanged，然后不断执行onDrawerSlide，第三步会执行onDrawerClosed，最后执行onDrawerStateChanged
            @Override
            public void onDrawerStateChanged(int newState) {
                Log.i("lenve", "onDrawerStateChanged");
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                slideAnim(drawerView, slideOffset);
                Log.i("lenve", "onDrawerSlide");
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Log.i("lenve", "onDrawerOpened");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Log.i("lenve", "onDrawerClosed");
            }
        });
    }

    /**
     * 侧滑
     * @param drawerView
     * @param slideOffset
     */
    private void slideAnim(View drawerView, float slideOffset) {
        View contentView = drawerLayout.getChildAt(0);
        // slideOffset表示菜单项滑出来的比例，打开菜单时取值为0->1,关闭菜单时取值为1->0
        float scale = 1 - slideOffset;
        float rightScale = 0.8f + scale * 0.2f;
        float leftScale = 1 - 0.3f * scale;

        ViewHelper.setScaleX(drawerView, leftScale);
        ViewHelper.setScaleY(drawerView, leftScale);
        ViewHelper.setAlpha(drawerView, 0.6f + 0.4f * (1 - scale));
        ViewHelper.setTranslationX(contentView, drawerView.getMeasuredWidth()
                * (1 - scale));
        ViewHelper.setPivotX(contentView, 0);
        ViewHelper.setPivotY(contentView, contentView.getMeasuredHeight() / 2);
        contentView.invalidate();
        ViewHelper.setScaleX(contentView, rightScale);
        ViewHelper.setScaleY(contentView, rightScale);
    }

    @OnClick({R.id.container, R.id.recommend_page, R.id.cross_talk, R.id.video_page, R.id.funny_page, R.id.toolbar_left_btn, R.id.toolbar_title_tv, R.id.toolbar_right_tv})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                inIdImg();
                fragmentManager.beginTransaction().replace(R.id.container, new Recommend()).commit();
                mToolbarTitleTv.setText("推荐");
                break;
            case R.id.recommend_page://推荐
                inIdImg();
                fragmentManager.beginTransaction().replace(R.id.container, new Recommend()).commit();
                mToolbarTitleTv.setText("推荐");
                break;
            case R.id.cross_talk://段子
                inIdImg();
                fragmentManager.beginTransaction().replace(R.id.container, new CrossTalk()).commit();
                mToolbarTitleTv.setText("段子");
                break;
            case R.id.video_page://视频
                inIdImg();
                fragmentManager.beginTransaction().replace(R.id.container, new VideoPlay()).commit();
                mToolbarTitleTv.setText("视频");
                break;
            case R.id.funny_page://趣图
                inIdImg();
                fragmentManager.beginTransaction().replace(R.id.container, new FunnyImg()).commit();
                mToolbarTitleTv.setText("趣图");
                break;
            case R.id.toolbar_left_btn://头像的点击事件
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.toolbar_title_tv://标题

                break;
            case R.id.toolbar_right_tv://发表段子
                Intent intent = new Intent(MyApp.context, IssueActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    /**
     * 为底部导航栏赋值
     */
    private void inIdImg() {
        if (mRecommendPage.isChecked()) {
            //设置图片
            Drawable recommendDrawable = getResources().getDrawable(R.drawable.raw_1500085367);
            recommendDrawable.setBounds(0, 5, 50, 55);
            mRecommendPage.setCompoundDrawables(null, recommendDrawable, null, null);
            //设置字体颜色
            mRecommendPage.setTextColor(Color.parseColor("#03A9F4"));
        } else {
            //设置图片
            Drawable recommendDrawable0 = getResources().getDrawable(R.drawable.raw_1500083878);
            recommendDrawable0.setBounds(0, 5, 50, 55);
            mRecommendPage.setCompoundDrawables(null, recommendDrawable0, null, null);
            //设置字体颜色
            mRecommendPage.setTextColor(Color.parseColor("#000000"));
        }

        if (mCrossTalk.isChecked()) {
            //设置图片
            Drawable recommendDrawable2 = getResources().getDrawable(R.drawable.raw_1500085899);
            recommendDrawable2.setBounds(0, 5, 50, 55);
            mCrossTalk.setCompoundDrawables(null, recommendDrawable2, null, null);
            //设置字体颜色
            mCrossTalk.setTextColor(Color.parseColor("#03A9F4"));
        } else {
            //设置图片
            Drawable recommendDrawable02 = getResources().getDrawable(R.drawable.raw_1500085327);
            recommendDrawable02.setBounds(0, 5, 50, 55);
            mCrossTalk.setCompoundDrawables(null, recommendDrawable02, null, null);
            //设置字体颜色
            mCrossTalk.setTextColor(Color.parseColor("#000000"));
        }
        if (mVideoPage.isChecked()) {
            //设置图片
            Drawable recommendDrawable3 = getResources().getDrawable(R.drawable.raw_1500086067);
            recommendDrawable3.setBounds(0, 5, 50, 55);
            mVideoPage.setCompoundDrawables(null, recommendDrawable3, null, null);
            //设置字体颜色
            mVideoPage.setTextColor(Color.parseColor("#03A9F4"));
        } else {
            //设置图片
            Drawable recommendDrawable03 = getResources().getDrawable(R.drawable.raw_1500083686);
            recommendDrawable03.setBounds(0, 5, 50, 55);
            mVideoPage.setCompoundDrawables(null, recommendDrawable03, null, null);
            //设置字体颜色
            mVideoPage.setTextColor(Color.parseColor("#000000"));
        }


        if (mFunnyPage.isChecked()) {
            //设置图片
            Drawable recommendDrawable4 = getResources().getDrawable(R.drawable.pic2);
            recommendDrawable4.setBounds(0, 5, 50, 55);
            mFunnyPage.setCompoundDrawables(null, recommendDrawable4, null, null);
            //设置字体颜色
            mFunnyPage.setTextColor(Color.parseColor("#03A9F4"));
        } else {
            //设置图片
            Drawable recommendDrawable04 = getResources().getDrawable(R.drawable.pic);
            recommendDrawable04.setBounds(0, 5, 50, 55);
            mFunnyPage.setCompoundDrawables(null, recommendDrawable04, null, null);
            //设置字体颜色
            mFunnyPage.setTextColor(Color.parseColor("#000000"));
        }

    }
}