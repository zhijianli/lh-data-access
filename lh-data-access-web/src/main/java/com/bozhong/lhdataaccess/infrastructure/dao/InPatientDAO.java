package com.bozhong.lhdataaccess.infrastructure.dao;

import com.bozhong.lhdataaccess.domain.InPatientDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 住院患者数据的DAO
 */
public interface InPatientDAO {

    void updateOrInsertInPatient(InPatientDO inPatientDO);

    List<OrganizStructureDO> selectDataBylastUpdateTime(OrganizStructureDO organizStructureDO);
}
