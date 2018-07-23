package com.example.wsnbb.fragment.video.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.wsnbb.MyApp;
import com.example.wsnbb.R;
import com.example.wsnbb.constent.Api;
import com.example.wsnbb.constent.ApiService;
import com.example.wsnbb.fragment.video.bean.VideoDetailsBean;
import com.google.gson.Gson;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by 撩个小媳妇 on 2018/7/15.
 */

public class VideoDetails extends AppCompatActivity {
    @BindView(R.id.img_break)
    ImageView mImgBreak;
    @BindView(R.id.love_heart)
    ImageView mLoveHeart;
    @BindView(R.id.heart_broken)
    ImageView mHeartBroken;
    @BindView(R.id.share)
    ImageView mShare;
//    @BindView(R.id.detail_smile_view)
//    ImageView mDetail_smile_view;
    @BindView(R.id.linearLayout)
    LinearLayout mLinearLayout;
    @BindView(R.id.detailVideos)
    JCVideoPlayerStandard mDetailVideos;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_num)
    TextView mTvNum;
    @BindView(R.id.tv_time)
    TextView mTvTime;
    private  boolean flag;
    private  boolean isFlag;
    private Retrofit build;

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            VideoDetailsBean.DataBean data = (VideoDetailsBean.DataBean) msg.obj;
            //加载视频
            mDetailVideos.setUp(data.getVideoUrl()
                    , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "视频播放");
            //加载图片
            Glide.with(MyApp.context).load(data.getVideoUrl())
                    .into(mDetailVideos.thumbImageView);
            mDetailVideos.widthRatio = 4;//设置播放比例
            mDetailVideos.heightRatio = 3;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_details);
        ButterKnife.bind(this);
        initData();
    }


    /**
     * 获取数据
     */
    private void initData() {
        build = new Retrofit.Builder().baseUrl(Api.UUU).build();
        ApiService apiService = build.create(ApiService.class);
        final Call<ResponseBody> videoDetails = apiService.getVideoDetails();
        videoDetails.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    //获得数据
                    String string = response.body().string();
                    //解析
                    Gson gson = new Gson();
                    VideoDetailsBean videoDetailsBean = gson.fromJson(string, VideoDetailsBean.class);
                    VideoDetailsBean.DataBean data = videoDetailsBean.getData();
                    Message obtain = Message.obtain();
                    obtain.obj = data;
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

    @OnClick({R.id.img_break, R.id.love_heart, R.id.heart_broken, R.id.share, R.id.linearLayout, R.id.detailVideos})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_break:
                finish();//返回上一层
                break;
//            case R.id.detail_smile_view:
                //跳转用户页面
//                Intent intent = new Intent(MyApp.context, YongHuActivity.class);
//                startActivity(intent);
//                finish();
//                break;
            case R.id.love_heart:
                if (flag){
                    flag=false;
                    mLoveHeart.setImageResource(R.drawable.raw_1499933216);
                }else {
                    flag=true;
                    mLoveHeart.setImageResource(R.drawable.hreatlove);
                }

                break;
            case R.id.heart_broken:
                if (isFlag){
                    isFlag=false;
                    mHeartBroken.setImageResource(R.drawable.raw_1499933217);
                }else {
                    isFlag=true;
                    mHeartBroken.setImageResource(R.drawable.raw_149993321634);

                }
                break;
            case R.id.share:
                UMImage image = new UMImage(MyApp.context, "http://img.zcool" +
                        ".cn/community/01d881579dc3620000018c1b430c4b.JPG@3000w_1l_2o_100sh.jpg");//网络图片

                new ShareAction(VideoDetails.this).withMedia(image).setDisplayList
                        (SHARE_MEDIA.WEIXIN, SHARE_MEDIA
                                        .WEIXIN_CIRCLE,
                                SHARE_MEDIA.QQ,
                                SHARE_MEDIA.QZONE)
                        .setCallback(shareListener).open();

                break;
            case R.id.detailVideos:

                break;
        }
    }

    /**
     * 分享
     */
    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(MyApp.context,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(MyApp.context,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(MyApp.context,"取消了",Toast.LENGTH_LONG).show();

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        handler.removeCallbacksAndMessages(null);
    }
}
