package com.bozhong.lhdataaccess.common.util;

import java.util.UUID;

/**
 * 字符串工具类
 *
 * @author bin
 * @create 2018-04-28 上午11:29
 **/
public class StringUtils {
    /**
     * 字符串判空
     * @param object
     * @return
     */
    public static boolean isEmpty(Object object){
        if(object==null)
            return true;
        if(((String)object).trim().length()==0)
            return true;
        return false;

    }

    /**
     * 生成uuid
     * @return
     */
    public static String UUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


}