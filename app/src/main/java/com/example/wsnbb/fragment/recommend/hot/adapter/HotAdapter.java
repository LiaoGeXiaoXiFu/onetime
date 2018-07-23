package com.example.wsnbb.fragment.recommend.hot.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.wsnbb.R;
import com.example.wsnbb.fragment.recommend.hot.bean.HotFollowBean;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by 撩个小媳妇 on 2018/7/9.
 */

public class HotAdapter extends RecyclerView.Adapter<HotAdapter.ViewHolder> {
    List<HotFollowBean.DataBean> data;
    Context context;

    public HotAdapter(List<HotFollowBean.DataBean> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.tuijain_remen_item, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.rc_name.setText(data.get(position).getUser().getNickname());
        //名字
        holder.tjPb.setText(data.get(position).getWorkDesc());
        //时间
        holder.rc_time.setText(data.get(position).getCreateTime());
        //图片
        Glide.with(context).load(data.get(position).getUser().getIcon()).into(holder.rc_img);

        holder.videoplayer.TOOL_BAR_EXIST = false;
        holder.videoplayer.setUp(data.get(position).getVideoUrl()
                , JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "视频播放");
        Glide.with(context).load(data.get(position).getVideoUrl())
                .into(holder.videoplayer.thumbImageView);
        holder.videoplayer.widthRatio = 4;//播放比例
        holder.videoplayer.heightRatio = 3;

        //分享
        holder.talk_item_floating_xihuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"热门开始分享",Toast.LENGTH_SHORT).show();
                UMImage image = new UMImage(context, "http://img.zcool" +
                        ".cn/community/01d881579dc3620000018c1b430c4b.JPG@3000w_1l_2o_100sh.jpg");//网络图片

                new ShareAction((Activity) context).withMedia(image).setDisplayList
                        (SHARE_MEDIA.WEIXIN, SHARE_MEDIA
                                        .WEIXIN_CIRCLE,
                                SHARE_MEDIA.QQ,
                                SHARE_MEDIA.QZONE)
                        .setCallback(shareListener).open();

            }
        });

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
            Toast.makeText(context,"成功了",Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(context,"失败"+t.getMessage(),Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(context,"取消了",Toast.LENGTH_LONG).show();

        }
    };

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

//        private final SimpleDraweeView rc_img;
        private final TextView rc_name;
        private final TextView rc_time;
        private final FloatingActionsMenu talk_item_floating;
        private final FloatingActionButton talk_item_floating_a;
        private final FloatingActionButton talk_item_floating_b;
        private final FloatingActionButton talk_item_floating_xihuan;
        private final TextView tjPb;
        private final JCVideoPlayerStandard videoplayer;
        private final View view1;
        private final ImageView rc_img;

        public ViewHolder(View itemView) {
            super(itemView);
//            rc_img = itemView.findViewById(R.id.rc_img);
            rc_img = itemView.findViewById(R.id.rc_img);
            rc_name = itemView.findViewById(R.id.rc_name);
            rc_time = itemView.findViewById(R.id.rc_time);
            talk_item_floating = itemView.findViewById(R.id.talk_item_floating);
            talk_item_floating_a = itemView.findViewById(R.id.talk_item_floating_a);
            talk_item_floating_b = itemView.findViewById(R.id.talk_item_floating_b);
            talk_item_floating_xihuan = itemView.findViewById(R.id.talk_item_floating_xihuan);
            tjPb = itemView.findViewById(R.id.tjPb);
            videoplayer = itemView.findViewById(R.id.videoplayer);
            view1 = itemView.findViewById(R.id.view1);



        }
    }
}
