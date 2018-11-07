package com.bozhong.lhdataaccess.infrastructure.dao.impl;

import com.bozhong.lhdataaccess.domain.DoctorOrderDO;
import com.bozhong.lhdataaccess.domain.DoctorPrescriptionDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.infrastructure.dao.DoctorOrderDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.DoctorPrescriptionDAO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 处方数据的DAO的实例
 */
@Component
public class DoctorPrescriptionDAOImpl extends BaseDao implements DoctorPrescriptionDAO {

    @Override
    public void updateOrInsertDoctorPrescription(DoctorPrescriptionDO doctorPrescriptionDO) {
        insert("updateOrInsertDoctorPrescription",doctorPrescriptionDO);
    }

    @Override
    public List<OrganizStructureDO> selectDataBylastUpdateTime(OrganizStructureDO organizStructureDO) {
        return findForList("selectDataBylastUpdateTime",organizStructureDO);
    }

}
