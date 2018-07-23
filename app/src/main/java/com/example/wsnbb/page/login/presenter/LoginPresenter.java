package com.example.wsnbb.page.login.presenter;

import com.example.wsnbb.MyApp;
import com.example.wsnbb.page.login.bean.LoginBean;
import com.example.wsnbb.page.login.model.ILoginModel;
import com.example.wsnbb.page.login.model.LoginModel;
import com.example.wsnbb.page.login.view.Aerifly;
import com.example.wsnbb.page.login.view.ILoginActivity;
import com.google.gson.Gson;

public class LoginPresenter implements ILoginPresenter {

    private ILoginActivity iLoginActivity;
    private ILoginModel loginModel;

    public LoginPresenter(ILoginActivity iLoginActivity) {
        this.iLoginActivity = iLoginActivity;
        loginModel = new LoginModel();
    }

    @Override
    public void login(String mobile, String password) {
        //判断
        boolean mob = Aerifly.isMobile(MyApp.context, mobile);
        boolean pwd = Aerifly.isPassword(MyApp.context, password);
        if (mob && pwd) {
            loginModel.login(mobile, password, this);
        }
    }

    @Override
    public void onFailed(String str) {
        if (null == iLoginActivity) {
            return;
        }
        iLoginActivity.onFailed(str);
    }

    @Override
    public void onSuccess(Object o) {
        if (null == iLoginActivity) {
            return;
        }
        String result = o.toString();
        Gson g = new Gson();
        LoginBean supperClass = g.fromJson(result, LoginBean.class);
        String code = supperClass.getCode();
        if (code.equals("0")) {
            iLoginActivity.onSuccess(result);
        } else {
            iLoginActivity.onFailed(supperClass.getMsg());
        }
    }

    @Override
    public void onDestory() {
        if (null != iLoginActivity) {
            iLoginActivity = null;
        }
    }
}