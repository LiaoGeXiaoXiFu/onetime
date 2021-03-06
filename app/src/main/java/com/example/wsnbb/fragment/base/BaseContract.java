package com.example.wsnbb.fragment.base;

public interface BaseContract {
    interface  BasePersenter<T extends BaseView> {
        void attchView(T view);

        void detachView();

    }
    interface  BaseView{
        void showLoading();

        void dismissLoading();
    }
}