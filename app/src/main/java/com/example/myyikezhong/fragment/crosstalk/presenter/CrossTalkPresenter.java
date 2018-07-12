package com.example.myyikezhong.fragment.crosstalk.presenter;


import com.example.myyikezhong.constent.Api;
import com.example.myyikezhong.fragment.crosstalk.bean.CrossBean;
import com.example.myyikezhong.fragment.crosstalk.model.CrossTalkModel;
import com.example.myyikezhong.fragment.crosstalk.view.CrossTalkView;

/**
 * Created by 撩个小媳妇 on 2018/7/12.
 */

public class CrossTalkPresenter {
    private CrossTalkModel talkModel;
    private CrossTalkView crossTalkView;
    public CrossTalkPresenter(CrossTalkView crossTalkView){
        this.crossTalkView = crossTalkView;
        talkModel = new CrossTalkModel();
    }
    public void getData(){
        talkModel.getCro(Api.UUU, new CrossTalkModel.ICrossTalkModel() {
            @Override
            public void getData(CrossBean getCrossBean) {
                if (crossTalkView != null) {
                    crossTalkView.showData(getCrossBean);
                }
            }
        });
    }

    public void detach() {
        if (crossTalkView != null) {
            crossTalkView = null;
        }
    }

}
