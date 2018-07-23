package com.example.wsnbb.page.login.model;

import com.example.wsnbb.page.login.presenter.ILoginPresenter;

public interface ILoginModel {

    void login(String mobile, String password, ILoginPresenter iLoginPresenter);
}