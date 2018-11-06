package com.bozhong.lhdataaccess.client.domain.dto;

import java.io.Serializable;

/**
 * 请求基础类
 *
 * @author bin
 * @create 2018-04-28 下午5:40
 **/
public abstract class BaseReqDTO implements Serializable {

    public abstract void validation();

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