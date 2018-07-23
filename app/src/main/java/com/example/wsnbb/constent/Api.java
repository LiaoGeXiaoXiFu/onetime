package com.example.wsnbb.constent;

/**
 * Created by 撩个小媳妇 on 2018/7/6.
 */

public class Api {
    public static final String UUU= "https://www.zhaoapi.cn/";
    public static final String MMM= "http://gank.io/api/data/";
    public static final String MY_ADDRESS = "https://www.zhaoapi.cn/";

    public static final String LOGIN_URL = MY_ADDRESS + "user/login";
    public static final String REGISTER_URL = MY_ADDRESS + "user/reg";
    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";

    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_TEL = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
}
