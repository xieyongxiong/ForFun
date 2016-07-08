package com.example.xieyongxiong.forfun.info;

import java.util.List;

/**
 * Created by xieyongxiong on 16-7-6.
 */
public class img {


    /**
     * reason : success
     * result : [{"content":"圣诞节还是不过了","hashId":"70FE1194DD6AD18F2A1676DA3D368F02","unixtime":"1419380597","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201412/24/70FE1194DD6AD18F2A1676DA3D368F02.png"},{"content":"直接从底抄啊","hashId":"9543D05C8A1160A3AC45532F5CC2073C","unixtime":"1419380610","url":"http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201412/24/9543D05C8A1160A3AC45532F5CC2073C.jpg"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    /**
     * content : 圣诞节还是不过了
     * hashId : 70FE1194DD6AD18F2A1676DA3D368F02
     * unixtime : 1419380597
     * url : http://juheimg.oss-cn-hangzhou.aliyuncs.com/joke/201412/24/70FE1194DD6AD18F2A1676DA3D368F02.png
     */

    private List<ResultBean> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        private String content;
        private String hashId;
        private String unixtime;
        private String url;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getHashId() {
            return hashId;
        }

        public void setHashId(String hashId) {
            this.hashId = hashId;
        }

        public String getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(String unixtime) {
            this.unixtime = unixtime;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
