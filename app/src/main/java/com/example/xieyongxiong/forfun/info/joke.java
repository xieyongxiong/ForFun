package com.example.xieyongxiong.forfun.info;

import java.util.List;

/**
 * Created by xieyongxiong on 16-7-6.
 */
public class joke {


    /**
     * reason : success
     * result : [{"content":"\u2026给闺女买了一双小皮鞋，花了两张毛爷爷，小鞋很结实，闺女穿了好多天后要我给她买鞋，说不喜欢了，我就各种教育，比如要穿破之后买，要知道省钱\u2026\u2026等等。今天再回去的时候，姑娘左手拎着残破的鞋子，右手拿着剪刀，跑过来说:爸爸，现在可以买新的鞋子了吧！来，过来，爸爸保证不打你，我的亲闺女。","hashId":"bf56a16fd4ea0ffc55bf11c3f088855a","unixtime":"1431447231"},{"content":"高中一班主任陈老师，因其身高比较矮，同学给起了个外号叫\u201c武大郎\u201d，后来被老师得知，要求同学带家长，同学跟家里说了原委，家长带着同学到老师办公室致歉，该同学家长进门就说:\u201c武老师，小孩子不懂事，还忘您能海涵\u201d，后来同学告诉我们班主任当时那表情都抽搐了，足足让我们笑了一学期。","hashId":"07f01a03526f4f3f8310dc34a55e0eb2","unixtime":"1431447231"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    /**
     * content : …给闺女买了一双小皮鞋，花了两张毛爷爷，小鞋很结实，闺女穿了好多天后要我给她买鞋，说不喜欢了，我就各种教育，比如要穿破之后买，要知道省钱……等等。今天再回去的时候，姑娘左手拎着残破的鞋子，右手拿着剪刀，跑过来说:爸爸，现在可以买新的鞋子了吧！来，过来，爸爸保证不打你，我的亲闺女。
     * hashId : bf56a16fd4ea0ffc55bf11c3f088855a
     * unixtime : 1431447231
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
    }
}

