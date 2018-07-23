package com.example.wsnbb.page.login.model;

import com.example.wsnbb.constent.Api;
import com.example.wsnbb.page.login.bean.LoginBean;
import com.example.wsnbb.page.login.presenter.ILoginPresenter;
import com.example.wsnbb.utils.OkhttpUtils;
import com.example.wsnbb.utils.OnNetListener;
import com.google.gson.Gson;

public class LoginModel implements ILoginModel {

    @Override
    public void login(String mobile, String password, final ILoginPresenter iLoginPresenter) {
        String url = Api.LOGIN_URL + "?mobile=" + mobile + "&password=" + password;

        OkhttpUtils.getInstance().doGet(url, new OnNetListener() {
            @Override
            public void onSuccess(String result) {
                LoginBean loginBean = new Gson().fromJson(result, LoginBean.class);
                if ("0".equals(loginBean.getCode())) {
                    iLoginPresenter.onSuccess(result);
                }
            }

            @Override
            public void onFailed(Exception e) {
                iLoginPresenter.onFailed(e + "");
            }
        });
    }
}