package com.bozhong.lhdataaccess.observation;


import com.bozhong.lhdataaccess.infrastructure.service.OrganizStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 把中兴的数据同步到医护相关的表，也是观察者之一
 */
@Component
public class DoctorsNursesSyncListener implements ApplicationListener<DumpDataEvent> {

    @Autowired
    private OrganizStructureService organizStructureService;

    @Override
    public void onApplicationEvent(DumpDataEvent event)  {
            Date lastUpdateTime = event.getLastUpdateTime();
            System.out.println("观察者模式已经调通了！！！"+lastUpdateTime);
    }
}
