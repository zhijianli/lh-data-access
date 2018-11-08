package com.bozhong.lhdataaccess.observation;


import com.bozhong.lhdataaccess.infrastructure.dao.BasicDepartmentDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.HospitalDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.HospitalWardDAO;
import com.bozhong.lhdataaccess.infrastructure.service.DoctorsNursesService;
import com.bozhong.lhdataaccess.infrastructure.service.OrganizStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 把根据患者相关信息推送消息，也是观察者之一
 */
@Component
public class PushMessageListener implements ApplicationListener<DumpDataEvent> {

    private static final Logger logger = LoggerFactory.getLogger("dlDataAccessLog");

    @Autowired
    private OrganizStructureService organizStructureService;

    @Autowired
    private DoctorsNursesService doctorosNudrsesService;

    @Autowired
    private HospitalDAO hospitalDAO;

    @Autowired
    private BasicDepartmentDAO basicDepartmentDAO;

    @Autowired
    private HospitalWardDAO hospitalWardDAO;

    @Override
    public void onApplicationEvent(DumpDataEvent event)  {
        Date lastUpdateTime = event.getLastUpdateTime();

        System.out.println("+++++++推送消息开始！++++++");

    }

//    @Override
//    public int getOrder() {
//        return 1;
//    }
//
//    @Override
//    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
//        return eventType == DumpDataEvent.class;
//    }
//
//    @Override
//    public boolean supportsSourceType(Class<?> sourceType) {
//        return sourceType == DumpDataPubisher.class;
//    }

}
