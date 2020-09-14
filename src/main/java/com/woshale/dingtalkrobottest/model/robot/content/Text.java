package com.woshale.dingtalkrobottest.model.robot.content;

import com.woshale.dingtalkrobottest.model.robot.content.interfaces.Content;

/**
 * text类型
 *
 * @author Carrot
 * @since 2020/9/14 2:28
 */
public class Text implements Content {

    public static final String CONTENT_NAME = "text";

    /**
     * 消息文本
     */
    private String content;

    private Text() {
    }

    public Text(String content) {
        this.content = content;
    }

    @Override
    public String getContentName() {
        return CONTENT_NAME;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
