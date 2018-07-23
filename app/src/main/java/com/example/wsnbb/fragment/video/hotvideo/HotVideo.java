package com.example.wsnbb.fragment.video.hotvideo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wsnbb.MyApp;
import com.example.wsnbb.R;
import com.example.wsnbb.fragment.video.hotvideo.adapter.HotVideoAdapter;
import com.example.wsnbb.fragment.video.hotvideo.bean.HotVideoBean;
import com.example.wsnbb.fragment.video.hotvideo.presenter.HotVideoPresenter;
import com.example.wsnbb.fragment.video.hotvideo.view.HotVideoView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HotVideo extends Fragment implements HotVideoView {
    @BindView(R.id.rv_hot_video)
    RecyclerView mRvHotVideo;
    private Unbinder unbinder;
    private HotVideoPresenter hotVideoPresenter;
    private HotVideoAdapter hotVideoAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hot_video, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    /**
     * 调用P层逻辑
     */
    private void initData() {
        hotVideoPresenter = new HotVideoPresenter(this);
        hotVideoPresenter.getData();

    }

    /**
     * 获取数据
     * @param getHotVideoBean
     */
    @Override
    public void showData(HotVideoBean getHotVideoBean) {
        List<HotVideoBean.ResultsBean> results = getHotVideoBean.getResults();
        //设置适配器
        if (hotVideoAdapter == null){
            hotVideoAdapter = new HotVideoAdapter(results, MyApp.context);
        }
        //设置布局管理器
        mRvHotVideo.setLayoutManager(new GridLayoutManager(MyApp.context,2,GridLayoutManager.VERTICAL,false));
        mRvHotVideo.setAdapter(hotVideoAdapter);
        hotVideoAdapter.setOnItemClickListener(new HotVideoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MyApp.context,"点击了"+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * 销毁视图
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        //解绑的操作
        hotVideoPresenter.detach();
    }


}
