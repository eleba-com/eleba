package com.service;

import com.pojo.Comments;

/**
* @Description:    评论服务
* @Author:         jhao
* @CreateDate:     2018/11/29 15:42
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/29 15:42
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface CommentService {

    /**
     * 添加评论
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 15:45
     */
    public boolean addComment(Comments comments);



}
