package com.bozhong.lhdataaccess.infrastructure.dao.impl;

import com.bozhong.lhdataaccess.domain.DoctorsNursesDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.infrastructure.dao.DoctorsNursesDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.OrganizStructureDAO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医护数据的DAO的实例
 */
@Component
public class DoctorsNursesDAOImpl extends BaseDao implements DoctorsNursesDAO {

    @Override
    public void updateOrInsertDoctorsNurses(DoctorsNursesDO doctorsNursesDO) {
        insert("updateOrInsertDoctorsNurses",doctorsNursesDO);
    }

    @Override
    public List<DoctorsNursesDO> selectDataBylastUpdateTime(DoctorsNursesDO doctorsNursesDO) {
        return findForList("selectDataBylastUpdateTime",doctorsNursesDO);
    }

}
