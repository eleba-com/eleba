package com.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.pojo.Order;
import com.service.OrderService;
import com.util.aliPay.AlipayConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static java.lang.System.out;


/**
* @Description:    用户付款控制类
* @Author:         jiehao
* @CreateDate:     2018/12/17 8:49
* @UpdateUser:     jiehao
* @UpdateDate:     2018/12/17 8:49
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
@RequestMapping("")
public class PaymentController {

    private Logger log = Logger.getLogger(this.getClass());
    @Autowired
    private OrderService orderService;

    /**
     * 方法实现说明   用户付款
     *
     * @author： jiehao
     * @return：
     * @exception：
     * @date： 2018/12/6 8:44
     */
    @RequestMapping(value = "payment", method = RequestMethod.GET)
    public void payment(Order order, String orderName, HttpServletResponse rep) throws AlipayApiException, IOException {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);


        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = String.valueOf(order.getId());
        //付款金额，必填
        String total_amount = String.valueOf(order.getTotal_price());
        //订单名称，必填
        String subject = orderName;
        //商品描述，可空
         //String body = order.getAddr();

        String addr=order.getAddr();
         System.out.println(addr);
         orderService.updateOrderAddr(order);

        alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                // + "\"body\":\""+body+"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        rep.setContentType("text/html;charset=" + AlipayConfig.charset);
        //直接将完整的表单html输出到页面
        rep.getWriter().write(result);
        rep.getWriter().flush();
        rep.getWriter().close();
    }


  /**
  * 方法实现说明   支付成功修改订单状态，并跳转前端页面
  * @author：      jiehao
  * @return：
  * @exception：
  * @date：       2018/12/17 9:07
  */
    @RequestMapping(value = "returnUrl")
    //@ResponseBody
    public String returnUrl(HttpServletRequest request, HttpServletResponse response) throws AlipayApiException, UnsupportedEncodingException {
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            log.info("订单处理：系统订单号" + out_trade_no + "支付宝交易号：" + trade_no);
            System.out.println(Float.valueOf(total_amount));
            Order order=orderService.findOrder(Integer.valueOf(out_trade_no));
            System.out.println(order.getTotal_price());

            if(order==null){
                signVerified=false;
                order.setStated("7");
                orderService.updateOrder(order);
//                map.put("signVerfied",signVerified);
//                map.put("resaon","订单不存在");
//                System.out.println("订单不存在");
                return "redirect:/error.jsp";
            }else {
                if(!order.getTotal_price().equals(Float.valueOf(total_amount))){
                    signVerified=false;
                    order.setStated("7");
                    orderService.updateOrder(order);
//                    map.put("signVerfied",signVerified);
//                    map.put("reason","订单金额错误");
//                    System.out.println("订单金额错误");
                    return "redirect:/error.jsp";
                }
                if (order.getStated()==String.valueOf(1)){
                    order.setStated("7");
//                    orderService.updateOrder(order);
//                    map.put("reason","不需要重复处理订单");
//                    System.out.println("不需要重复处理订单");
                    return "redirect:/error.jsp";
                }
                else {
                    order.setStated("1");
                   // order.setAddr(addr);
                   int num=orderService.updateOrder(order);
                    map.put("rsason","支付成功");
                    System.out.println("支付成功");
                    return "redirect:/pay.jsp";
                }
            }
        }else {
            request.setAttribute("reason","验签失败");

       }
        map.put("signVerified", signVerified);
        map.put("resaon","跳转");
        //return "redirect:/pay.jsp";
        return "";
        }

        /**
        * 方法实现说明    服务器异步通知
        * @author：      jiehao
        * @return：
        * @exception：
        * @date：       2018/12/17 9:08
        */
    @RequestMapping(value = "notify_url")
    public void notify_url(HttpServletResponse response, HttpServletRequest request) throws AlipayApiException, UnsupportedEncodingException, IOException {
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

        //——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            log.info("订单处理：系统订单号" + out_trade_no + "支付宝交易号：" + trade_no);

            /**
             * 订单处理代码
             */

            Order order=orderService.findOrder(Integer.valueOf(out_trade_no));
            if(order==null){
                signVerified=false;
                order.setStated("7");
                orderService.updateOrder(order);
                request.setAttribute("signVerified", signVerified);
                request.setAttribute("reason", "商户订单号不存在");
            }else {
                if(!order.getTotal_price().equals(Float.valueOf(total_amount))){
                    signVerified=false;
                    order.setStated("7");
                    orderService.updateOrder(order);
                    request.setAttribute("signVerified", signVerified);
                    request.setAttribute("reason","金额不符合");
                }
                if (order.getStated()==String.valueOf(1)){
                    order.setStated("7");
                    orderService.updateOrder(order);
                    request.setAttribute("reason","不需要重复处理订单");
                }
                else {
                    order.setStated("1");
                    request.setAttribute("rsason","支付成功");
                }
            }
        }else {
            request.setAttribute("reason","验签失败");
        }
            request.setAttribute("signVerified", signVerified);
            response.setContentType("text/html;charset=" + AlipayConfig.charset);
            //直接将完整的表单html输出到页面
            try {
                response.getWriter().write("success");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                response.getWriter().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                response.getWriter().close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


}
