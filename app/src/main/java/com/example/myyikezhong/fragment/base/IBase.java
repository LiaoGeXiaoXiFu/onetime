package com.example.myyikezhong.fragment.base;

import android.view.View;

public interface IBase {
    int getContentLayout();
    void inject();
    void initView(View view);
}