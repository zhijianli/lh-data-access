package com.bozhong.lhdataaccess.observation;

import org.springframework.context.ApplicationEvent;

import java.util.Date;
/**
 * User: 李志坚
 * Date: 2018/11/6
 * 获取中兴数据的相关事件
 */
public class DumpDataEvent extends ApplicationEvent {

    public DumpDataEvent(Object source) {
        super(source);
    }
}
