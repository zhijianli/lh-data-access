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
 * 门诊患者数据的DAO
 */
public interface OutPatientDAO {

    void updateOrInsertOutPatient(OutPatientDO outPatientDO);

    List<OutPatientDO> selectDataBylastUpdateTime(OutPatientDO outPatientDO);

    Page<OutPatientDO> selectDataByPage(PageRequest pageRequest);

}
