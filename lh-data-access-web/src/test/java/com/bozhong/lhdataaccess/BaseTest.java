package com.bozhong.lhdataaccess;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Auther: chenq
 * @Date: 2018/11/1 12:26
 * @Description:
 */
public class BaseTest {
    protected ApplicationContext applicationContext;
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext-basic.xml");
    }

    protected void printJson(Object object){
        System.out.println(JSONObject.toJSONString(object));
    }
}
