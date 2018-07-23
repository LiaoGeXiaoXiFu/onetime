package com.example.wsnbb.fragment.crosstalk.bean;

import java.util.List;

/**
 * Created by 撩个小媳妇 on 2018/7/12.
 */

public class CrossBean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"我家宠物今天没吃早餐！哎！心疼了啊！","createTime":"2018-06-21T11:24:16","imgUrls":null,"jid":3233,"praiseNum":null,"shareNum":null,"uid":13550,"user":{"age":"age","fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1530079216945aaaa.jpg","nickname":"仅此而已","praiseNum":"null"}},{"commentNum":null,"content":"王过过小可爱","createTime":"2018-06-20T20:52:36","imgUrls":null,"jid":3232,"praiseNum":null,"shareNum":null,"uid":10152,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"购房合同返回","createTime":"2018-06-20T15:54:03","imgUrls":null,"jid":3231,"praiseNum":null,"shareNum":null,"uid":10206,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1527246812917header.jpg","nickname":"兰昊琼","praiseNum":"null"}},{"commentNum":null,"content":"的数GV发 我噶啥任务  的深V该公司给  \nsdgrg\n\n\n\n第三个吧","createTime":"2018-06-20T15:53:52","imgUrls":null,"jid":3230,"praiseNum":null,"shareNum":null,"uid":10206,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1527246812917header.jpg","nickname":"兰昊琼","praiseNum":"null"}},{"commentNum":null,"content":"第一行代码启动了","createTime":"2018-06-20T09:39:17","imgUrls":null,"jid":3229,"praiseNum":null,"shareNum":null,"uid":15416,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"null","praiseNum":"null"}},{"commentNum":null,"content":"我是贾立杰，第一条段子发布，试验阶段","createTime":"2018-06-20T09:03:35","imgUrls":null,"jid":3228,"praiseNum":null,"shareNum":null,"uid":15536,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"八维和studio占用了我半生","praiseNum":"null"}},{"commentNum":null,"content":"111","createTime":"2018-06-19T20:40:07","imgUrls":null,"jid":3227,"praiseNum":null,"shareNum":null,"uid":14381,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1527215718799header.jpg","nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"好 好","createTime":"2018-06-19T19:39:06","imgUrls":null,"jid":3226,"praiseNum":null,"shareNum":null,"uid":10152,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"王小过pk杜小旺","createTime":"2018-06-19T19:37:45","imgUrls":null,"jid":3225,"praiseNum":null,"shareNum":null,"uid":10152,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"吴应熊pk吴卫熊","createTime":"2018-06-19T19:33:40","imgUrls":null,"jid":3224,"praiseNum":null,"shareNum":null,"uid":10152,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : 我家宠物今天没吃早餐！哎！心疼了啊！
         * createTime : 2018-06-21T11:24:16
         * imgUrls : null
         * jid : 3233
         * praiseNum : null
         * shareNum : null
         * uid : 13550
         * user : {"age":"age","fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1530079216945aaaa.jpg","nickname":"仅此而已","praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private Object imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(Object imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : age
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/1530079216945aaaa.jpg
             * nickname : 仅此而已
             * praiseNum : null
             */

            private String age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public String getAge() {
                return age;
            }

            public void setAge(String age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
