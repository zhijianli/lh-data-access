package com.bozhong.lhdataaccess.infrastructure.dao.impl;

import com.bozhong.lhdataaccess.domain.DoctorInDiagnosisDO;
import com.bozhong.lhdataaccess.domain.DoctorOutDiagnosisDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.infrastructure.dao.DoctorInDiagnosisDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.DoctorOutDiagnosisDAO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 住院诊断数据的DAO的实例
 */
@Component
public class DoctorInDiagnosisDAOImpl extends BaseDao implements DoctorInDiagnosisDAO {

    @Override
    public void updateOrInsertDoctorInDiagnosis(DoctorInDiagnosisDO doctorInDiagnosisDO) {
        insert("updateOrInsertDoctorInDiagnosis",doctorInDiagnosisDO);
    }


    @Override
    public List<DoctorInDiagnosisDO> selectDidDataByDoctorInDiagnosisDO(DoctorInDiagnosisDO doctorInDiagnosisDO) {
        return findForList("selectDidDataByDoctorInDiagnosisDO",doctorInDiagnosisDO);
    }

}
