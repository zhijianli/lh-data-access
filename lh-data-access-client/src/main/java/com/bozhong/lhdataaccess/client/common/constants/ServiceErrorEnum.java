package com.bozhong.lhdataaccess.client.common.constants;

/**
 * 消息通道错误类型
 *
 * @author bin
 * @create 2018-04-28 上午9:52
 **/
public enum ServiceErrorEnum {

    // ********************** 通用错误  *************************
    REDIS_KEY_NULL_ERROR("redis键值不能为空!"),

    DB_DAO_ERROR("网络繁忙，请稍后重试!"),

    DEFAULT_ERROR("网络繁忙，请稍后重试!"),

    ILLGAL_ARGUMENT_ERROR("非法参数"),

    DEFAULT_SERVICE_ERROR(""),;

    private String errMsg;

    private ServiceErrorEnum(String errMsg){
        this.errMsg = errMsg;
    }

    public String getErrMsg(){
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getName(){return this.name();}

    public static ServiceErrorEnum serviceErrorEnum(String errMsg){
        ServiceErrorEnum serviceErrorEnum= ServiceErrorEnum.DEFAULT_SERVICE_ERROR;
        serviceErrorEnum.setErrMsg(errMsg);
        return serviceErrorEnum;
    }

    public static ServiceErrorEnum argumentErrorEnum(String errMsg){
        ServiceErrorEnum serviceErrorEnum= ServiceErrorEnum.ILLGAL_ARGUMENT_ERROR;
        serviceErrorEnum.setErrMsg(errMsg);
        return serviceErrorEnum;
    }


}