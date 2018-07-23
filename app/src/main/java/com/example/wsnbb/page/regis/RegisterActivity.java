package com.example.wsnbb.page.regis;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wsnbb.R;
import com.example.wsnbb.fragment.recommend.Recommend;
import com.example.wsnbb.page.login.LoginActivity;
import com.example.wsnbb.page.login.bean.RegBean;
import com.example.wsnbb.page.regis.presenter.RegisterPresenter;
import com.example.wsnbb.page.regis.view.IRegister;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements IRegister{

    @BindView(R.id.img2)
    ImageView mImg2;
    @BindView(R.id.img1)
    ImageView mImg1;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_pass)
    EditText mEtPass;
    @BindView(R.id.btn_register)
    Button mBtnRegister;
    @BindView(R.id.tv_visitors)
    TextView mTvVisitors;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        registerPresenter = new RegisterPresenter(this);
    }

    @OnClick({R.id.img2, R.id.img1, R.id.et_name, R.id.et_pass, R.id.btn_register, R.id.tv_visitors})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.img2://返回
                finish();
                break;
            case R.id.img1:
                break;
            case R.id.et_name://账号
                break;
            case R.id.et_pass://密码
                break;
            case R.id.btn_register://注册
                String name = mEtName.getText().toString();
                String pass = mEtPass.getText().toString();
                registerPresenter.login(name,pass);

                break;
            case R.id.tv_visitors://游客登录
                Recommend recommend = new Recommend();
                FragmentManager fragmentM = getSupportFragmentManager();//管理对象
                FragmentTransaction trans = fragmentM.beginTransaction();//切换碎片
                trans.replace(R.id.login, recommend);
                trans.commit();
                break;
        }
    }

    @Override
    public void onFailed(String s) {

    }

    @Override
    public void onSuccess(Object o) {
        String result = o.toString();
        Gson g = new Gson();
        RegBean supperClassTwo = g.fromJson(result, RegBean.class);
        String code = supperClassTwo.getCode();
        if (code.equals("0")) {
            //跳转到login
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, supperClassTwo.getMsg(), Toast.LENGTH_SHORT).show();
            finish();
        } else {
            Toast.makeText(this, supperClassTwo.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }
}
