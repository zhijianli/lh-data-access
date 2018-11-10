package com.bozhong.lhdataaccess.rule;

import com.bozhong.lhdataaccess.domain.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 李志坚
 * Date: 2018/11/9
 * 智能推送规则对象
 */
public class RuleMessageDO {

    private String patientType;

    private String scene;

    private Map<String,String> keywordMap = new HashMap<String,String>();

    private InPatientDO inPatientDO;

    private OutPatientDO outPatientDO;

    private List<DoctorOrderDO> doctorOrderList;

    private List<DoctorPrescriptionDO> doctorPrescriptionList;

    private List<DoctorOutDiagnosisDO> doctorOutDiagnosisList;

    private List<DoctorInDiagnosisDO> doctorInDiagnosisList;

    public void putKeywordMap(String key,String value){
        keywordMap.put(key,value);
    }

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public Map<String, String> getKeywordMap() {
        return keywordMap;
    }

    public void setKeywordMap(Map<String, String> keywordMap) {
        this.keywordMap = keywordMap;
    }

    public InPatientDO getInPatientDO() {
        return inPatientDO;
    }

    public void setInPatientDO(InPatientDO inPatientDO) {
        this.inPatientDO = inPatientDO;
    }

    public OutPatientDO getOutPatientDO() {
        return outPatientDO;
    }

    public void setOutPatientDO(OutPatientDO outPatientDO) {
        this.outPatientDO = outPatientDO;
    }

    public List<DoctorOrderDO> getDoctorOrderList() {
        return doctorOrderList;
    }

    public void setDoctorOrderList(List<DoctorOrderDO> doctorOrderList) {
        this.doctorOrderList = doctorOrderList;
    }

    public List<DoctorPrescriptionDO> getDoctorPrescriptionList() {
        return doctorPrescriptionList;
    }

    public void setDoctorPrescriptionList(List<DoctorPrescriptionDO> doctorPrescriptionList) {
        this.doctorPrescriptionList = doctorPrescriptionList;
    }

    public List<DoctorOutDiagnosisDO> getDoctorOutDiagnosisList() {
        return doctorOutDiagnosisList;
    }

    public void setDoctorOutDiagnosisList(List<DoctorOutDiagnosisDO> doctorOutDiagnosisList) {
        this.doctorOutDiagnosisList = doctorOutDiagnosisList;
    }

    public List<DoctorInDiagnosisDO> getDoctorInDiagnosisList() {
        return doctorInDiagnosisList;
    }

    public void setDoctorInDiagnosisList(List<DoctorInDiagnosisDO> doctorInDiagnosisList) {
        this.doctorInDiagnosisList = doctorInDiagnosisList;
    }

}
