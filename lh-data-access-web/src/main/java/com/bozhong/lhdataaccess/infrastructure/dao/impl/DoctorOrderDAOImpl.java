package com.bozhong.lhdataaccess.infrastructure.dao.impl;

import com.bozhong.lhdataaccess.domain.DoctorOrderDO;
import com.bozhong.lhdataaccess.domain.InPatientDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.infrastructure.dao.DoctorOrderDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.InPatientDAO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医嘱数据的DAO的实例
 */
@Component
public class DoctorOrderDAOImpl extends BaseDao implements DoctorOrderDAO {

    @Override
    public void updateOrInsertDoctorOrder(DoctorOrderDO doctorOrderDO) {
        insert("updateOrInsertDoctorOrder",doctorOrderDO);
    }

    @Override
    public List<OrganizStructureDO> selectDataBylastUpdateTime(OrganizStructureDO organizStructureDO) {
        return findForList("selectDataBylastUpdateTime",organizStructureDO);
    }

}
