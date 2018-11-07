package com.bozhong.lhdataaccess.infrastructure.dao;

import com.bozhong.lhdataaccess.domain.BasicDepartmentDO;
import com.bozhong.lhdataaccess.domain.HospitalDO;
import com.bozhong.lhdataaccess.domain.HospitalWardDO;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医院病区数据的DAO
 */
public interface HospitalWardDAO {

    void updateOrInsertHospitalWard(HospitalWardDO hospitalWardDO);

    HospitalWardDO selectHospitalWardDO(HospitalWardDO hospitalWardDO);

}
