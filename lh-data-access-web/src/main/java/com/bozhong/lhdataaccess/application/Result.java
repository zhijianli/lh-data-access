package com.bozhong.lhdataaccess.application;


import com.bozhong.lhdataaccess.client.common.constants.ServiceErrorEnum;

/**
 * 上下文的返回结果
 *
 * @author bin
 * @create 2018-04-27 下午5:17
 **/
public class  Result <T>  {

    private static final long serialVersionUID = -6667401724585745605L;

    private boolean success = true;

    private ServiceErrorEnum serviceError;

    private T module;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ServiceErrorEnum getServiceError() {
        return serviceError;
    }

    public void setServiceError(ServiceErrorEnum serviceError) {
        this.success=false;
        this.serviceError = serviceError;
    }

    public T getModule() {
        return module;
    }

    public void setModule(T module) {
        this.module = module;
    }
}