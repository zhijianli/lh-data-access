package com.bozhong.lhdataaccess.observation;


import com.bozhong.lhdataaccess.domain.HospitalDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.infrastructure.dao.HospitalDAO;
import com.bozhong.lhdataaccess.infrastructure.service.OrganizStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 把中兴的数据同步到医护相关的表，也是观察者之一
 */
@Component
public class DoctorsNursesSyncListener implements ApplicationListener<DumpDataEvent> {

    private static final Logger logger = LoggerFactory.getLogger("dlDataAccessLog");

    @Autowired
    private OrganizStructureService organizStructureService;

    @Autowired
    private HospitalDAO hospitalDAO;

    @Override
    public void onApplicationEvent(DumpDataEvent event)  {
            Date lastUpdateTime = event.getLastUpdateTime();
            List<String> osCodeList = new ArrayList<String>();
            //获取中兴组织架构的数据
            List<OrganizStructureDO> osList = organizStructureService.selectDataBylastUpdateTime(lastUpdateTime);

            //同步医院
            if(osList!=null && osList.size()>0){
                for (int i = 0; i < osList.size(); i++) {
                    OrganizStructureDO os = osList.get(i);
                    String osCode = os.getOrganizStructureCode();
                    if (!osCodeList.contains(osCode)) {
                        osCodeList.add(osCode);
                        HospitalDO hospitalDO = new HospitalDO();
                        hospitalDO.setName("医院名字");
                        hospitalDO.setOpenFlag(1);
                        hospitalDO.setInner(true);
                        hospitalDO.setCode(osCode);
                        hospitalDO.setValidFlag(os.getValidFlag());
                        hospitalDO.setCreateTime(os.getCreateTime());
                        hospitalDO.setUpdateTime(os.getUpdateTime());
                        hospitalDO.setCreateBy(os.getCreateId());
                        hospitalDO.setUpdateBy(os.getUpdateId());
                        hospitalDAO.updateOrInsertHospital(hospitalDO);
                    }
                }
            }


            //同步科室


            //同步病区




            System.out.println("观察者模式已经调通了！！！"+lastUpdateTime);
    }
}
