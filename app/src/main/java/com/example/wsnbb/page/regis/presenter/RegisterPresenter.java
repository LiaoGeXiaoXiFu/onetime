package com.example.wsnbb.page.regis.presenter;

import com.example.wsnbb.MyApp;
import com.example.wsnbb.page.login.view.Aerifly;
import com.example.wsnbb.page.regis.model.IRegisterModel;
import com.example.wsnbb.page.regis.model.RegisterModel;
import com.example.wsnbb.page.regis.view.IRegister;

public class RegisterPresenter implements IRegisterPresenter {

    IRegister iRegister;
    IRegisterModel iRegisterModel;

    public RegisterPresenter(IRegister iRegister) {
        this.iRegister = iRegister;
        iRegisterModel = new RegisterModel();
    }

    @Override
    public void login(String mobile, String password) {
        //判断
        boolean mob = Aerifly.isMobile(MyApp.context, mobile);
        boolean pwd = Aerifly.isPassword(MyApp.context, password);
        if (mob && pwd) {
            iRegisterModel.Register(mobile, password, this);
        }
    }

    @Override
    public void onFailed(String str) {
        if (iRegister == null) {
            return;
        }

        iRegister.onFailed(str);
    }

    @Override
    public void onSuccess(Object o) {
        if (null == iRegister) {
            return;
        }

        iRegister.onSuccess(o.toString());

    }

    @Override
    public void onDestory() {
        if (null != iRegister) {
            iRegister = null;
        }
    }
}