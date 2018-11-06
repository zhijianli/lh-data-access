package com.bozhong.lhdataaccess.application;


import com.bozhong.lhdataaccess.client.common.constants.ServiceErrorEnum;
import com.bozhong.lhdataaccess.client.domain.core.Result;

/**
 * 一个请求上下文
 *
 * @author bin
 * @create 2018-04-27 下午5:13
 **/
public class Context<P, M> {

    private P param;

    private Result<M> result;

    public Context(P param, Result<M> result) {
        this.param = param;
        this.result = result;
    }

    public Result<M> getResult() {
        return result;
    }

    public P getParam() {
        return param;
    }

    public void setResultModule(M m) {
        result.setModule(m);
    }

    public void setResult(Result<M> result) {
        this.result = result;
    }

    public void setServiceError(ServiceErrorEnum serviceError) {
        result.setServiceError(serviceError);
    }
}
