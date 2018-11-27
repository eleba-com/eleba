package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
* @Description:    处理图片信息static类
* @Author:         jhao
* @CreateDate:     2018/11/27 9:33
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/27 9:33
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
@RequestMapping("")
public class PhotosController {


    /**
     *  读取文件
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/27 9:34
     */
    public static byte[] readFile(String filePath) throws IOException {
        File file = new File(filePath);
        ByteArrayOutputStream out = null;
        FileInputStream in =null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int i = 0;
            while ((i = in.read(b)) != -1) {
                String str = new String(b,0,i);
                out.write(str.getBytes(), 0, str.getBytes().length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            out.close();
            in.close();
        }

        byte[] bytes = out.toByteArray();
        return bytes;
    }

    /**
     * 字符串转16进制byte
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/27 9:39
     */
    private static byte hexStr2Str(String hexStr) {
        String str = "0123456789abcdef";
        char[] hexs = hexStr.toCharArray();
        int n = 0;
        n = str.indexOf(hexs[0]) * 16;
        n += str.indexOf(hexs[1]);
        byte bytes = (byte) (n & 0xff);

        return bytes;
    }

    /**
     * 方法实现说明
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/27 9:35
     */
    @ResponseBody
    @RequestMapping(value = "/fileToByte", method = RequestMethod.GET)
    public Map fileToByte(String filename, HttpServletRequest request) throws Exception {
        Map<String,Object> map = new HashMap<>();
        //这里要通过filename获取filepath
        File file = new File(request.getSession().getServletContext().getRealPath("")+"/upload/images/");
        if(!file.exists()){
            file.mkdirs();
        }
        String filePath1 = request.getSession().getServletContext().getRealPath("")+"/upload/images/"+filename+".jpg";
        byte[] bytes1 = readFile(filePath1);
        map.put("photo",bytes1);
        /*
        String str1= new String (bytes1);
        String[] strs1 = str1.split(",");

        String filePath2 = "D:\\test2.txt";
        byte[] bytes2 = readFile(filePath2);
        String str2 = new String(bytes2);

        String[] strs2 = str2.split(",");
        byte[] bytes3 = new byte[strs2.length];
        for(int i = 0 ; i<strs2.length ; i++){
            bytes3[i] =hexStr2Str(strs2[i]);
        }


        int start = 0;
        int end = 0;
        for(int i = 0; i<strs1.length;i++){
            end = Integer.valueOf(strs1[i]);
            byte[] byte_1 = new byte[end - start];

            System.arraycopy(bytes3, start, byte_1, 0, end - start);
            start = end;

            //bytes3.offer(byte_1);
            //System.out.println("处理文件当前队列大小" + bytes3.size());
        }
         */
        return map;
    }

    @ResponseBody
    @RequestMapping("getPhoto")
    public Map getPhoto(String filename, HttpServletRequest request)throws Exception{
        Map<String,Object> map = new HashMap<>();
//        File file = new File(request.getSession().getServletContext().getRealPath("")+"\\upload\\images");
//        if(!file.exists()){
//            file.mkdirs();
//        }
        String filePath1 = "http://localhost:8080/upload/images/"+filename+".jpg";
        map.put("photo",filePath1);
        return map;
    }
}
