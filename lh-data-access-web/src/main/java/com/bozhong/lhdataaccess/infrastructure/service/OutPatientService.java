package com.bozhong.lhdataaccess.infrastructure.service;


import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.domain.OutPatientDO;
import com.zhicall.core.mybatis.page.Page;
import com.zhicall.core.mybatis.page.PageRequest;

import java.util.Date;
import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 门诊患者数据的Service
 */
public interface OutPatientService {

    void dumpOutPatient(Date lastUpdateTime);

    List<OutPatientDO> selectDataBylastUpdateTime(Date lastUpdateTime);

    Page<OutPatientDO> selectDataByPage(PageRequest pageRequest);

}
