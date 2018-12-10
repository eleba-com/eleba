package com.pojo;

import java.io.Serializable;


/**
* @Description:    分页
* @Author:         jiehao
* @CreateDate:     2018/12/7 10:54
* @UpdateUser:     jiehao
* @UpdateDate:     2018/12/7 10:54
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Page implements Serializable {

    public static final long serivalVerionUID=-3198048449643774660L;
    /**
     * 当前页
     */
    private Integer pageNow ;
    /**
     * 每页显示的数据数
     */
    private Integer pageSize ;
    /**
     * 总记录数
     */
    private Integer totalCount;
    /**
     * 总页数
     */
    private Integer totalPageCount;
    /**
     * 开始的位置从0开始
     */
    @SuppressWarnings("unsed")
    private Integer startPos;
    /**
     * 是否有首页
     */
    @SuppressWarnings("unsed")
    private boolean hasFirst;
    /**
     * 是否有前一页
     */
    @SuppressWarnings("unused")
    private boolean hasPre;
    /**
     * 是否有下一页
     */
    @SuppressWarnings("unused")
    private boolean hasNext;
    /**
     * 是否有下一页
     */
    @SuppressWarnings("unused")
    private boolean hasLast;


    public Page(){
        super();
    };
    /**
    * 方法实现说明   通过构造函数传入总记录数、当前页面
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/7 11:26
    */
    public Page(int totalCount,int pageNow){
        this.totalCount=totalCount;
        this.pageNow=pageNow;
    }

    public Integer getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * 取得总页数，总页数=总记录数/每页记录数
     * @return
     */
    public Integer getTotalPageCount() {
        totalPageCount=getTotalCount()/getPageSize();
        return (totalPageCount%pageSize==0)?totalPageCount:totalPageCount+1;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    /**
     * 取得选择记录的初始位置
     * @return
     */
    public Integer getStartPos() {
        return (pageNow-1)*pageSize;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    /**
     * 是否是第一页
     * @return
     */
    public boolean isHasFirst() {
        return (pageNow==1)?false:true;

    }

    public void setHasFirst(boolean hasFirst) {
        this.hasFirst = hasFirst;
    }

    /**
     * 是否有首页
     * @return
     */
    public boolean isHasPre() {

        return isHasFirst()?true:false;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    /**
     * 是否有下一页
     * @return
     */
    public boolean isHasNext() {

        return isHasLast()?true:false;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    /**
     * 是否有尾页
     * @return
     */
    public boolean isHasLast() {
        return (pageNow==getTotalPageCount())?false:true;
    }

    public void setHasLast(boolean hasLast) {
        this.hasLast = hasLast;
    }
}
