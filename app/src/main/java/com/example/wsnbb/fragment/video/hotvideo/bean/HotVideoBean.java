package com.example.wsnbb.fragment.video.hotvideo.bean;

import java.util.List;

/**
 * Created by 撩个小媳妇 on 2018/7/14.
 */

public class HotVideoBean {

    /**
     * error : false
     * results : [{"_id":"5aff4645421aa95f55cab5e7","createdAt":"2018-05-15T00:00:00.0Z","desc":"2018-05-15","publishedAt":"2018-05-15T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1frepqtwifwj30no0ti47n.jpg","used":true,"who":"lijinshanmx"},{"_id":"5aff4645421aa95f55cab5e0","createdAt":"2018-05-14T00:00:00.0Z","desc":"2018-05-14","publishedAt":"2018-05-14T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1frepr2rhxvj30qo0yjth8.jpg","used":true,"who":"lijinshanmx"},{"_id":"5aff4645421aa95f55cab5e4","createdAt":"2018-05-13T00:00:00.0Z","desc":"2018-05-13","publishedAt":"2018-05-13T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1freprc128lj30sg15m12u.jpg","used":true,"who":"lijinshanmx"},{"_id":"5aff4645421aa95f55cab5e2","createdAt":"2018-05-12T00:00:00.0Z","desc":"2018-05-12","publishedAt":"2018-05-12T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1freprk6sd7j30sg15h7d2.jpg","used":true,"who":"lijinshanmx"},{"_id":"5aff4645421aa95f55cab5e3","createdAt":"2018-05-11T00:00:00.0Z","desc":"2018-05-11","publishedAt":"2018-05-11T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1freprsjjwmj30sg15dth0.jpg","used":true,"who":"lijinshanmx"},{"_id":"5aff4645421aa95f55cab5e1","createdAt":"2018-05-10T00:00:00.0Z","desc":"2018-05-10","publishedAt":"2018-05-10T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1freps07ubij30sg1dgwr7.jpg","used":true,"who":"lijinshanmx"},{"_id":"5aff4645421aa95f55cab5de","createdAt":"2018-05-09T00:00:00.0Z","desc":"2018-05-09","publishedAt":"2018-05-09T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1freps89wc7j30no0uk45j.jpg","used":true,"who":"lijinshanmx"},{"_id":"5aff4645421aa95f55cab5dd","createdAt":"2018-05-08T00:00:00.0Z","desc":"2018-05-08","publishedAt":"2018-05-08T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1frepsi3o15j30k80oidkd.jpg","used":true,"who":"lijinshanmx"},{"_id":"5aff4645421aa95f55cab5db","createdAt":"2018-05-06T00:00:00.0Z","desc":"2018-05-06","publishedAt":"2018-05-06T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1frepspsrhyj30ku0qsjuc.jpg","used":true,"who":"lijinshanmx"},{"_id":"5aff4645421aa95f55cab5da","createdAt":"2018-05-05T00:00:00.0Z","desc":"2018-05-05","publishedAt":"2018-05-05T00:00:00.0Z","source":"web","type":"福利","url":"http://ww1.sinaimg.cn/large/0065oQSqly1frepsy47grj30qo0y97en.jpg","used":true,"who":"lijinshanmx"}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 5aff4645421aa95f55cab5e7
         * createdAt : 2018-05-15T00:00:00.0Z
         * desc : 2018-05-15
         * publishedAt : 2018-05-15T00:00:00.0Z
         * source : web
         * type : 福利
         * url : http://ww1.sinaimg.cn/large/0065oQSqly1frepqtwifwj30no0ti47n.jpg
         * used : true
         * who : lijinshanmx
         */

        private String _id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private boolean used;
        private String who;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public boolean isUsed() {
            return used;
        }

        public void setUsed(boolean used) {
            this.used = used;
        }

        public String getWho() {
            return who;
        }

        public void setWho(String who) {
            this.who = who;
        }
    }
}
