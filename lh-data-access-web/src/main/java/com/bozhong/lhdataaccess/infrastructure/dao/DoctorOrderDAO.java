package com.bozhong.lhdataaccess.infrastructure.dao;

import com.bozhong.lhdataaccess.domain.DoctorOrderDO;
import com.bozhong.lhdataaccess.domain.InPatientDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医嘱数据的DAO
 */
public interface DoctorOrderDAO {

    void updateOrInsertDoctorOrder(DoctorOrderDO doctorOrderDO);

    List<OrganizStructureDO> selectDataBylastUpdateTime(OrganizStructureDO organizStructureDO);
}
