package com.example.wsnbb.page.regis.presenter;

public interface IRegisterPresenter {
    void login(String mobile, String password);
    void onFailed(String str);
    void onSuccess(Object o);

    void onDestory();
}