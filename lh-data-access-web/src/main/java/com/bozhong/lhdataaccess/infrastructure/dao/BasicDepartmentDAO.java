package com.bozhong.lhdataaccess.infrastructure.dao;

import com.bozhong.lhdataaccess.domain.BasicDepartmentDO;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医院科室数据的DAO
 */
public interface BasicDepartmentDAO {

    void updateOrInsertBasicDepartment(BasicDepartmentDO basicDepartmentDO);

    Long selectDeptId(BasicDepartmentDO basicDepartmentDO);

}
