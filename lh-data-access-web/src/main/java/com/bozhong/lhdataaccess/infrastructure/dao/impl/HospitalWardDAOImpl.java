package com.bozhong.lhdataaccess.infrastructure.dao.impl;

import com.bozhong.lhdataaccess.domain.BasicDepartmentDO;
import com.bozhong.lhdataaccess.domain.HospitalDO;
import com.bozhong.lhdataaccess.domain.HospitalWardDO;
import com.bozhong.lhdataaccess.infrastructure.dao.HospitalDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.HospitalWardDAO;
import org.springframework.stereotype.Component;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医院病区数据的DAO的实例
 */
@Component
public class HospitalWardDAOImpl extends BaseDao implements HospitalWardDAO {

    @Override
    public void updateOrInsertHospitalWard(HospitalWardDO hospitalWardDO) {
        insert("updateOrInsertHospitalWard",hospitalWardDO);
    }

    @Override
    public HospitalWardDO selectHospitalWardDO(HospitalWardDO hospitalWardDO){
        return (HospitalWardDO)findForObject("selectHospitalWardDO",hospitalWardDO);
    }

}
