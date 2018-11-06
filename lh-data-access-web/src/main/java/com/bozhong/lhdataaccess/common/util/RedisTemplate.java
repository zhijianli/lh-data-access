package com.bozhong.lhdataaccess.common.util;

import com.bozhong.myredis.MyRedis;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: renyueliang
 * Date: 16/10/25
 * Time: 上午9:02
 * To change this template use File | Settings | File Templates.
 */
public class RedisTemplate<T, K> {

   private MyRedis myRedis;

   private OpsForValue opsForValue;

   private OpsForHash opsForHash;

   private final static String SMS_VALID_TIME = "SMS_VALID_TIME";

   public static final int SMS_VALID_SECOND = 60;

    public RedisTemplate() {
        this.opsForValue=new OpsForValue();
    }

    public OpsForValue opsForValue(){

       return  this.opsForValue;


   }

    public OpsForHash opsForHash(){

        return  this.opsForHash;


    }

    public long delete(Object key){
       return myRedis.del(key);
    }

    public long deleteForStr(String key){
        return myRedis.delForStr(key);
    }


    public void expireAt(Object key, Date date){
        myRedis.expireAtDate(key,date);
    }



   public  class OpsForValue{


       /**
        * 查询redis中的 不序列化的key 对应的值
        * @param key key 值
        * @return
        */
       public String getForStr(String key){
           return myRedis.getForStr(key);
       }

        public String get(String key){

        	Object object = myRedis.easyGet(key);
        	if(object==null){
        		return null;
        	}

        	return String.valueOf(object);

        }

        public Object get(Object key, Class clazz){

        	return myRedis.easyGet(key);

        }

        public <T>T easyGet(Object key){
        	return myRedis.easyGet(key);
        }

        public void easyPut(Object key, Object val){
        	 myRedis.easyPut(key, val);
        }

       public long setnx(String key, Object val){
           return myRedis.setnx(key,val);
       }

       public void expire(String key, int timeout){
           myRedis.expire(key,timeout);
       }

       public void easyPutForStr(String key, String val){
           myRedis.putForStr(key, val);
       }

        public void set(String key, Object val){

        	 myRedis.easyPut(key, val);
        }

        public void set(String key, Object val, long timeOut, TimeUnit timeUnit){
            myRedis.easyPut(key,val,timeUnit.toSeconds(timeOut));
        }

        public long increment(Object key, long delta){
           return myRedis.getSequenceAddNum(key,delta);
        }

        public boolean hasKey(Object key) {
            return myRedis.hasKey(key);
        }



    }

   public  class OpsForHash{



       public String get(String key){

             return myRedis.getForStr(key);

       }

       public void put(String hashkey, String key, Object value){

    	   myRedis.put(hashkey+key,value);

     }

       public Object get(String hashkey, String key, Class clazz){

       	return myRedis.get(hashkey+key, clazz);

       }

       public void set(String key, Object val){
           myRedis.put(key,val);
       }

       public void set(String key, Object val, long timeOut, TimeUnit timeUnit){
           myRedis.put(key,val,timeUnit.toSeconds(timeOut));
       }

       public long increment(Object key, long delta){
          return myRedis.getSequenceAddNum(key,delta);
       }
   }

   /** start
    *  获取短信是否重复发送 */
   private String createSmsValidTimeKey(String mobile, String method){
       return SMS_VALID_TIME + "_" + mobile + "_" + method;
   }
   public String getSmsValidTime(String mobile, String method){
       return myRedis.get(createSmsValidTimeKey(mobile, method), String.class);
   }
   public void putSmsValidTime(String mobile, String method, String code){
       myRedis.put(createSmsValidTimeKey(mobile, method), code, SMS_VALID_SECOND);
   }
   /** 获取短信是否重复发送
    * end */



    public void setMyRedis(MyRedis myRedis) {
        this.myRedis = myRedis;
    }

	public boolean hasKey(String key) {
		// TODO Auto-generated method stub
	     return	this.myRedis.hasKey(key);
	}

	public void expire(String tokenIm, Integer expiresIn, TimeUnit seconds) {
		this.myRedis.expire(tokenIm, expiresIn);

	}
}
