package com.example.myyikezhong.constent;

import com.example.myyikezhong.fragment.recommend.hot.bean.HotFollowBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    //轮播图
//     @GET("quarter/getAd")
//     Observable<AdBean> getAd();
    //推荐的视频
//    @GET("quarter/getVideos")
//    Observable<VideosBean> getVideos(@Query("uid") String uid, @Query("type") String type, @Query("page") String page);
    //段子
    @GET("quarter/getJokes?page=10&source=android&appVersion=101&token=8AF0B64F4D807A8D8AAFC76249ED7B5D")
    Call<ResponseBody> getJokes();

    //视频热门
    @GET("quarter/getHotVideos?page=1&source=android&appVersion=101&token=8AF0B64F4D807A8D8AAFC76249ED7B5D")
    Call<ResponseBody> getHotVideos();
////视频附近
//    @GET("quarter/getNearVideos")
//    Observable<VideosNearBean>getNearVideos(@Query("page") String page, @Query("token") String token);
////视频详情
//@GET("quarter/getVideoDetail")
//    Observable<DetailBean> getVideoDetai(@Query("wid") String wid);
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
}