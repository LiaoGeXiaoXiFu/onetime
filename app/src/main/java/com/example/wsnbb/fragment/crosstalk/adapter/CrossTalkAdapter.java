package com.example.wsnbb.fragment.crosstalk.adapter;

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
import com.example.wsnbb.fragment.crosstalk.bean.CrossBean;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import java.util.List;


/**
 * Created by 撩个小媳妇 on 2018/7/12.
 */

public class CrossTalkAdapter extends RecyclerView.Adapter<CrossTalkAdapter.ViewHolder> {
    Context context;
    List<CrossBean.DataBean> data;

    public CrossTalkAdapter(Context context, List<CrossBean.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public CrossTalkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //绑定视图
        View inflate = View.inflate(context, R.layout.crosstalk_item, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CrossTalkAdapter.ViewHolder holder, int position) {
        //用户名
        holder.rc_name.setText(data.get(position).getUser().getNickname());
        //创建时间
        holder.rc_time.setText(data.get(position).getCreateTime());
        //用户头像
        Glide.with(context).load(data.get(position).getUser().getIcon()).into(holder.rc_img);
        //正文
        holder.tjPb.setText(data.get(position).getContent());
        holder.talk_item_floating_xihuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "热门开始分享", Toast.LENGTH_SHORT).show();
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

        private final TextView rc_name;
        private final TextView rc_time;
        private final FloatingActionButton talk_item_floating_xihuan;
        private final TextView tjPb;
        private final ImageView rc_img;

        public ViewHolder(View itemView) {
            super(itemView);
            rc_img = itemView.findViewById(R.id.rc_img);
            rc_name = itemView.findViewById(R.id.rc_name);
            rc_time = itemView.findViewById(R.id.rc_time);
            talk_item_floating_xihuan = itemView.findViewById(R.id.talk_item_floating_xihuan);
            tjPb = itemView.findViewById(R.id.tjPb);
        }
    }
}
