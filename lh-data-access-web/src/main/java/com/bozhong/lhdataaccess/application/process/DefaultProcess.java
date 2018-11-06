package com.bozhong.lhdataaccess.application.process;

import com.bozhong.lhdataaccess.application.Context;
import com.bozhong.lhdataaccess.client.common.constants.ServiceErrorEnum;
import com.bozhong.lhdataaccess.client.domain.dto.BaseReqDTO;
import com.bozhong.lhdataaccess.client.exception.LhDataAccessException;
import com.bozhong.lhdataaccess.common.util.LongHuaWebsiteLog;
import com.zhicall.core.mybatis.dao.DatabaseException;
import org.slf4j.Logger;

import java.util.Date;

/**
 * @author bin
 * @create 2018-04-28 下午5:52
 **/

public abstract class DefaultProcess<P extends BaseReqDTO,M> implements IProcess<P, M> {


    protected final static Logger logger = LongHuaWebsiteLog.PROCESS_WRITE_LOG;

    private  long startTime ;

    private long endTime ;

    public void start(Context<P,M> context){
        try {
            onStarted(context);
            process(context);
            onSuccess(context);
        }catch(Throwable e){
            onError(context, e);
        }finally{
            onEnd(context);

        }
    }

    public void onStarted(Context<P,M> context) {
        startTime=new Date().getTime();
        if (context.getParam()==null)
            throw new LhDataAccessException(ServiceErrorEnum.ILLGAL_ARGUMENT_ERROR);
        context.getParam().validation();

    }

    public abstract void process(Context<P,M> context) ;


    public void onSuccess(Context<P,M> context) {
        if(!context.getResult().isSuccess()){
            context.getResult().setSuccess(true);
        }
    }

    public void onError(Context<P,M> context,Throwable e) {
        if(context.getResult().isSuccess()){
            context.getResult().setSuccess(false);
        }
        if(e instanceof DatabaseException){
            context.setServiceError(ServiceErrorEnum.DB_DAO_ERROR);
        } else if(e instanceof LhDataAccessException){
            context.setServiceError(((LhDataAccessException)e).getServiceError());
        }else if(e!=null){
            context.setServiceError(ServiceErrorEnum.serviceErrorEnum(e.getMessage()));
        }

        logger.info("[param]:"+context.getParam()+",[process]:"+this.getClass().getSimpleName(),e);
    }

    public void onEnd(Context<P,M> context) {
        endTime=new Date().getTime();
        logger.info(this.getClass().getSimpleName(), context.getResult(), context.getParam(), endTime-startTime);
    }

}