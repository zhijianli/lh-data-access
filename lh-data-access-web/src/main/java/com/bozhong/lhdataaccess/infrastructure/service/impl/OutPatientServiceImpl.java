package com.bozhong.lhdataaccess.infrastructure.service.impl;

import com.bozhong.lhdataaccess.common.util.HttpUtil;
import com.bozhong.lhdataaccess.domain.InPatientDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.domain.OutPatientDO;
import com.bozhong.lhdataaccess.infrastructure.dao.InPatientDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.OutPatientDAO;
import com.bozhong.lhdataaccess.infrastructure.service.InPatientService;
import com.bozhong.lhdataaccess.infrastructure.service.OutPatientService;
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
 * 住院患者数据的Serviced的实例
 */
@Service("outPatientService")
public class OutPatientServiceImpl implements OutPatientService {

    private static final Logger logger = LoggerFactory.getLogger("dlDataAccessLog");

    @Autowired
    private OutPatientDAO outPatientDAO;

    @Override
    public void dumpOutPatient(Date lastUpdateTime) {

        int pageIndex = 0;
        int pageSize = 50;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentTime = new Date();
        while(true){

            //避免死循环
            if(pageIndex>2000){
                logger.error("门诊患者数据dump的时候，循环超出了范围，时间是"+currentTime);
                break;
            }
            try{
                //调用中兴接口获取门诊患者数据
                Map<String, String> attributes = new HashMap<String, String>();
                attributes.put("orgCode", "");
                attributes.put("personId", "");
                attributes.put("deptCode", "");
                attributes.put("wardCode", "");
                attributes.put("pageIndex",Integer.toString(pageIndex));
                attributes.put("pageSize", Integer.toString(pageSize));
                attributes.put("lastEditedTime", sdf.format(lastUpdateTime));
                Map resultMap = JSONObject.fromObject(HttpUtil.httpPostWithJson("http://118.178.131.147:6002/personDetails/organizationDetail", attributes));
                JSONArray backBodyJson = JSONArray.fromObject(resultMap.get("outpatientDetail"));
                if(backBodyJson==null || backBodyJson.size()<=0){
                    logger.error("门诊患者数据dump结束，时间是"+currentTime);
                    break;
                }

                //把返回数据映射为我们自己的OutPatientDO对象,并将OutPatientDO同步到本地库
                for(int i=0;i<backBodyJson.size();i++){
                    JSONObject job = backBodyJson.getJSONObject(i);
                    OutPatientDO outPatientDO = new OutPatientDO();
                    outPatientDO.setPatientId(job.get("personId").toString());
                    outPatientDO.setPatientName(job.get("name").toString());
                    outPatientDO.setOrganizStructureCode(job.get("orgCode").toString());
                    outPatientDO.setTelephone(job.get("tel").toString());
                    outPatientDO.setIdNumber(job.get("idcard").toString());
//                    outPatientDO.setDateOfBirth();
//                    outPatientDO.setIsRevisit();
//                    outPatientDO.setAttendingDoctorName();
                    outPatientDO.setDepartCode(job.get("deptCode").toString());
                    outPatientDO.setDepartName(job.get("deptName").toString());
                    outPatientDO.setVisitTime(sdf.parse(job.get("admissionsTime").toString()));
                    outPatientDO.setVisitRecord(job.get("visitCount").toString());
                    outPatientDO.setVisitCardNumber(job.get("orgInternalId").toString());
                    outPatientDO.setValidFlag(job.get("cancelFlag").toString());
                    outPatientDO.setCreateId(0L);
                    outPatientDO.setCreateTime(sdf.parse(job.get("admitDate").toString()));
                    outPatientDO.setUpdateId(0L);
                    outPatientDO.setUpdateTime(sdf.parse(job.get("lastEditedTime").toString()));
                    outPatientDAO.updateOrInsertOutPatient(outPatientDO);
                }
            }catch(Exception e){
                logger.error("门诊患者数据dump的时候报错"+e);
            }
            pageIndex = pageIndex+1;
        }
    }

    @Override
    public List<OrganizStructureDO> selectDataBylastUpdateTime(Date lastUpdateTime) {
        OrganizStructureDO organizStructureDO = new OrganizStructureDO();
        organizStructureDO.setUpdateTime(lastUpdateTime);
//        return organizStructureDAO.selectDataBylastUpdateTime(organizStructureDO);
        return null;
    }

}
