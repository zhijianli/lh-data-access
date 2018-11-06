package com.bozhong.lhdataaccess.restful.resources.baseController;

import com.bozhong.common.util.ResultMessageBuilder;
import com.bozhong.lhdataaccess.application.Context;
import com.bozhong.lhdataaccess.application.process.IProcess;
import com.bozhong.lhdataaccess.client.common.constants.ServiceErrorEnum;
import com.bozhong.lhdataaccess.client.domain.core.Result;
import com.bozhong.lhdataaccess.client.domain.query.BaseQuery;
import com.bozhong.lhdataaccess.common.util.ParamUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 只读基础controller
 * @author bin
 * @create 2018-04-28 下午5:28
 **/
public class BaseReadController extends BaseController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * 查询接口统一入口
     *
     * @param processClazz 处理process
     * @param paramClazz 入参类型
     * @param userAuth 登录人员验证
     * @param <T> 入参类型
     * @return
     */
    public <T extends BaseQuery,P extends IProcess> String baseQuery(Class<P> processClazz, Class<T> paramClazz, boolean userAuth){
        T t= ParamUtil.instance(paramClazz);
//        if (userAuth)
//        {
//            TrackHolder.Tracker tracker= TrackHolder.getTracker();
//            if(tracker==null||tracker.getHospitalId()<1 || tracker.getUid()<1)
//                return ResultMessageBuilder.build(false,null,"请登录!").toJSONString();
//            t.setOperationUserId(tracker.getUid());
//            t.setOperationUserOrg(tracker.getHospitalId());
//
//        }

        String validation=t.controllerValidation();
        if(validation!=null)
            return ResultMessageBuilder.build(false,null,validation).toJSONString();

        Context<T,Object> context=
                new Context<T,Object>(t,new Result());

        P p= null;
        try {
            p = applicationContext.getBean(processClazz);
        } catch (BeansException e) {
            return ResultMessageBuilder.build(false,null,"请求错误!").toJSONString();
        }
        p.start(context);
        if(context.getResult().isSuccess()){
            return ResultMessageBuilder.build(context.getResult().getModule()).toJSONString();
        }else{
            ServiceErrorEnum serviceErrorEnum= context.getResult().getServiceError();
            return ResultMessageBuilder.build(context.getResult().isSuccess(),serviceErrorEnum.getName(),
                    serviceErrorEnum.getErrMsg()).toJSONString();}


    }


    /**
     * 查询接口统一入口 参见接口
     * public <T extends BaseQuery> String  baseQuery(IProcess process, Class<T> paramClazz,Action action, boolean userAuth)
     *  其中,userAuth默认为true,表示人员登录信息必须效验
     * @param processClazz 处理process
     * @param paramClazz 入参类型
     * @param <T> 入参类型
     * @return
     */
    public <T extends BaseQuery,P extends IProcess> String baseQuery(Class<P> processClazz, Class<T> paramClazz){
        return baseQuery(processClazz,paramClazz,true);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}