package com.example.wsnbb.fragment.crosstalk;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wsnbb.R;
import com.example.wsnbb.fragment.crosstalk.adapter.CrossTalkAdapter;
import com.example.wsnbb.fragment.crosstalk.bean.CrossBean;
import com.example.wsnbb.fragment.crosstalk.presenter.CrossTalkPresenter;
import com.example.wsnbb.fragment.crosstalk.view.CrossTalkView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 撩个小媳妇 on 2018/7/6.
 */

public class CrossTalk extends Fragment implements CrossTalkView{
    @BindView(R.id.rv_crosstalk)
    RecyclerView mRvCrosstalk;
    private Unbinder unbinder;
    private CrossTalkPresenter crossTalkPresenter;
    private CrossTalkAdapter crossTalkAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crosstalk, container, false);
        unbinder = ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        crossTalkPresenter = new CrossTalkPresenter(this);
        crossTalkPresenter.getData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        crossTalkPresenter.detach();
    }

    @Override
    public void showData(CrossBean getCrossBean) {
        List<CrossBean.DataBean> data = getCrossBean.getData();
        //设置适配器
        if (crossTalkAdapter == null){
            crossTalkAdapter = new CrossTalkAdapter(getActivity(),data);
        }
        //设置布局管理器--写在设置适配器之上
        mRvCrosstalk.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mRvCrosstalk.setAdapter(crossTalkAdapter);
    }

}
