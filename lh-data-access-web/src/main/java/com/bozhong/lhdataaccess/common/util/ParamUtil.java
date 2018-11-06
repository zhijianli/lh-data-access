package com.bozhong.lhdataaccess.common.util;


import com.alibaba.fastjson.JSON;
import com.bozhong.common.util.BeanUtil;
import com.bozhong.common.util.StringUtil;
import com.yx.eweb.main.EWebContext;
import com.yx.eweb.main.EWebRequestDTO;
import com.yx.eweb.main.EWebServletContext;

import java.util.Map;

/**
 * 用于封装入参的对象
 * Created by bin on 2017/5/8.
 */
public class ParamUtil {

    /**
     * 获取入参DTO
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T instance(Class<T> clazz){
        EWebContext eWebContext = EWebServletContext.getEWebContext();
        EWebRequestDTO eWebRequestDTO = (EWebRequestDTO) eWebContext.getParam();
        Map<String, Object> param = eWebRequestDTO.getRequestParam();
        // 通过该类 可以把一个map转成一个对象
        try{
            return  BeanUtil.mapToObject(param,clazz);
        }catch(Exception e){
            return null;
        }

    }

    /**
     * 根据键值，获取对应的value
     * @param key
     * @return
     */
    public static String value(String key){
        EWebContext eWebContext = EWebServletContext.getEWebContext();
        // 获取传入过来的值
        return  (String)eWebContext.get(key);
    }

    /**
     * 根据传进来的字符串转换成对象
     * @param clazz
     * @param <T>
     * @return
     * Created by hongkj on 2017/8/14
     */
    public static <T> T transform(Class<T> clazz) {
        String data = value("data");
        if (StringUtil.isEmpty(data)) {
            return null;
        }
        T DTO = JSON.parseObject(data,clazz);
        return DTO;
    }





}