package com.example.wsnbb.fragment.base;

public class BasePersenter<T extends BaseContract.BaseView> implements  BaseContract.BasePersenter<T> {
  protected  T mView;
    @Override
    public void attchView(T view) {
        this.mView=view;
    }

    @Override
    public void detachView() {
         if (mView!=null){
             mView=null;
         }
    }
}