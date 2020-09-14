package com.woshale.dingtalkrobottest.model.robot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.woshale.dingtalkrobottest.model.robot.content.Markdown;
import com.woshale.dingtalkrobottest.model.robot.content.Text;
import com.woshale.dingtalkrobottest.model.robot.content.interfaces.Content;

import java.util.List;

/**
 * 机器人进行回应model
 * 数据格式
 * -------------------------------------------------------------
 * {
 * "msgtype": "text",
 * "text": {
 * "content": "我就是我, @150XXXXXXXX 是不一样的烟火"
 * },
 * "at": {
 * "atMobiles": [
 * "150XXXXXXXX"
 * ],
 * "isAtAll": false
 * }
 * }
 * -------------------------------------------------------------
 *
 * @author Carrot
 * @since 2020/9/14 0:44
 */
public class PostRobotResponse {

    /**
     * 文本类型名称
     */
    private String msgtype;
    /**
     * 文本类型-text
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Content text;
    /**
     * 文本类型-Markdown
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Content markdown;
    /**
     * 文本类型-actionCard
     * todo 构造方法
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Content actionCard;
    /**
     * 文本类型-feedCardext
     * todo 构造方法
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Content feedCard;
    /**
     * at目标
     */
    private AtTarget at;

    private PostRobotResponse() {
    }


    /**
     * 构造Markdown类型
     *
     * @param content
     * @param at
     */
    public PostRobotResponse(Markdown content, AtTarget at) {
        this.markdown = content;
        this.initTypeAndAtTarget(content, at);
    }


    /**
     * 构造text类型
     *
     * @param content
     * @param at
     */
    public PostRobotResponse(Text content, AtTarget at) {
        this.markdown = content;
        this.initTypeAndAtTarget(content, at);
    }

    /**
     * 初始化一些构造信息
     *
     * @param content
     * @param at
     */
    private void initTypeAndAtTarget(Content content, AtTarget at) {
        this.msgtype = content.getContentName();
        this.at = at;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public Content getText() {
        return text;
    }

    public Content getMarkdown() {
        return markdown;
    }

    public Content getActionCard() {
        return actionCard;
    }

    public Content getFeedCard() {
        return feedCard;
    }

    public AtTarget getAt() {
        return at;
    }

    /**
     * at用户目标
     */
    public static class AtTarget {

        /**
         * at用户的电话列表
         * 必须在这里声明被@用户的号码，才能在文本中通过“@156xxxxxxxx（手机号）”这样的方式去@他人
         * 一般来讲，最终的文本会自动将“@156xxxxxxxx”替换成“@这个人在这个群内的昵称”
         */
        private List<String> atMobiles;

        /**
         * 是否at所有人
         */
        private boolean isAtAll;

        public AtTarget() {
        }

        public AtTarget(List<String> atMobiles) {
            this.atMobiles = atMobiles;
            this.isAtAll = false;
        }

        public AtTarget(List<String> atMobiles, boolean isAtAll) {
            this.atMobiles = atMobiles;
            this.isAtAll = isAtAll;
        }


        public List<String> getAtMobiles() {
            return atMobiles;
        }

        public void setAtMobiles(List<String> atMobiles) {
            this.atMobiles = atMobiles;
        }

        public boolean isAtAll() {
            return isAtAll;
        }

        public void setAtAll(boolean atAll) {
            isAtAll = atAll;
        }
    }

}
