package com.bozhong.lhdataaccess.infrastructure.dao;

import com.bozhong.lhdataaccess.domain.DoctorOutDiagnosisDO;
import com.bozhong.lhdataaccess.domain.DoctorPrescriptionDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 门诊诊断数据的DAO
 */
public interface DoctorOutDiagnosisDAO {

    void updateOrInsertDoctorOutDiagnosis(DoctorOutDiagnosisDO doctorOutDiagnosisDO);

    List<OrganizStructureDO> selectDataBylastUpdateTime(OrganizStructureDO organizStructureDO);
}
