package com.controller;

import com.pojo.Comments;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
* @Description:    评论控制类
* @Author:         jhao
* @CreateDate:     2018/11/29 15:38
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/29 15:38
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
@RequestMapping("")
public class CommentController {

    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping("addComment")
    public Map addComment(Comments comments){
        Map<String,Object> map = new HashMap<>();
        if(commentService.addComment(comments)){
            map.put("message","评论添加成功");

        }else {
            map.put("message","评论添加失败");

        }
        return map;
    }

}
