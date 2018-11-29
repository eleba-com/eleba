package com.service.impl;

import com.dao.CommentsMapper;
import com.pojo.Comments;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @Description:    评论服务实现类
* @Author:         jhao
* @CreateDate:     2018/11/29 15:45
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/29 15:45
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentsMapper commentsMapper;
    /**
     * 添加评论
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 15:46
     */
    @Override
    public boolean addComment(Comments comments) {
       try{
           commentsMapper.insert(comments);
           return true;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }

    }
}
