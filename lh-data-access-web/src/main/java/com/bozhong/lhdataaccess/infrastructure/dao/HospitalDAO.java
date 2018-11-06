package com.bozhong.lhdataaccess.infrastructure.dao;

import com.bozhong.lhdataaccess.domain.HospitalDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医院数据的DAO
 */
public interface HospitalDAO {

    void updateOrInsertHospital(HospitalDO hospitalDO);

}
