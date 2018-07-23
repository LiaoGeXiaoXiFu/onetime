package com.example.wsnbb.fragment.video.hotvideo.model;

import com.example.wsnbb.constent.ApiService;
import com.example.wsnbb.fragment.video.hotvideo.bean.HotVideoBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by 撩个小媳妇 on 2018/7/14.
 */

public class HotVideoModel {
    public IHotVideoModel iHotVideoModel;
    private Retrofit build;

    public void getHotVideo(String url,final IHotVideoModel iHotVideoModel){
        build = new Retrofit.Builder().baseUrl(url).build();
        ApiService apiService = build.create(ApiService.class);
        Call<ResponseBody> videos = apiService.getVideos();
        videos.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    //获得数据
                    String string = response.body().string();
                    //解析
                    Gson gson = new Gson();
                    HotVideoBean hotVideoBean = gson.fromJson(string, HotVideoBean.class);
                    iHotVideoModel.getData(hotVideoBean);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
    public interface IHotVideoModel{
        void getData(HotVideoBean getHotVideoBean);
    }
}
