package com.bozhong.lhdataaccess.observation;

import com.api.common.util.StringUtil;
import com.bozhong.lhdataaccess.domain.*;
import com.bozhong.lhdataaccess.infrastructure.dao.BasicDepartmentDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.HospitalDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.HospitalWardDAO;
import com.bozhong.lhdataaccess.infrastructure.service.DoctorsNursesService;
import com.bozhong.lhdataaccess.infrastructure.service.OrganizStructureService;
import com.bozhong.user.domain.core.Result;
import com.bozhong.user.domain.dto.request.SyncUserInfoReqDTO;
import com.bozhong.user.domain.dto.request.SyncUserListReqDTO;
import com.bozhong.user.service.UserWriteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 生存患者数据，也是观察者之一
 */
@Component
public class GeneratePatientDataListener implements SmartApplicationListener{

    private static final Logger logger = LoggerFactory.getLogger("dlDataAccessLog");

    @Override
    public void onApplicationEvent(ApplicationEvent event)  {
            DumpDataPubisher dumpDataPubisher = (DumpDataPubisher)((DumpDataEvent)event).getSource();

            Date lastEditedTime =  dumpDataPubisher.getLastEditedTime();

            System.out.println("==============第二步：生成患者数据开始！==============，lastEditedTime = "+lastEditedTime);

            System.out.println("==============第二步：生成患者数据结束！==============，lastEditedTime = "+lastEditedTime);
    }


    @Override
    public int getOrder() {
        return 2;
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == DumpDataEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == DumpDataPubisher.class;
    }

}
