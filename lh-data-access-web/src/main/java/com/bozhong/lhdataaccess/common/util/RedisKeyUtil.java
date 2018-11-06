package com.bozhong.lhdataaccess.common.util;

import com.bozhong.lhdataaccess.client.common.constants.ServiceErrorEnum;
import com.bozhong.lhdataaccess.client.exception.LhDataAccessException;

/**
 * 生成redis key的工具
 *
 * @author bin
 * @create 2018-04-28 下午2:53
 **/
public class RedisKeyUtil {

    private static final String PROJECT_NAME="";

    private static final String ENV="";

    /**
     * 生成redisKey 格式为入参是 XXXX，YYYY，RRRR，DDD
     * 返回格式为 XXXX:YYYY:RRRR:DDD
     * @param prefixKey
     * @param keys
     * @return
     */
    public static String key(String prefixKey,Object ... keys){
        if(keys==null||keys.length==0)
            throw new LhDataAccessException(ServiceErrorEnum.REDIS_KEY_NULL_ERROR);
        StringBuffer sb=new StringBuffer(prefixKey);
        for(Object key:keys){
            sb.append(":"+key);
        }
        return PROJECT_NAME+ENV+":"+sb.toString();
    }

    /**
     * 生成redisKey 格式为入参是 XXXX，YYYY，RRRR，DDD
     * 返回格式为 XXXX:YYYY:RRRR:DDD
     * @param prefixKey
     * @return
     */
    public static String queueKey(String prefixKey){
        if(prefixKey==null||prefixKey.length()==0)
            throw new LhDataAccessException(ServiceErrorEnum.REDIS_KEY_NULL_ERROR);
        return PROJECT_NAME+ENV+":"+prefixKey;
    }

    public static void main(String[] args) {
        System.out.println(key("ss"));
    }

}