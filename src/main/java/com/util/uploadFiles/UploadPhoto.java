package com.util.uploadFiles;

import com.pojo.Customer;
import com.service.CustmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
* @Description:    上传照片
* @Author:         jhao
* @CreateDate:     2018/11/27 8:51
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/27 8:51
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class UploadPhoto {

    @Autowired
    CustmerService custmerService;

    /**
     *  获取图片路径
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/27 8:54
     */
    public String getPhoto(Customer customer,HttpServletRequest request){
        /**
         * 巨多bug 有空再改 11-27
        String sqlPath = null;
        //本地服务器路径
        String dir = request.getSession().getServletContext().getRealPath("")+"/upload/images/";
        //定义 文件名
        String filename=null;
        Customer resultUser=custmerService.findbyUserName(customer.getUsername());
        if( resultUser ==null){
            if(!customer.getHeadAddr().isEmpty()){

                filename=uploadImage(users.getUrl(),dir);
            }
            sqlPath = "/upload/images/"+filename;
            users.setImagesUrl(sqlPath);
            userService.insertUser(users);
            return "login";
        }else {
            request.setAttribute("errorMsg","用户名已存在");
            //attributes.addFlashAttribute("errorMsg","用户名已存在");
            return "register";

        }
         */
        return "还没写好";
    }



    /**
     * 获取文件名称
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/27 9:07
     */
    public String uploadImage(MultipartFile url, String dir) throws IOException {
        String filename=null;
        String contentType=url.getContentType();
        //获得文件后缀名
        String suffixName=contentType.substring(contentType.indexOf("/")+1);
        //得到 文件名
        filename=System.currentTimeMillis()+"."+suffixName;
        //文件保存路径
        url.transferTo(new File(dir+filename));
        return filename;
    }
}
