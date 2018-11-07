package com.bozhong.lhdataaccess.observation;

import com.api.common.util.StringUtil;
import com.bozhong.lhdataaccess.domain.*;
import com.bozhong.lhdataaccess.infrastructure.dao.BasicDepartmentDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.HospitalDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.HospitalWardDAO;
import com.bozhong.lhdataaccess.infrastructure.service.DoctorsNursesService;
import com.bozhong.lhdataaccess.infrastructure.service.OrganizStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
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
    private DoctorsNursesService doctorosNudrsesService;

    @Autowired
    private HospitalDAO hospitalDAO;

    @Autowired
    private BasicDepartmentDAO basicDepartmentDAO;

    @Autowired
    private HospitalWardDAO hospitalWardDAO;

    @Override
    public void onApplicationEvent(DumpDataEvent event)  {
            Date lastUpdateTime = event.getLastUpdateTime();

            //第一步：同步中兴组织架构的数据（必须先同步组织架构数据，再同步医护数据，因为医护数据需要依赖组织架构数据）
            this.organizStructureSync(lastUpdateTime);

            //第二步：同步中兴医护的数据
            this.doctorsNursesSync(lastUpdateTime);
    }

    private void doctorsNursesSync(Date lastUpdateTime) {
        List<DoctorsNursesDO> dnList = doctorosNudrsesService.selectDataBylastUpdateTime(lastUpdateTime);
        if(dnList!=null && dnList.size()>0){
            for (int i = 0; i < dnList.size(); i++) {

                DoctorsNursesDO dn = dnList.get(i);
                String currentProfessionalCode = dn.getCurrentProfessionalCode();
                if("21".equals(currentProfessionalCode)){

                      //获取医院id
                      String osCode = dn.getOrganizStructureCode();
                      HospitalDO hospitalDO = new HospitalDO();
                      hospitalDO.setCode(osCode);
                      Long hosId = hospitalDAO.selectHospitalId(hospitalDO);

                      //获取病区id，科室id
                      String wardCode = dn.getDepartWardCode();
                      HospitalWardDO hospitalWardDO = new HospitalWardDO();
                      hospitalWardDO.setHospitalId(hosId);
                      hospitalWardDO.setCode(wardCode);
                      HospitalWardDO hwDO = hospitalWardDAO.selectHospitalWardDO(hospitalWardDO);
                      Long wardId = hwDO.getId();
                      Long deptId = hwDO.getDeptId();

                      //获取员工号，用户名字
                      String name = dn.getName();
                      String empCode = dn.getEmpCode();

//                        AccountDO accountDO = new AccountDO();
//                        accountDO.setLogin();
//                        accountDO.setPassword();
//                        accountDO.setName(dn.getName());
//                        accountDO.setHospitalIds();
//                        accountDO.setWardId();
//                        accountDO.setValidFlag(dn.getValidFlag());
//                        accountDO.setCreateId(dn.getCreateId());
//                        accountDO.setCreateTime(dn.getCreateTime());
//                        accountDO.setUpdateId(dn.getUpdateId());
//                        accountDO.setUpdateTime(dn.getUpdateTime());
                }
            }
        }
    }

    //同步中兴组织架构的数据
    private void organizStructureSync(Date lastUpdateTime) {
        Map<String,Long> osCodeMap = new HashMap<String,Long>();

        //获取中兴组织架构的数据
        List<OrganizStructureDO> osList = organizStructureService.selectDataBylastUpdateTime(lastUpdateTime);

        if(osList!=null && osList.size()>0){
            for (int i = 0; i < osList.size(); i++) {
                OrganizStructureDO os = osList.get(i);
                String osCode = os.getOrganizStructureCode();

                //同步医院
                if (!osCodeMap.containsKey(osCode)) {
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
                    Long hosId =  hospitalDAO.selectHospitalId(hospitalDO);
                    osCodeMap.put(osCode,hosId);
                }

                Long hospitalId = osCodeMap.get(osCode);

                //同步科室
                BasicDepartmentDO bdDO = new BasicDepartmentDO();
                bdDO.setHospitalId(hospitalId);
                bdDO.setName(os.getDepartName());
                bdDO.setCode(os.getDepartCode());
                bdDO.setValidFlag(os.getValidFlag());
                bdDO.setCreateBy(os.getCreateId());
                bdDO.setCreateTime(os.getCreateTime());
                bdDO.setUpdateBy(os.getUpdateId());
                bdDO.setUpdateTime(os.getUpdateTime());
                basicDepartmentDAO.updateOrInsertBasicDepartment(bdDO);
                Long deptId = basicDepartmentDAO.selectDeptId(bdDO);

                //同步病区
                String ward = os.getWardCode();
                if(StringUtil.isNotBlank(ward) && !"null".equals(ward)){
                    HospitalWardDO hwDO= new HospitalWardDO();
                    hwDO.setHospitalId(hospitalId);
                    hwDO.setName(os.getWardName());
                    hwDO.setCode(ward);
                    hwDO.setDeptId(deptId);
                    hwDO.setValidFlag(os.getValidFlag());
                    hwDO.setCreateBy(os.getCreateId());
                    hwDO.setCreateTime(os.getCreateTime());
                    hwDO.setUpdateBy(os.getUpdateId());
                    hwDO.setUpdateTime(os.getUpdateTime());
                    hospitalWardDAO.updateOrInsertHospitalWard(hwDO);
                }
            }
        }
    }
}
