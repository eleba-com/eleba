package com.controller;


import com.pojo.Merchant;
import com.util.Upload.UoloadImage;
import com.util.config.ImageConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
/**
* @Description:    图片上传服务器
* @Author:         jiehao
* @CreateDate:     2018/12/12 16:33
* @UpdateUser:     jiehao
* @UpdateDate:     2018/12/12 16:33
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
@RequestMapping("")
public class UploadImageController {

    private UoloadImage uploadImage;


    /**
    * 方法实现说明     上传图片
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/12 16:32
    */
    @RequestMapping(value = "uploadImage" ,method = RequestMethod.POST)
    @ResponseBody
    public Map uploadImageTest(Merchant merchant, HttpServletRequest request)throws Exception{
        String dir = request.getSession().getServletContext().getRealPath("")+"/upload/images/";
        File file=new File(dir);
        //如果文件夹不存在
        if(!file.exists()){
            //创建文件夹
            file.mkdirs();
            System.out.println("+++++++++++++");
        }
        uploadImage=new UoloadImage();
        String  filename=uploadImage.uploadImage(merchant.getImageFile(),dir);
        Map<String,Object> map = new HashMap<String, Object>();
        String sqlPath=ImageConfig.imageUrl +filename;
        //System.out.println(sqlPath);
        //map.put("sqlPath",sqlPath);
        map.put("fileName",filename);
        return map;
    }


}
