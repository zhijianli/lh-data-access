package com.bozhong.lhdataaccess.client.exception;


import com.bozhong.lhdataaccess.client.common.constants.ServiceErrorEnum;

/**
 * 业务异常
 *
 * @author bin
 * @create 2018-04-28 下午2:57
 **/
public class LhDataAccessException extends RuntimeException {

    private ServiceErrorEnum serviceError;

    public LhDataAccessException(ServiceErrorEnum serviceError){
        this.serviceError=serviceError;

    }

    public LhDataAccessException(ServiceErrorEnum serviceError, Throwable e){
        super(serviceError.getName(),e);
        this.serviceError=serviceError;
    }


    public ServiceErrorEnum getServiceError() {
        return serviceError;
    }

    public void setServiceError(ServiceErrorEnum serviceError) {
        this.serviceError = serviceError;
    }
}