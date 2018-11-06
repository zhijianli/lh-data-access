package com.bozhong.lhdataaccess.client.domain.query;

/**
 * 默认的分页查询
 * Created by bin on 2017/3/28.
 */
public abstract class BasePageQuery extends BaseQuery {

    private int DEFAULT_PAGE_SIZE=20;

    private int DEFAULT_PAGE_NUM=1;

    private int pageSize;

    private int pageNum;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void initPageNum(){
        pageNum=DEFAULT_PAGE_NUM;
    }

    public void initPageSize(){
        pageSize=DEFAULT_PAGE_SIZE;
    }
}
