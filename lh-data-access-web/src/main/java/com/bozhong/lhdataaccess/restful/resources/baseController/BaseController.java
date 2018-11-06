package com.bozhong.lhdataaccess.restful.resources.baseController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bozhong.common.util.ResultMessageBuilder;
import com.bozhong.lhdataaccess.application.Context;
import com.bozhong.lhdataaccess.client.common.constants.ServiceErrorEnum;

/**
 * @author bin
 * @create 2018-04-28 下午5:24
 **/
public class BaseController {
    private static final String DEFAULE_DATA_FOMATE = "yyyy-MM-dd HH:mm:ss";

    protected String toJSON(Context context) {
        if(context.getResult().isSuccess()){
            return ResultMessageBuilder.build(context.getResult().getModule()).toJSONString();
        }else{
            ServiceErrorEnum serviceErrorEnum= context.getResult().getServiceError();
            return ResultMessageBuilder.build(false,serviceErrorEnum.getName(),serviceErrorEnum.getErrMsg()).toJSONString();
        }
    }

    /**
     * 根据日期格式格式化返回数据
     * @param context
     * @param dateFormat
     * @return
     */
    protected String toJSONByDateFormat(Context context, String dateFormat) {
        if(context.getResult().isSuccess()){
            return ResultMessageBuilder.build(context.getResult().getModule()).toJSONString(dateFormat);
        }else{
            ServiceErrorEnum serviceErrorEnum= context.getResult().getServiceError();
            return ResultMessageBuilder.build(false,serviceErrorEnum.getName(),serviceErrorEnum.getErrMsg()).toJSONString();
        }
    }

    /**
     * 根据日期格式格式化返回数据
     * @param context
     * @return
     */
    protected String toJSONByDateFormat(Context context) {
        return toJSONByDateFormat(context,DEFAULE_DATA_FOMATE);
    }

    /**
     * 返回实体类无参数时 带 null
     * @param context
     * @return
     */
    protected String toJSONByNull(Context context){
        return JSONObject.toJSONStringWithDateFormat(ResultMessageBuilder.build(context.getResult().getModule()),"yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteMapNullValue);
    }

}