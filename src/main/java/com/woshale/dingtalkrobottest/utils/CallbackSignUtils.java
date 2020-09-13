package com.woshale.dingtalkrobottest.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 回调sign工具类
 * @author Carrot
 * @since 2020/9/14 0:29
 */
public class CallbackSignUtils {

    /**
     * 对header中的 timestamp和sign进行验证，以判断是否是来自钉钉的合法请求人的appSecret
     * @param sign 回调header的sign
     * @param timestamp 回调header的timestamp
     * @param appSecret 机器人的appSecret
     * @return
     */
    public static boolean verifySign(String sign,Long timestamp,String appSecret){
        String stringToSign = timestamp + "\n" + appSecret;
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            return false;
        }
        String correctSign=null;
        try {
            mac.init(new SecretKeySpec(appSecret.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
            correctSign = new String(Base64.encodeBase64(signData));
        } catch (InvalidKeyException | UnsupportedEncodingException e) {
            return false;
        }
        return correctSign.equals(sign);
    }

}
