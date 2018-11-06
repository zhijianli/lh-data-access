package com.bozhong.lhdataaccess.infrastructure.dao.impl;

import com.bozhong.lhdataaccess.domain.HospitalDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.infrastructure.dao.HospitalDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.OrganizStructureDAO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医院数据的DAO的实例
 */
@Component
public class HospitalDAOImpl extends BaseDao implements HospitalDAO {

    @Override
    public void updateOrInsertHospital(HospitalDO hospitalDO) {
        insert("updateOrInsertHospital",hospitalDO);
    }

}
