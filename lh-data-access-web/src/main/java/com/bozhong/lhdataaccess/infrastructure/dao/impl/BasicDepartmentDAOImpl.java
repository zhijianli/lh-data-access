package com.bozhong.lhdataaccess.infrastructure.dao.impl;

import com.bozhong.lhdataaccess.domain.BasicDepartmentDO;
import com.bozhong.lhdataaccess.domain.HospitalDO;
import com.bozhong.lhdataaccess.infrastructure.dao.BasicDepartmentDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.HospitalDAO;
import org.springframework.stereotype.Component;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医院科室数据的DAO的实例
 */
@Component
public class BasicDepartmentDAOImpl extends BaseDao implements BasicDepartmentDAO {

    @Override
    public void updateOrInsertBasicDepartment(BasicDepartmentDO basicDepartmentDO) {
        insert("updateOrInsertBasicDepartment",basicDepartmentDO);
    }

    @Override
    public Long selectDeptId(BasicDepartmentDO basicDepartmentDO){
        return (Long)findForObject("selectDeptId",basicDepartmentDO);
    }

}
