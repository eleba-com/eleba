package com.util.aliPay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id ="2016092400584449";



    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCdxmWWM/PYe48AaPQu/FZ6fWkE9wR3CYQFdwutG5ncP3chyBG1mZmG0v9cuZMq7RQj10pKdZ1mnyR0+6zxj9RGCBPo/qCOOsJCBYhbamFZwH7FOyZRt2H96CFgmUETgiD6836PTer4EZ/zz3YoUdo/otKh+QAbH2r+BYicZIL/3giEN3rLzBxZX0jwvpBGut+R/ulmSYJq11vkCAnqwGPrK4I/TXxlsu1wqq+4dLKmqcGMjGPY5BGFxgFPUnjYIvZZEtjSwZcDdP15Cuty4PknBO2jGtIvvOoqgCh5XXTDj6G8rcyL1303bnujsB95/qQXUVM1lh5EctT/aLdR501xAgMBAAECggEAQlsNoJVrCfI1W3vIrvYrvMp/37mwJAxZfR7rRzvjgvEiPo/xesoF+uFEyw+1aIlbPhOuyBAdSerGn3i17MaMBYQiM4zbo9Xsm23OQnxEQ0YlSvgsjpOs3+fAGet6piTFkCXWZZjkqL5o4lavoBeEzdzB76NUuxOEoR9crEHNoqRrBofKPQP0iJUqYWqMMChBNFJ5wfFhwFilDtpRQnkfhIURz8L7m+NuiEhfZdgqZFmaY7azbTliEyBbAcfECbtbGPOycbIaoz3HHZ+zdMruA/8R7k4HaWcmL4spdMmYR9LaFfu6VUCew5CS7QHiFvQUEUZ0OjFDmyFe+HgnXt0MfQKBgQDRtPwmV9us/gbOHjUdOKJ2Yu6lasfcTVV1d3u32otcM5CrR1brtI36Tu7NRr7YM/tyXEvxReyuKTAyx5OZHTIzveXqKgA/1mO/rvTpPFz6YEDjv9OebD5k2IxA3JdYJdGBhoVVb6ZVJlREq52itoMsI5aYXw3xV4EeFpnuFGRzSwKBgQDAmp41yU071RMSgW1WwgFmz2IqLVDQ/+dKmQYjcyDKxh3B9g1Ae83V3lepqA6yxmH5p3EAwKxno3v+o85i41t873bebgOWYFwucTQLcMGCm7wK4Mx1BAxxQIQsHqnZLGlbVty4YDKkdO8YnG5e7GJfaQ65YhOnB15E/vCAmaIQswKBgFKl9r6R39U1JK91fk9u87Ce2xk8lVpA7E5occ0LB+Oluv2WFy68MTyWgU1L9Yk2K4Jt18xWV6poN0O8HnK47AEydXutY/3E2/k+1e1aSfavmsNn5dpJJOoP4m7pwYgPF5vpzYDXiQGEIrARxwXK0rXBrOeOhus4Jn4aQD5xsQkzAoGBALLV3lkq1N/ddJwWOSP5d7uyi/+FnCiztFr7w0tfNu+RDUhv4tYhHnqavOL2/M7ajVZ2NuLwBCUnE5bZGmWPnf9figv2MraKOo2U5zJIPCW93Nhs6ussGzF9KjydLDBOoHUDLma0S9GQEgHUHlddPepBbj6L5puMp+eAoGeIP4cpAoGAPiMRClyOeRueQmj5D4+ZwloqAbo18tVN077WCvJVtMlkZJ4sxvU7mO5d1SsA614Z4nGP3c52UMQoWOwf6MAVxPOTsSoKT4ivUK/gJYb6L+h0crwS9nOpXXPOX9lh+z955dc/h+c9Sp0uR9Gy4+r/2nB25QwYlZxTB+YAz7LbJV0=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0Mu8nK5WxeooMduV9nBau96yKO6pdVhRTUhCwhsgDno3abWPhOj17IX5GEr4yeZrpJDRuWJkw5sD/6ULN506DXlvFwfQNeVMLaJ069uqYJKj+Di1GtMqeMot/Y5YHIddHXimnODpdFyi6IUguvbKwORSDcNj29sumUiZ23ZYZVfUYVMNQDgzOqZvTE9Z+yh62/NqFvGh8HChGgfFpO4lIX30+A4NB5DITazCeWfZKPau6YuTHxX+AqYb2+Qg5MJwRzJij8jw9t5ay78d+J6EcWiLofW9s+8JWdriYU6EUXl2RTOUJQIn+uj8DMpSCMF9QTSFOTSj9jtur9LbQvPlpwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8088/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8088/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "c://";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
