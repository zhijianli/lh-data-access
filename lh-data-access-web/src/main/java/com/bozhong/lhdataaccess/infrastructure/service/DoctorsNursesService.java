package com.bozhong.lhdataaccess.infrastructure.service;


import com.bozhong.lhdataaccess.domain.DoctorsNursesDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;

import java.util.Date;
import java.util.List;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医护数据的Service
 */
public interface DoctorsNursesService {

    void dumpDoctorsNursesData(Date lastUpdateTime);

    List<DoctorsNursesDO> selectNursesDataBylastUpdateTime(Date lastUpdateTime);

}
