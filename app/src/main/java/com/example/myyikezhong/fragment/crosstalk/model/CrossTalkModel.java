package com.example.myyikezhong.fragment.crosstalk.model;

import com.example.myyikezhong.constent.ApiService;
import com.example.myyikezhong.fragment.crosstalk.bean.CrossBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by 撩个小媳妇 on 2018/7/12.
 */

public class CrossTalkModel {
    public ICrossTalkModel iCrossTalkModel;
    private Retrofit build;
    public void getCro(String url,final ICrossTalkModel iCrossTalkModel){
        build = new Retrofit.Builder().baseUrl(url).build();
        ApiService apiService = build.create(ApiService.class);
        Call<ResponseBody> jokes = apiService.getJokes();
        jokes.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    //获得数据
                    String string = response.body().string();
                    //解析
                    Gson gson = new Gson();
                    CrossBean crossBean = gson.fromJson(string, CrossBean.class);
                    iCrossTalkModel.getData(crossBean);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    public interface ICrossTalkModel{
        void getData(CrossBean getCrossBean);
    }
}
