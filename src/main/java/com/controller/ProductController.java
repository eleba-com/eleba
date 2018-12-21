package com.controller;

import com.pojo.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
* @Description:    商家产品控制类
* @Author:         jhao
* @CreateDate:     2018/11/29 8:41
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/29 8:41
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
@RequestMapping("")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 将商家的商品属性记录到数据库中
     * @author      jhao
     * @param       product
     * @return
     * @exception
     * @date        2018/11/29 8:55
     */
    @ResponseBody
    @RequestMapping("addProduct")
    public Map addProduct(Product product){

        Map<String,Object> map = new HashMap<>();
        if (productService.addProduct(product)){
            map.put("message","添加成功");
        }else{
            map.put("message","添加失败");
        }

        return map;
    }

    /**
     * 通过商家id列出他的所有产品
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 9:48
     * @Update 2018-12-21 V2 补充图片地址处理
     */
    @RequestMapping("listAllProduct")
    @ResponseBody
    public Map listAllProduct(Product product){
        Map<String,Object> map = new HashMap<>();
        List<Product> list = null;
        System.out.println("product是 "+ product.toString()+" mid = "+product.getMid());
        list = productService.listAllProduct(product);
        if(list!=null){
            Iterator<Product> iterator =list.iterator();
            Product p=null;
            while (iterator.hasNext()){
                p = iterator.next();
                System.out.println("进来了， "+p.toString());
                p.setPhoto_addr("http://localhost:8081/upload/images/"+p.getPhoto_addr());
            }
            map.put("商家产品",list);
        }else{
            map.put("message","no record");
        }

        return map;
    }

    /**
     * 通过商品id删除该商品
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 14:43
     */
    @RequestMapping("deleteProduct")
    @ResponseBody
    public Map deleteProduct(Product product){

        Map<String,Object> map = new HashMap<>();
        if(productService.deleteProduct(product)){
         map.put("message","删除成功");
        }else {
            map.put("message","删除失败");
        }
        return map;
    }

    /**
     * 通过id确认商品，修改商品信息
     * v1.0 需要每个值都有传入不为null
     * 否则其他column会改为null
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 15:12
     */
    @RequestMapping("updateProduct")
    @ResponseBody
    public Map updateProduct(Product product){
        Map<String,Object> map = new HashMap<>();
        if(productService.updateProduct(product)){
            map.put("message","修改成功");

        }else {
            map.put("message","修改失败");
        }

        return map;
    }


    /**
     * 根据产品id获取产品图片地址url串
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/10 16:05
     */
    @RequestMapping("getAddress")
    @ResponseBody
    public Map getAddress(Product product){
        Map<String,Object> map = new HashMap<>();
        String res = productService.getAddress(product.getId());
        if(res!=null){
            map.put("message",res);

        }else {
            map.put("message","修改失败");
        }

        return map;
    }

}
