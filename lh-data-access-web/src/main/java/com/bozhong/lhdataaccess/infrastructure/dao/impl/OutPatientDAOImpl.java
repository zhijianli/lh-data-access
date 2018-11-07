package com.bozhong.lhdataaccess.infrastructure.dao.impl;

import com.bozhong.lhdataaccess.domain.InPatientDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.domain.OutPatientDO;
import com.bozhong.lhdataaccess.infrastructure.dao.InPatientDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.OutPatientDAO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 组织机构数据的DAO的实例
 */
@Component
public class OutPatientDAOImpl extends BaseDao implements OutPatientDAO {

    @Override
    public void updateOrInsertOutPatient(OutPatientDO outPatientDO) {
        insert("updateOrInsertOutPatient",outPatientDO);
    }

    @Override
    public List<OrganizStructureDO> selectDataBylastUpdateTime(OrganizStructureDO organizStructureDO) {
        return findForList("selectDataBylastUpdateTime",organizStructureDO);
    }

}
