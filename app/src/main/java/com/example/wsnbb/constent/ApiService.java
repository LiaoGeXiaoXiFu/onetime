package com.example.wsnbb.constent;

import com.example.wsnbb.page.login.bean.RegBean;
import com.example.wsnbb.page.login.bean.LoginBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    //轮播图
//     @GET("quarter/getAd")
//     Observable<AdBean> getAd();

    //视频热门
    @GET("%E7%A6%8F%E5%88%A9/10/5")
    Call<ResponseBody> getVideos();

    //段子
    @GET("quarter/getJokes?page=10&source=android&appVersion=101&token=8AF0B64F4D807A8D8AAFC76249ED7B5D")
    Call<ResponseBody> getJokes();

    //    推荐的视频
    @GET("quarter/getHotVideos?page=1&source=android&appVersion=101&token=8AF0B64F4D807A8D8AAFC76249ED7B5D")
    Call<ResponseBody> getHotVideos();

    ////视频附近
//    @GET("quarter/getNearVideos")
//    Observable<VideosNearBean>getNearVideos(@Query("page") String page, @Query("token") String token);
    //视频详情
    @GET("quarter/getVideoDetail?wid=282&source=android&appVersion=101")
    Call<ResponseBody> getVideoDetails();
//    //段子详情
//    @GET("quarter/getJokeDetail")
//    Observable<JokeDetailBean> getJokeDetail(@Query("jid") String jid);
    //点赞
//    @GET("quarter/praise")
//    Observable<ParsieBean> getPraise(@Query("uid") String uid, @Query("wid") String wid, @Query("token") String token);
//  //添加收藏
//    @GET("quarter/addFavorite")
//    Observable<ParsieBean> addFavorite(@Query("uid") String uid,@Query("wid") String wid,@Query("token") String token);
//    //取消收藏
//    @GET("quarter/cancelFavorite")
//    Observable<ParsieBean> cancelFavorite(@Query("uid") String uid,@Query("wid") String wid,@Query("token") String token);

    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginBean> login(@Field("mobile") String mobile,
                                @Field("password") String password);

    //注册
    @FormUrlEncoded
    @POST("quarter/register")
    Observable<RegBean> reg(@Field("mobile") String mobile,
                            @Field("password") String password);
}