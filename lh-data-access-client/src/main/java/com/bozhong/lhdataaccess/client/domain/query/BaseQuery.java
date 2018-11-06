package com.bozhong.lhdataaccess.client.domain.query;

import com.bozhong.common.domain.CommonQuery;

import java.io.Serializable;

/**
 * 查询基础类
 *
 * @author bin
 * @create 2018-04-28 下午5:42
 **/
public abstract class BaseQuery extends CommonQuery implements Serializable {
    public static final long serialVersionUID = 5656290391537490260L;

    /**
     * 操作人员id
     */
    private long operationUserId;


    public long getOperationUserId() {
        return operationUserId;
    }

    public void setOperationUserId(long operationUserId) {
        this.operationUserId = operationUserId;
    }

    public abstract String controllerValidation();
}
