package com.bozhong.lhdataaccess.observation;

import com.api.common.util.StringUtil;
import com.bozhong.lhdataaccess.domain.*;
import com.bozhong.lhdataaccess.infrastructure.dao.BasicDepartmentDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.HospitalDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.HospitalWardDAO;
import com.bozhong.lhdataaccess.infrastructure.service.DoctorsNursesService;
import com.bozhong.lhdataaccess.infrastructure.service.OrganizStructureService;
import com.bozhong.user.domain.core.Result;
import com.bozhong.user.domain.dto.request.SyncUserInfoReqDTO;
import com.bozhong.user.domain.dto.request.SyncUserListReqDTO;
import com.bozhong.user.service.UserWriteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 把中兴的数据同步到医护相关的表，也是观察者之一
 */
@Component
public class DoctorsNursesSyncListener implements SmartApplicationListener{

    private static final Logger logger = LoggerFactory.getLogger("dlDataAccessLog");

    @Autowired
    private OrganizStructureService organizStructureService;

    @Autowired
    private DoctorsNursesService doctorosNursesService;

    @Autowired
    private UserWriteService userWriteService;

    @Autowired
    private HospitalDAO hospitalDAO;

    @Autowired
    private BasicDepartmentDAO basicDepartmentDAO;

    @Autowired
    private HospitalWardDAO hospitalWardDAO;

    @Override
    public void onApplicationEvent(ApplicationEvent event)  {
            DumpDataPubisher dumpDataPubisher = (DumpDataPubisher)((DumpDataEvent)event).getSource();

            Date lastEditedTime =  dumpDataPubisher.getLastEditedTime();

            System.out.println("==============第一步：同步医护数据开始！==============，lastEditedTime = "+lastEditedTime);

//            //第一步：同步中兴组织架构的数据（必须先同步组织架构数据，再同步医护数据，因为医护数据需要依赖组织架构数据）
//            this.organizStructureSync(lastEditedTime);
//
//            //第二步：同步中兴医护的数据
//            this.doctorsNursesSync(lastEditedTime);

            System.out.println("==============第一步：同步医护数据结束！==============，lastEditedTime = "+lastEditedTime);
    }

    private void doctorsNursesSync(Date lastUpdateTime) {
        List<DoctorsNursesDO> dnList = doctorosNursesService.selectNursesDataBylastUpdateTime(lastUpdateTime);
        if(dnList!=null && dnList.size()>0){

            List<SyncUserInfoReqDTO> suiList= new ArrayList<SyncUserInfoReqDTO>();
            for (int i = 0; i < dnList.size(); i++) {
                try{

                DoctorsNursesDO dn = dnList.get(i);
                String currentProfessionalCode = dn.getCurrentProfessionalCode();

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

                //调用用户中心同步数据
                SyncUserInfoReqDTO suiDTO = new SyncUserInfoReqDTO();
                suiDTO.setHospitalId(hosId);
                suiDTO.setJobNumber(empCode);
                suiDTO.setName(name);
                suiDTO.setDeptId(deptId);
                if(wardId!=null){
                    suiDTO.setWardId(wardId.toString());
                }
                suiList.add(suiDTO);

             }catch(Exception e){
                 logger.error("同步医护数据到用户中心出错。"+e);
                 continue;
             }
            }

            SyncUserListReqDTO sylDTO = new SyncUserListReqDTO();
            List<SyncUserInfoReqDTO> tempList= new ArrayList<SyncUserInfoReqDTO>();
            if(suiList!=null && suiList.size()>0){
                for(int i =0;i<suiList.size();i++){
                    tempList.add(suiList.get(i));
                    if(tempList.size()>=50 || i==suiList.size()-1){
                        sylDTO.setSyncUserInfoReqDTOList(tempList);
                        Result<Void> result = userWriteService.syncUserInfo(sylDTO);
                        if(result==null || !result.isSuccess()){
                            logger.error("调用用户中心插入用户失败，msg = "+ result);
                            continue;
                        }
                        tempList.clear();
                    }
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

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return eventType == DumpDataEvent.class;
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return sourceType == DumpDataPubisher.class;
    }

//    @Override
//    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
//        return eventType == DumpDataEvent.class;
//    }
//
//    @Override
//    public boolean supportsSourceType(Class<?> sourceType) {
//        return sourceType == DumpDataPubisher.class;
//    }

}
