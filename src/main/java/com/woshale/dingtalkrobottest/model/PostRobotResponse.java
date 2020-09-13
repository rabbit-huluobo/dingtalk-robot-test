package com.woshale.dingtalkrobottest.model;

import java.util.List;

/**
 * 当用户@机器人时，钉钉会通过机器人开发者的HTTPS服务地址，把消息内容发送出去
 * 此为响应body
 * -------------------------------------------------------------
 * {
 *     "msgtype": "text",
 *     "text": {
 *         "content": "我就是我, 是不一样的烟火"
 *     },
 *     "msgId": "XXXX",
 *     "createAt": 1487561654123,
 *     "conversationType": "2",
 *     "conversationId": "XXXX",
 *     "conversationTitle": "钉钉群标题",
 *     "senderId": "XXXX",
 *     "senderNick": "星星",
 *     "senderCorpId": "XXXX",
 *     "senderStaffId": "XXXX",
 *     "chatbotUserId":"XXXX",
 *     "atUsers":[
 *        {
 *          "dingtalkId":"XXXX",
 *          "staffId":"XXXX"
 *        }
 *     ]
 * }
 * -------------------------------------------------------------
 * 参考 https://ding-doc.dingtalk.com/doc#/serverapi2/elzz1p
 * @author Carrot
 * @since 2020/9/13 23:40
 */
public class PostRobotResponse {

    /**
     * 消息文本
     */
    static class Text{

        /**
         * 消息文本
         */
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Text{" +
                    "content='" + content + '\'' +
                    '}';
        }
    }

    /**
     * 被@人的信息
     */
    static class AtUser{

        /**
         * 加密的发送者ID
         */
        private String dingtalkId;

        /**
         * 发送者在企业内的userid（企业内部群有）
         */
        private String staffId;

        public String getDingtalkId() {
            return dingtalkId;
        }

        public void setDingtalkId(String dingtalkId) {
            this.dingtalkId = dingtalkId;
        }

        public String getStaffId() {
            return staffId;
        }

        public void setStaffId(String staffId) {
            this.staffId = staffId;
        }

        @Override
        public String toString() {
            return "AtUser{" +
                    "dingtalkId='" + dingtalkId + '\'' +
                    ", staffId='" + staffId + '\'' +
                    '}';
        }
    }

    /**
     * 目前只支持text
     */
    private String msgtype;

    /**
     * 消息文本
     */
    private Text text;

    /**
     * 加密的消息ID
     */
    private String msgId;

    /**
     * 消息的时间戳，单位ms
     */
    private Long createAt;

    /**
     * 1-单聊、2-群聊
     */
    private String conversationType;

    /**
     * 加密的会话ID
     */
    private String conversationId;

    /**
     * 会话标题（群聊时才有）
     */
    private String conversationTitle;

    /**
     * 加密的发送者ID
     */
    private String senderId;

    /**
     * 发送者昵称
     */
    private String senderNick;

    /**
     * 发送者当前群的企业corpId（企业内部群有）
     */
    private String senderCorpId;

    /**
     * 发送者在企业内的userid（企业内部群有）
     */
    private String senderStaffId;

    /**
     * 加密的机器人ID
     */
    private String chatbotUserId;

    /**
     * 被@人的信息列表
     */
    private List<AtUser> atUsers;

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public String getConversationType() {
        return conversationType;
    }

    public void setConversationType(String conversationType) {
        this.conversationType = conversationType;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public String getConversationTitle() {
        return conversationTitle;
    }

    public void setConversationTitle(String conversationTitle) {
        this.conversationTitle = conversationTitle;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderNick() {
        return senderNick;
    }

    public void setSenderNick(String senderNick) {
        this.senderNick = senderNick;
    }

    public String getSenderCorpId() {
        return senderCorpId;
    }

    public void setSenderCorpId(String senderCorpId) {
        this.senderCorpId = senderCorpId;
    }

    public String getSenderStaffId() {
        return senderStaffId;
    }

    public void setSenderStaffId(String senderStaffId) {
        this.senderStaffId = senderStaffId;
    }

    public String getChatbotUserId() {
        return chatbotUserId;
    }

    public void setChatbotUserId(String chatbotUserId) {
        this.chatbotUserId = chatbotUserId;
    }

    public List<AtUser> getAtUsers() {
        return atUsers;
    }

    public void setAtUsers(List<AtUser> atUsers) {
        this.atUsers = atUsers;
    }

    @Override
    public String toString() {
        return "PostRobotResponse{" +
                "msgtype='" + msgtype + '\'' +
                ", text=" + text.toString() +
                ", msgId='" + msgId + '\'' +
                ", createAt=" + createAt +
                ", conversationType='" + conversationType + '\'' +
                ", conversationId='" + conversationId + '\'' +
                ", conversationTitle='" + conversationTitle + '\'' +
                ", senderId='" + senderId + '\'' +
                ", senderNick='" + senderNick + '\'' +
                ", senderCorpId='" + senderCorpId + '\'' +
                ", senderStaffId='" + senderStaffId + '\'' +
                ", chatbotUserId='" + chatbotUserId + '\'' +
                ", atUsers=" + (atUsers==null?"null":atUsers.toString()) +
                '}';
    }
}
