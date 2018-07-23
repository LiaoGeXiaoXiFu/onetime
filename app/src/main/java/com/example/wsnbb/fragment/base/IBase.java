package com.example.wsnbb.fragment.base;

import android.view.View;

public interface IBase {
    int getContentLayout();
    void inject();
    void initView(View view);
}