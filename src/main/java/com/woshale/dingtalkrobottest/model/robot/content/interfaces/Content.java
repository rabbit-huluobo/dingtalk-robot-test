package com.woshale.dingtalkrobottest.model.robot.content.interfaces;

/**
 * 通用接口，需要实现提供自己文本类别的方法
 * @author Carrot
 * @since 2020/9/14 2:06
 */
public interface Content {

    /**
     * 获得内容类别
     *
     * @return
     */
    String getContentName();
}
