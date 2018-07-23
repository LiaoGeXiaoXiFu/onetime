package com.example.wsnbb.fragment.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

/**
 * Created by 兰昊琼 on 2018/6/5.
 */

public abstract  class BaseFragment<T extends  BaseContract.BasePersenter> extends Fragment implements  BaseContract.BaseView,IBase {
   @Inject
   protected  T mPersenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject();
        if (mPersenter!=null){
            mPersenter.attchView(this);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View view=inflater.inflate(getContentLayout(),null);
     initView(view);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPersenter!=null){
            mPersenter.detachView();
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }
}
