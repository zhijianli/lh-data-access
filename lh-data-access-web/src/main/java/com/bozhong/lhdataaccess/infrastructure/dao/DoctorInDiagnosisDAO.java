package com.bozhong.lhdataaccess.infrastructure.dao;

import com.bozhong.lhdataaccess.domain.DoctorInDiagnosisDO;
import com.bozhong.lhdataaccess.domain.DoctorOutDiagnosisDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 住院诊断数据的DAO
 */
public interface DoctorInDiagnosisDAO {

    void updateOrInsertDoctorInDiagnosis(DoctorInDiagnosisDO doctorInDiagnosisDO);

    List<OrganizStructureDO> selectDataBylastUpdateTime(OrganizStructureDO organizStructureDO);
}
