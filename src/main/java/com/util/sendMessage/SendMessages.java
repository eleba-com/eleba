package com.util.sendMessage;

/**
 * Created by Administrator on 2018/11/23.
 */

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
* @Description:    发送短信验证码工具类
* @Author:         jhao
* @CreateDate:     2018/11/23 16:05
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/23 16:05
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class SendMessages {

    private static String operation = "/industrySMS/sendSMS";

    private static String accountSid = Config.ACCOUNT_SID;
    private static String smsContent;
    /**
     * 方法实现说明
     * @author      jhao
     * @param       tel
     * @return      json格式的state与验证码
     * @exception
     * @date        2018/11/23 16:07
     */
    public static Map sendMessage(BigInteger tel){
        Map<String,Object> map = new HashMap<>();
        String tmpSmsContent = null;
        int verificationCode = makeRandom();
        smsContent = "【饿了吧】登录验证码： "+verificationCode+"，如非本人操作，请忽略此短信。";
        try{
            tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
        }catch(Exception e){
             e.printStackTrace();
        }
        String url = Config.BASE_URL + operation;
        String body = "accountSid=" + accountSid + "&to=" + tel + "&smsContent=" + tmpSmsContent
                + HttpUtil.createCommonParam();

        // 提交请求
        String result = HttpUtil.post(url, body);
        //System.out.println("result:" + System.lineSeparator() + result);
        System.out.println(result);
        JsonObject jsonObject = (JsonObject) new JsonParser().parse(result);
        if(jsonObject.get("respCode").getAsInt()==00000) {
            System.out.println("发送成功！！！");
            map.put("VerificationCode",verificationCode);
            map.put("tel",tel);

        }
        return map;
    }

    /**
     * @author jhao
     * @date 2018-11-23
     * 	生成随机码
     * @return
     */
    public  static int makeRandom() {
        int resultRan = (int)(Math.random()*1000000);
        while(resultRan>0) {

            if(resultRan>=100000) {
                return resultRan;
            }else {
                resultRan = (int)(Math.random()*1000000);
            }
        }//end while

        return -1;
    }
}
