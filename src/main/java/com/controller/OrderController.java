package com.controller;

import com.alipay.api.domain.OrderItem;
import com.google.gson.Gson;
import com.pojo.Merchant;
import com.pojo.Order;
import com.pojo.Orderitem;
import com.pojo.Product;
import com.service.MerchantService;
import com.service.OrderItemService;
import com.service.OrderService;
import com.service.ProductService;
import com.stack.Tmp;
import com.util.config.OrderConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.*;

/**
* @Description:    订单控制类
* @Author:         jhao
* @CreateDate:     2018/11/30 11:13
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/30 11:13
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
@RequestMapping("")
public class OrderController implements OrderConfig{

    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    ProductService productService;

    @Autowired
    MerchantService merchantService;

    /**
    * @Description:    下单
    * @Author:         jhao
    * @CreateDate:     2018/11/30 16:54
    * @UpdateUser:     jhao
    * @UpdateDate:     12-10
    * @UpdateRemark:   更改下单逻辑，包含了订单项的改变
    * @Version:        2.0
    */

    @ResponseBody
    @RequestMapping(value = "insertOrder",method =RequestMethod.POST)
    public Map insertOrder(Order order,String items ){
        Map<String,Object> map = new HashMap<>();
        Gson gson = new Gson();
        Orderitem[] orderitems1= gson.fromJson(items, Orderitem[].class);
        order.setOrderitems(orderitems1);
        Date date = new Date();
        order.setCreate_time(date);
        //
        Tmp tmp = Tmp.getTmp();
        tmp.stack.push(order);
        System.out.println("date1 = " + date.toString());
        if(orderService.insert(order)){
            System.out.println("date2 = " + date.toString());
            Integer integer = orderService.getOrderId();
            if(integer!=null){
                map.put("message","successful");
                map.put("id",integer);

                tmp.map.put(integer,order);
            }else{
                map.put("message","successful but no id");
            }


        }else {
            map.put("message","error");
        }

        return map;
    }

    /**
     * 取消订单 逻辑待改
     * 这里取消了的订单在订单项的状态里算是已经结算了的，需要加一个操作去修改这个订单项的状态
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 21:04
     */
    @ResponseBody
    @RequestMapping("cancelOrder")
    public Map cancelOrder(Order order){

        Map<String,Object> map = new HashMap<>();
        if(orderService.deleteOrderById(order)){
            map.put("message","sucessful");
        }else {
            map.put("message","error");
        }

        return map;
    }

    /**
     * 用户查看订单
     * @author      jhao
     * @param   order
     * @return
     * @exception
     * @date        2018/12/7 10:46
     * @Update  V3 查看的是所有的订单
     *
     *
     */
    @ResponseBody
    @RequestMapping("checkOrder")
    public Map checkOrder(Order order){

        Map<String,Object> map = new HashMap<>();
        List<Order> orderList = null;
        try{
            orderList = orderService.checkOrder(order.getUid());
        }catch (Exception e){
            map.put("message","error");
        }

        if (orderList!=null){
            //在这里将所有的orderItem查出来一并返回给前端
            //这边是可以整合到OrderItemService中的！
            Iterator<Order> iter = orderList.iterator();

            List<Map> orderitems = new ArrayList<>();
            while(iter.hasNext()){
                Order order1 = iter.next();
                String s = order1.getOiId();
                StringBuffer sb = new StringBuffer();
                String[] strs = s.split(",");
                Map<Integer,Object> mapOrderItem = new HashMap<>();
                for(int i=0;i<strs.length;i++){
                    //这里逐个做查询
                    Orderitem orderitem = orderItemService.checkDetails(Integer.parseInt(strs[i]));

                    //去数据库找图
                    Product product = productService.getProductName(orderitem.getPid());
                    //String addr = productService.getAddress();
                    //System.out.println("addr = "+ addr);
                    sb.append(product.getName());
                    sb.append(",");
                    sb.append(orderitem.getNumbers());
                    sb.append(";");
                    orderitem.setPhoto_addr(product.getPhoto_addr());

                    //mapOrderItem.put(i,orderitem);
                }
                order1.setpNameAndNumner(sb.toString());
                Merchant merchant = merchantService.findMerchantMessage(order1.getMid());
                try{
                    if(merchant.getHead_addr()!=null){
                        order1.setHead_addr(merchant.getHead_addr());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }


                //orderitems.add(mapOrderItem);
            }
            System.out.println("到这里了啊");
            map.put("orders",orderList);
            //map.put("orderItemList",orderitems);
        }else {
            map.put("message","error");
        }

        return map;
    }


    /**
     * 返回最新的三个订单，包括已完成以及未完成的
     * @author      jhao
     * @param       //uid
     * @return
     * @exception
     * @date        2018/12/24 13:09
     */
    @ResponseBody
    @RequestMapping("return3LastOrder")
    public Map return3LastOrder(Order order){
        Map<String,Object> map = new HashMap<>();
        try{
            List<Order> list = orderService.check3Order(order.getUid());
            Iterator<Order> iterator = list.iterator();
            List<Orderitem> orderitemList = new ArrayList<>();
            int j =0;
            while(iterator.hasNext()){

                Order orderr = iterator.next();
                String[] strs = orderr.getOiId().split(",");
                //12-25- 16:30
                StringBuffer sb = new StringBuffer();
                for(int i=0;i<strs.length;i++){
                    Orderitem orderitem = orderItemService.checkDetails(Integer.parseInt(strs[i]));
                    String productName = productService.getProductName(orderitem.getPid()).getName();
//                    orderitem.setProductName(productName);
//                    orderitemList.add(orderitem);
                    sb.append(productName);
                    sb.append(",");
                    sb.append(orderitem.getNumbers());
                    sb.append(";");
                }
                orderr.setpNameAndNumner(sb.toString());
                //map.put("orderitems"+String.valueOf(j++),orderitemList);
                Merchant merchant = merchantService.findMerchantMessage(orderr.getMid());
                try{
                    if(merchant.getHead_addr()!=null){
                        orderr.setHead_addr(merchant.getHead_addr());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
            System.out.println("list = " + list.toString());
            map.put("message","success");
            map.put("lists",list);
        }catch (Exception e){
            e.printStackTrace();
            map.put("mistake","error");
        }
        return map;
    }


    /**
     * 商家接单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/11 10:10
     */
    @ResponseBody
    @RequestMapping("receiveOrdered")
    public Map receiveOrdered(String id){

        Map<String,Object> map = new HashMap<>();
        if(orderService.receiveOrder(Integer.parseInt(id))){
            map.put("message","已接单");
        }else {
            map.put("message","接单失败");
        }

        return map;
    }


    /**
     * 商家获取订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/24 10:27
     */
    @RequestMapping("getOrders")
    @ResponseBody
    public Map getOrders(Merchant merchant){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map1 = new HashMap<>();
        List<Order> lists = orderService.getOrders(merchant.getId(),MADE_ORDER);
        if(lists!=null){
            Iterator<Order> iterator = lists.iterator();
            int j = 0;
            while(iterator.hasNext()){
                List<Orderitem> list = new ArrayList<>();
                Order order = iterator.next();
                String[] strs = order.getOiId().split(",");
                //
                int numbers;
                String names;
                StringBuffer pnameAndNumbers = new StringBuffer();
                for(int i = 0;i<strs.length;i++){
                    if(strs[i]==""){
                        break;
                    };
                    System.out.println("格式 = "+Integer.parseInt(strs[i]));
                    Orderitem orderitem = orderItemService.checkDetails(Integer.parseInt(strs[i]));

                    Product product  = productService.getProductName(orderitem.getPid());
                    orderitem.setProductName(product.getName());
                    names = product.getName();
                    numbers = orderitem.getNumbers();
                    pnameAndNumbers.append(names);
                    pnameAndNumbers.append(",");
                    pnameAndNumbers.append(numbers);
                    pnameAndNumbers.append("份;");
                    list.add(orderitem);

                }
               // map1.put("orderitems"+String.valueOf(j++),list);
                 order.setpNameAndNumner(pnameAndNumbers.toString());
            }
            //map.put("orderitems",map1);
            map.put("message",lists);
        }else {
            map.put("message","无法获取订单");
        }

        return map;
    }


    /**
     * 确认订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/24 11:07
     */
    @RequestMapping("changeOrderState")
    @ResponseBody
    public Map changeOrdered(int id){

        Map<String,Object> map = new HashMap<>();
        Order order = new Order();
        order.setId(id);
        order.setStated("5");
        try{
            orderService.changeOrderState(order);
            map.put("message","已接单");
        }
       catch (Exception e){
           map.put("message","接单失败");
           e.printStackTrace();
       }
        return map;
    }



}
