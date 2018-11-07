package com.bozhong.lhdataaccess.infrastructure.dao.impl;

import com.bozhong.lhdataaccess.domain.DoctorOutDiagnosisDO;
import com.bozhong.lhdataaccess.domain.DoctorPrescriptionDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.infrastructure.dao.DoctorOutDiagnosisDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.DoctorPrescriptionDAO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 门诊诊断数据的DAO的实例
 */
@Component
public class DoctorOutDiagnosisDAOImpl extends BaseDao implements DoctorOutDiagnosisDAO {

    @Override
    public void updateOrInsertDoctorOutDiagnosis(DoctorOutDiagnosisDO doctorOutDiagnosisDO) {
        insert("updateOrInsertDoctorOutDiagnosis",doctorOutDiagnosisDO);
    }

    @Override
    public List<OrganizStructureDO> selectDataBylastUpdateTime(OrganizStructureDO organizStructureDO) {
        return findForList("selectDataBylastUpdateTime",organizStructureDO);
    }

}
