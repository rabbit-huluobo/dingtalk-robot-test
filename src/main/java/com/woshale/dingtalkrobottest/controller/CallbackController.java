package com.woshale.dingtalkrobottest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woshale.dingtalkrobottest.model.robot.PostRobotRequest;
import com.woshale.dingtalkrobottest.model.robot.PostRobotResponse;
import com.woshale.dingtalkrobottest.model.robot.content.Markdown;
import com.woshale.dingtalkrobottest.utils.CallbackSignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 钉钉机器人回调
 * 注意：
 * 开发者需对header中的 timestamp和sign进行验证，以判断是否是来自钉钉的合法请求，避免其他仿冒钉钉调用开发者的HTTPS服务传送数据，具体验证逻辑如下：
 * 1. timestamp 与系统当前时间戳如果相差1小时以上，则认为是非法的请求。
 *
 * 2. sign 与开发者自己计算的结果不一致，则认为是非法的请求。
 *
 * 必须当timestamp和sign同时验证通过，才能认为是来自钉钉的合法请求。

 * sign的计算方法：
 *
 * header中的timestamp + "\n" + 机器人的appSecret 当做签名字符串，使用HmacSHA256算法计算签名，然后进行Base64 encode，得到最终的签名值。
 * @author Carrot
 * @since 2020/9/13 23:15
 */
@RestController
@RequestMapping("/api/v1/callback")
public class CallbackController {

    @PostMapping("/robot")
    public PostRobotResponse robotCallback(HttpServletRequest req, @RequestBody PostRobotRequest body){
        System.out.println(body.toString());
        String reqSign=req.getHeader("sign");
        Long timestamp=Long.valueOf(req.getHeader("timestamp"));
        //todo 这里填写你的机器人的AppSecret
        if (!CallbackSignUtils.verifySign(reqSign,timestamp,"需要填写的appSecret")){
            System.out.println("sign验证错误");
            //todo 验证错误情况下业务处理
        }

        //验证成功后，进行响应 这里用markdown举例
        //获得了用户给机器人说的话
        String contentHasSent=body.getText().getContent();
        //todo 根据用户发的内容 构建title和text
        String title="根据业务得到的标题";
        String text="根据业务得到的文本";
        Markdown markdown=new Markdown(title,text);
        PostRobotResponse.AtTarget atTarget=new PostRobotResponse.AtTarget();
        List<String> atMobiles=new ArrayList<>();
        //todo 设置要@的人，可不填写
        atMobiles.add("15xxxxxxxx要@人的电话号码");
        atTarget.setAtMobiles(atMobiles);
        return new PostRobotResponse(markdown,atTarget);
    }

}
