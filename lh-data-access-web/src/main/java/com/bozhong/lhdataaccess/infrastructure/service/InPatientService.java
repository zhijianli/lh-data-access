package com.bozhong.lhdataaccess.infrastructure.service;


import com.bozhong.lhdataaccess.domain.InPatientDO;
import com.zhicall.core.mybatis.page.Page;
import com.zhicall.core.mybatis.page.PageRequest;

import java.util.Date;
import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 住院患者数据的Service
 */
public interface InPatientService {

    void dumpInPatient(Date lastUpdateTime);

    List<InPatientDO> selectDataBylastUpdateTime(Date lastUpdateTime);

    Page<InPatientDO> selectDataByPage(PageRequest pageRequest);

}
