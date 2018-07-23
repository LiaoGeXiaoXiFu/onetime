package com.example.wsnbb.fragment.video.hotvideo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.wsnbb.R;
import com.example.wsnbb.fragment.video.hotvideo.bean.HotVideoBean;

import java.util.List;


/**
 * Created by 撩个小媳妇 on 2018/7/14.
 */

public class HotVideoAdapter extends RecyclerView.Adapter<HotVideoAdapter.ViewHolder>{
    List<HotVideoBean.ResultsBean> results;
    Context context;

    public HotVideoAdapter(List<HotVideoBean.ResultsBean> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public HotVideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.hot_video_item, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }
    @Override
    public void onBindViewHolder(@NonNull final HotVideoAdapter.ViewHolder holder, final int position) {
        //加载图片
        Glide.with(context).load(results.get(position).getUrl()).into(holder.img_video);
        holder.img_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.onItemClick(v,position);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img_video;

        public ViewHolder(View itemView) {
            super(itemView);
            img_video = itemView.findViewById(R.id.img_video);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    //写一个回调方法
    private OnItemClickListener mListener;
    public void setOnItemClickListener(OnItemClickListener listener){
        this.mListener = listener;
    }
}
