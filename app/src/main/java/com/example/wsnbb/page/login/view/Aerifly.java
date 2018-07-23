package com.example.wsnbb.page.login.view;

import android.content.Context;
import android.widget.Toast;

import com.example.wsnbb.constent.Api;

public class Aerifly {
    //手机号验证
    public static boolean isMobile(Context content, String tel) {

        if (tel.matches(Api.REGEX_TEL)) {

        } else {
            Toast.makeText(content, "手机号码格式不正确", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    //密码验证
    public static boolean isPassword(Context content, String pwd) {
        if (pwd.matches(Api.REGEX_PASSWORD)) {

        }else {
            Toast.makeText(content, "密码长度为6-20位不能包含特殊字符", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }
}