package com.bozhong.lhdataaccess.infrastructure.service.impl;

//import com.bozhong.longhuawebsite.client.domain.dto.response.DiseaseInfoRespDTO;
//import com.bozhong.longhuawebsite.client.domain.query.DiseaseByProgramaNameQuery;
//import com.bozhong.longhuawebsite.domain.dbdo.DiseaseInfoDO;
//import com.bozhong.longhuawebsite.domain.model.DiseaseInfoFactory;
//import com.bozhong.longhuawebsite.infrastructure.dao.DiseaseInfoDao;
//import com.bozhong.longhuawebsite.infrastructure.service.DiseaseInfoReadService;
//import com.google.common.base.Function;

import com.bozhong.lhdataaccess.client.common.constants.util.StringUtil;
import com.bozhong.lhdataaccess.common.util.HttpUtil;
import com.bozhong.lhdataaccess.domain.DoctorsNursesDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.infrastructure.dao.DoctorsNursesDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.OrganizStructureDAO;
import com.bozhong.lhdataaccess.infrastructure.service.DoctorsNursesService;
import com.bozhong.lhdataaccess.infrastructure.service.OrganizStructureService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 医护数据的Serviced的实例
 */
@Service("doctorsNursesService")
public class DoctorsNursesServiceImpl implements DoctorsNursesService {

    private static final Logger logger = LoggerFactory.getLogger("dlDataAccessLog");

    @Autowired
    private DoctorsNursesDAO doctorsNursesDAO;

    @Override
    public void dumpDoctorsNursesData(Date lastUpdateTime) {

        int pageIndex = 0;
        int pageSize = 50;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while(true){

            Date currentTime = new Date();

            //避免死循环
            if(pageIndex>500){
                logger.error("医护数据dump的时候，循环超出了范围，时间是"+currentTime);
                break;
            }
            try{
                //调用中兴接口获取医护数据
                Map<String, Object> attributes = new HashMap<String, Object>();
                attributes.put("empCode", "");
                attributes.put("orgCode", "");
                attributes.put("deptCode", "");
                attributes.put("pageIndex",Integer.toString(pageIndex));
                attributes.put("pageSize", Integer.toString(pageSize));
                attributes.put("lastEditedTime", sdf.format(lastUpdateTime));
                Map resultMap = JSONObject.fromObject(HttpUtil.httpPostWithJson("http://118.178.131.147:6003/hospital/personDetails/doctorDetail", attributes));
                Object code = resultMap.get("code");
                if(code==null || !"200".equals(code.toString())){
                    logger.error("医护数据dump的时候，调用接口出错，code = "+code+",msg = "+(String)resultMap.get("msg"));
                    pageIndex = pageIndex+1;
                    continue;
                }

                JSONArray backBodyJson = JSONArray.fromObject(resultMap.get("doctor"));
                if(backBodyJson==null || backBodyJson.size()<=0){
                    logger.error("医护数据dump结束，时间是"+currentTime);
                    break;
                }

                //把返回数据映射为我们自己的DoctorsNursesDO对象,并将DoctorsNursesDO同步到本地库
                for(int i=0;i<backBodyJson.size();i++){
                    JSONObject job = backBodyJson.getJSONObject(i);
                    DoctorsNursesDO doctorsNursesDO = new DoctorsNursesDO();
                    doctorsNursesDO.setName(job.get("name").toString());
                    doctorsNursesDO.setSex(job.get("sexCode").toString());
                    doctorsNursesDO.setMobilePhone(job.get("mobile").toString());
                    doctorsNursesDO.setOrganizStructureCode(job.get("orgCode").toString());
                    doctorsNursesDO.setDepartWardCode(job.get("deptCode").toString());
                    doctorsNursesDO.setDepartWardName(job.get("deptName").toString());
                    doctorsNursesDO.setEmpCode(job.get("empCode").toString());
                    doctorsNursesDO.setJobTitleCode(job.get("jobTitleCode").toString());
                    doctorsNursesDO.setCurrentProfessionalCode(job.get("currentProfessionalCode").toString());
                    doctorsNursesDO.setWorkNumber(job.get("gh").toString());
                    String dateOfBirth = job.get("dateOfBirth").toString();
                    if(StringUtil.isNotBlank(dateOfBirth)&&!"null".equals(dateOfBirth)){
                        doctorsNursesDO.setDateOfBirth(sdf.parse(dateOfBirth));
                    }
                    doctorsNursesDO.setIsOffice(job.get("inOffice").toString());
                    doctorsNursesDO.setLastEditedTime(sdf.parse(job.get("lastEditedTime").toString()));
                    doctorsNursesDO.setValidFlag(job.get("cancelFlag").toString());
                    doctorsNursesDO.setCreateId(0L);
                    doctorsNursesDO.setCreateTime(currentTime);
                    doctorsNursesDO.setUpdateId(0L);
                    doctorsNursesDO.setUpdateTime(currentTime);
                    doctorsNursesDAO.updateOrInsertDoctorsNurses(doctorsNursesDO);
                }
            }catch(Exception e){
                logger.error("医护数据dump的时候报错"+e);
                pageIndex = pageIndex+1;
                continue;
            }
            pageIndex = pageIndex+1;
        }
    }

    @Override
    public List<DoctorsNursesDO> selectNursesDataBylastUpdateTime(Date lastUpdateTime) {
        DoctorsNursesDO doctorsNursesDO = new DoctorsNursesDO();
        doctorsNursesDO.setLastEditedTime(lastUpdateTime);
        doctorsNursesDO.setCurrentProfessionalCode("21");
        return doctorsNursesDAO.selectNursesDataBylastUpdateTime(doctorsNursesDO);
    }

}
