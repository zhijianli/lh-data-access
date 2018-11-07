package com.bozhong.lhdataaccess.infrastructure.dao;

import com.bozhong.lhdataaccess.domain.DoctorOrderDO;
import com.bozhong.lhdataaccess.domain.DoctorPrescriptionDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 处方数据的DAO
 */
public interface DoctorPrescriptionDAO {

    void updateOrInsertDoctorPrescription(DoctorPrescriptionDO doctorPrescriptionDO);

    List<OrganizStructureDO> selectDataBylastUpdateTime(OrganizStructureDO organizStructureDO);
}
