package com.bozhong.lhdataaccess.infrastructure.service;


import com.bozhong.lhdataaccess.domain.OrganizStructureDO;

import java.util.Date;
import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 组织机构数据的Service
 */
public interface OrganizStructureService {

    void dumpOrganizStructureData(Date lastUpdateTime);

    List<OrganizStructureDO> selectDataBylastUpdateTime(Date lastUpdateTime);

}
