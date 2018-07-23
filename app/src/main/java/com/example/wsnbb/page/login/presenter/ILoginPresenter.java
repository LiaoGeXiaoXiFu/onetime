package com.example.wsnbb.page.login.presenter;

public interface ILoginPresenter {

    void login(String mobile, String password);
    void onFailed(String str);
    void onSuccess(Object o);
    void onDestory();
}