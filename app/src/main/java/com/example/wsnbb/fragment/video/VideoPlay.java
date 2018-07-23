package com.example.wsnbb.fragment.video;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wsnbb.R;
import com.example.wsnbb.fragment.video.hotvideo.HotVideo;
import com.example.wsnbb.fragment.video.hotvideo.HotVideoImg;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by 撩个小媳妇 on 2018/7/6.
 */

public class VideoPlay extends Fragment{
    @BindView(R.id.myTab)
    TabLayout mMyTab;
    @BindView(R.id.vp)
    ViewPager mVp;
    private Unbinder unbinder;
    private List<String> meuns;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        unbinder = ButterKnife.bind(this, view);
        initMenus();
        //设置适配器
        VideoPlay.MyAdapter myAdapter = new VideoPlay.MyAdapter( getChildFragmentManager() );
        mVp.setAdapter( myAdapter );
        mVp.setOffscreenPageLimit( meuns.size() );
        mMyTab.setupWithViewPager( mVp );
        return view;
    }

    /**
     * 添加数据
     */
    private void initMenus() {
        meuns = new ArrayList<>();
        meuns.add("热门");
        meuns.add("附近");
    }

    /**
     * 点击事件
     * @param v
     */
    @OnClick({R.id.myTab, R.id.vp})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.myTab:
                break;
            case R.id.vp:
                break;
        }
    }

    /**
     * 适配器
     */
    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super( fm );
        }

        @Override
        public Fragment getItem(int position) {
            //判断
            if (position==0){
                HotVideoImg nearByVideo = new HotVideoImg();
                return nearByVideo;
            }else {
                HotVideo hotVideoFragment = new HotVideo();
                return hotVideoFragment;
            }
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return meuns.get( position );
        }

        @Override
        public int getCount() {
            return meuns.size();
        }
    }

    /**
     * 销毁视图
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
