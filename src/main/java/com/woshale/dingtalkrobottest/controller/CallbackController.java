package com.woshale.dingtalkrobottest.controller;

import com.woshale.dingtalkrobottest.DingtalkRobotTestApplication;
import com.woshale.dingtalkrobottest.model.PostRobotResponse;
import com.woshale.dingtalkrobottest.utils.CallbackSignUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public void robotCallback(HttpServletRequest req, @RequestBody PostRobotResponse body){

        String reqSign=req.getHeader("sign");
        Long timestamp=Long.valueOf(req.getHeader("timestamp"));
        //todo 这里填写你的机器人的AppSecret
        if (!CallbackSignUtils.verifySign(reqSign,timestamp,"需要填写的appSecret")){
            System.out.println("sign验证错误");
            //todo 验证错误情况下请自行处理
        }
        //验证成功后，进行响应
    }

}
