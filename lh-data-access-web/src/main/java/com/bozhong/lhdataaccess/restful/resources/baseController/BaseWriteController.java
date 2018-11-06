package com.bozhong.lhdataaccess.restful.resources.baseController;

import com.bozhong.common.util.ResultMessageBuilder;
import com.bozhong.lhdataaccess.application.Context;
import com.bozhong.lhdataaccess.application.process.IProcess;
import com.bozhong.lhdataaccess.client.common.constants.ServiceErrorEnum;
import com.bozhong.lhdataaccess.client.domain.core.Result;
import com.bozhong.lhdataaccess.client.domain.dto.BaseReqDTO;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 写基础rest
 * @author bin
 * @create 2018-04-28 下午5:30
 **/
public class BaseWriteController extends BaseController implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    /**
     * 编辑接口统一入口
     * @param processClazz 处理process
     * @param t 入参
     * @param userAuth 登录人员信息验证
     * @param <T> 入参类型
     * @return
     */
    public <T extends BaseReqDTO,P extends IProcess> String baseWrite(Class<P> processClazz, T t, boolean userAuth){


//        if (t == null) {
//            return ResultMessageBuilder.build(false, NurseTrainErrorCodeEnum.PARAM_ISNULL.getErrCode(), NurseTrainErrorCodeEnum.PARAM_ISNULL.getErrMsg()).toJSONString();
//        }
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
                new Context<T,Object>(t,new Result() );
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
            return ResultMessageBuilder.build(context.getResult().isSuccess(),serviceErrorEnum.getName(),serviceErrorEnum.getErrMsg()).toJSONString();
        }


    }

    /**
     * 编辑接口统一入口 参见
     *  public <T extends BaseReqDTO> String  baseWrite(IProcess process, T t, Action action, boolean userAuth)
     *  其中,userAuth默认为true,表示人员登录信息必须效验
     * @param processClazz 处理process
     * @param t 入参
     * @param <T> 入参类型
     * @return
     */
    public <T extends BaseReqDTO,P extends IProcess> String baseWrite(Class<P> processClazz, T t){
        return baseWrite(processClazz,t,true);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}