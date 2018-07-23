package com.example.wsnbb.fragment.video.hotvideo.presenter;

import com.example.wsnbb.constent.Api;
import com.example.wsnbb.fragment.video.hotvideo.bean.HotVideoBean;
import com.example.wsnbb.fragment.video.hotvideo.model.HotVideoModel;
import com.example.wsnbb.fragment.video.hotvideo.view.HotVideoView;
/**
 * ━━━━━━草泥马神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛Code is far away from bug with the animal protecting
 * 　　　　┃　　　┃ 神兽保佑,代码无bug
 * 　　　　┃　　　┃
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * <p>
 * ━━━━━━当善良的人摘下面具.你连下跪的机会都没有━━━━━━
 * Created by 撩个小媳妇 on 2018/7/14.
 * 视频热门展示-逻辑层
 */

public class HotVideoPresenter {
    private HotVideoModel hotVideoModel;
    private HotVideoView hotVideoView;

    public HotVideoPresenter(HotVideoView hotVideoView) {
        this.hotVideoView = hotVideoView;
        hotVideoModel = new HotVideoModel();
    }

    /**
     * 绑定视图
     */
    public void getData() {
        hotVideoModel.getHotVideo(Api.MMM, new HotVideoModel.IHotVideoModel() {
            @Override
            public void getData(HotVideoBean getHotVideoBean) {
                if (hotVideoView != null) {
                    hotVideoView.showData(getHotVideoBean);
                }
            }
        });
    }

    /**
     * 解绑
     */
    public void detach() {
        if (hotVideoView != null) {
            hotVideoView = null;
        }
    }
}
