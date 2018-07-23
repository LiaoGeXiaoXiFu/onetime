package com.example.wsnbb.fragment.recommend.hot;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.wsnbb.MyApp;
import com.example.wsnbb.R;
import com.example.wsnbb.constent.Api;
import com.example.wsnbb.constent.ApiService;
import com.example.wsnbb.fragment.recommend.hot.adapter.HotAdapter;
import com.example.wsnbb.fragment.recommend.hot.bean.HotFollowBean;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by 撩个小媳妇 on 2018/7/6.
 */

public class Hot extends Fragment {

    @BindView(R.id.ban_hot)
    Banner mBanHot;
    @BindView(R.id.rv_hot)
    RecyclerView mRvHot;
    private Retrofit build;
    private View view;
    private Unbinder unbinder;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){

        private HotAdapter adapter;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<HotFollowBean.DataBean> data = (List<HotFollowBean.DataBean>) msg.obj;
            //设置适配器
            mRvHot.setLayoutManager(new LinearLayoutManager(MyApp.context,LinearLayoutManager.VERTICAL,false));
//            mRvHot.setLayoutManager(new GridLayoutManager(MyApp.context,2));
            if (adapter == null){
                adapter = new HotAdapter(data, MyApp.context);
            }
            mRvHot.setAdapter(adapter);
        }

    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        //设置内置样式，共有六种可以点入方法内逐一体验使用。
        mBanHot.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        mBanHot.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        });
        //设置图片网址或地址的集合
        mBanHot.setImages(list_path);
        //设置轮播图的标题集合
        mBanHot.setBannerTitles(list_title);
        //设置轮播间隔时间
        mBanHot.setDelayTime(2000);
        //设置是否为自动轮播，默认是“true”。
        mBanHot.isAutoPlay(true);
        //设置指示器的位置，小圆点，左中右。
        mBanHot.setIndicatorGravity(BannerConfig.CENTER)
                //必须最后调用的方法，启动轮播图。
                .start();
        return view;
    }

    private void initData() {
        //放图片地址的集合
        list_path = new ArrayList<>();
        //放标题的集合
        list_title = new ArrayList<>();
        //为list赋值
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic259ohaj30ci08c74r.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2b16zuj30ci08cwf4.jpg");
        list_path.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic2e7vsaj30ci08cglz.jpg");
        list_title.add("总有一个名字，能让你嘴角上翘，再眼泪下掉");
        list_title.add("看一眼就记住的人怎么甘心做朋友");
        list_title.add("遗憾吗，我们就这样莫名其妙的谁也不喜欢谁了");
        list_title.add("不经历撕心裂肺，怎么能面不改色，处事不惊");


        //rv的展示  8AF0B64F4D807A8D8AAFC76249ED7B5D
        build = new Retrofit.Builder().baseUrl(Api.UUU).build();
        ApiService apiService = build.create(ApiService.class);
        Call<ResponseBody> hotVideos = apiService.getHotVideos();

        hotVideos.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //获得数据
                try {
                    String string = response.body().string();
                    //解析
                    Gson gson = new Gson();
                    HotFollowBean hotFollowBean = gson.fromJson(string, HotFollowBean.class);
                    List<HotFollowBean.DataBean> data = hotFollowBean.getData();
                    Message obtain = Message.obtain();
                    obtain.obj = data;
                    //发送给handler
                    handler.sendMessage(obtain);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }

    @OnClick({R.id.ban_hot, R.id.rv_hot})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.ban_hot:
                break;
            case R.id.rv_hot:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        //清空消息队列
        handler.removeCallbacksAndMessages(null);
    }
}
