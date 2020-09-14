package com.woshale.dingtalkrobottest.model.robot.content;

import com.woshale.dingtalkrobottest.model.robot.content.interfaces.Content;

/**
 * Markdown格式
 *
 * @author Carrot
 * @since 2020/9/14 0:52
 */
public class Markdown implements Content {

    public static final String CONTENT_NAME = "markdown";

    private String title;

    private String text;

    private Markdown() {
    }

    public Markdown(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String getContentName() {
        return CONTENT_NAME;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
