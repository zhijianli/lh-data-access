package com.bozhong.lhdataaccess.infrastructure.dao;

import com.bozhong.lhdataaccess.domain.InPatientDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.domain.OutPatientDO;
import com.zhicall.core.mybatis.page.Page;
import com.zhicall.core.mybatis.page.PageRequest;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 住院患者数据的DAO
 */
public interface InPatientDAO {

    void updateOrInsertInPatient(InPatientDO inPatientDO);

    List<InPatientDO> selectDataBylastUpdateTime(InPatientDO inPatientDO);

    Page<InPatientDO> selectDataByPage(PageRequest pageRequest);
}
