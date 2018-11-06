package com.bozhong.lhdataaccess.observation;

import com.bozhong.lhdataaccess.infrastructure.service.DoctorsNursesService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import com.bozhong.lhdataaccess.infrastructure.service.OrganizStructureService;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 调用中兴的接口入本地库的类，也是被观察者
 */
@Component("dumpDataPubisher")
public class DumpDataPubisher implements ApplicationContextAware {

    @Autowired
    private OrganizStructureService organizStructureService;

    @Autowired
    private DoctorsNursesService doctorsNursesService;

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
    public void publishEvent(DumpDataEvent event){

        Boolean operationSuccess = false;

        //dump组织机构的数据
//        organizStructureService.dumpOrganizStructureData(event.getLastUpdateTime());

        //dump医护的数据
//        doctorsNursesService.dumpDoctorsNursesData(event.getLastUpdateTime());

        //dump数据成功，发布事件（必须要前面的操作都执行成功了才能进行这步操作）
        operationSuccess = true;
        if(operationSuccess){
            applicationContext.publishEvent(event);
        }

    }

}
