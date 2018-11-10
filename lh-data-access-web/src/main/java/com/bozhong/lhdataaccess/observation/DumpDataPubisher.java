package com.bozhong.lhdataaccess.observation;

import com.bozhong.lhdataaccess.infrastructure.service.*;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 调用中兴的接口入本地库的类，也是被观察者
 */
@Component("dumpDataPubisher")
public class DumpDataPubisher implements ApplicationContextAware {

    private Date lastEditedTime;

    public Date getLastEditedTime() {
        return lastEditedTime;
    }

    public void setLastEditedTime(Date lastEditedTime) {
        this.lastEditedTime = lastEditedTime;
    }

    @Autowired
    private OrganizStructureService organizStructureService;

    @Autowired
    private DoctorsNursesService doctorsNursesService;

    @Autowired
    private InPatientService inPatientService;

    @Autowired
    private OutPatientService outPatientService;

    @Autowired
    private DoctorOrderService doctorOrderService;

    @Autowired
    private DoctorPrescriptionService doctorPrescriptionService;

    @Autowired
    private DoctorOutDiagnosisService doctorOutDiagnosisService;

    @Autowired
    private DoctorInDiagnosisService doctorInDiagnosisService;

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
    public void publishEvent(DumpDataEvent event){

        Boolean operationSuccess = false;

        Date lastUpdateTime = this.lastEditedTime;

        //dump组织机构的数据
        organizStructureService.dumpOrganizStructureData(lastUpdateTime);

        //dump医护的数据
//        doctorsNursesService.dumpDoctorsNursesData(lastUpdateTime);

        //dump门诊患者的数据
//        outPatientService.dumpOutPatient(lastUpdateTime);
//
//        //dump住院患者的数据
//        inPatientService.dumpInPatient(lastUpdateTime);
//
//        //dump医嘱的数据
//        doctorOrderService.dumpDoctorOrder(lastUpdateTime);
//
//        //dump处方的数据
//        doctorPrescriptionService.dumpDoctorPrescription(lastUpdateTime);
//
//        //dump门诊诊断的数据
//        doctorOutDiagnosisService.dumpDoctorOutDiagnosis(lastUpdateTime);
//
//        //dump住院诊断的数据
//        doctorInDiagnosisService.dumpDoctorInDiagnosis(lastUpdateTime);



        //dump数据成功，发布事件（必须要前面的操作都执行成功了才能进行这步操作）
        operationSuccess = true;
        if(operationSuccess){
            applicationContext.publishEvent(event);
        }

    }

}
