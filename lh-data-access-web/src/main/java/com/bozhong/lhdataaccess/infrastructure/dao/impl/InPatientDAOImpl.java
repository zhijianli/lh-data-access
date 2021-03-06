package com.bozhong.lhdataaccess.infrastructure.dao.impl;

import com.bozhong.lhdataaccess.domain.InPatientDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.domain.OutPatientDO;
import com.bozhong.lhdataaccess.infrastructure.dao.InPatientDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.OrganizStructureDAO;
import com.zhicall.core.mybatis.page.Page;
import com.zhicall.core.mybatis.page.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 组织机构数据的DAO的实例
 */
@Component
public class InPatientDAOImpl extends BaseDao implements InPatientDAO {

    @Override
    public void updateOrInsertInPatient(InPatientDO inPatientDO) {
        insert("updateOrInsertInPatient",inPatientDO);
    }

    @Override
    public List<InPatientDO> selectDataBylastUpdateTime(InPatientDO inPatientDO) {
        return findForList("selectIpDataBylastUpdateTime",inPatientDO);
    }


    @Override
    public Page<InPatientDO> selectDataByPage(PageRequest pageRequest) {
        return findForPage("selectIpDataByPage",pageRequest);
    }

}
