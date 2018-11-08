package com.bozhong.lhdataaccess.infrastructure.service.impl;

import com.bozhong.lhdataaccess.common.util.HttpUtil;
import com.bozhong.lhdataaccess.domain.DoctorInDiagnosisDO;
import com.bozhong.lhdataaccess.domain.DoctorOutDiagnosisDO;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.infrastructure.dao.DoctorInDiagnosisDAO;
import com.bozhong.lhdataaccess.infrastructure.dao.DoctorOutDiagnosisDAO;
import com.bozhong.lhdataaccess.infrastructure.service.DoctorInDiagnosisService;
import com.bozhong.lhdataaccess.infrastructure.service.DoctorOutDiagnosisService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 住院诊断数据的Serviced的实例
 */
@Service("doctorInDiagnosisService")
public class DoctorInDiagnosisServiceImpl implements DoctorInDiagnosisService {

    private static final Logger logger = LoggerFactory.getLogger("dlDataAccessLog");

    @Autowired
    private DoctorInDiagnosisDAO doctorInDiagnosisDAO;

    @Override
    public void dumpDoctorInDiagnosis(Date lastUpdateTime) {

        int pageIndex = 0;
        int pageSize = 50;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while(true){

            Date currentTime = new Date();

            //避免死循环
            if(pageIndex>2000){
                logger.error("住院诊断数据dump的时候，循环超出了范围，时间是"+currentTime);
                break;
            }
            try{
                //调用中兴接口获取住院诊断数据
                List<Map<String,String>> dataList = new ArrayList<Map<String,String>>();
                Map<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("orgCode","");
                dataMap.put("personId","");
                dataMap.put("inSno","");
                dataList.add(dataMap);

                Map<String, Object> attributes = new HashMap<String, Object>();
                attributes.put("pageIndex",Integer.toString(pageIndex));
                attributes.put("pageSize", Integer.toString(pageSize));
                attributes.put("lastEditedTime", sdf.format(lastUpdateTime));
                Map resultMap = JSONObject.fromObject(HttpUtil.httpPostWithJson("http://118.178.131.147:6003/hospital/personDetails/inDiagnosticInfo", attributes));
                Object code = resultMap.get("code");
                if(code==null || !"200".equals(code.toString())){
                    logger.error("住院诊断数据dump的时候，调用接口出错，code = "+code+",msg = "+(String)resultMap.get("msg"));
                    pageIndex = pageIndex+1;
                    continue;
                }

                JSONArray backBodyJson = JSONArray.fromObject(resultMap.get("inDiagnosticInfo"));
                if(backBodyJson==null || backBodyJson.size()<=0){
                    logger.error("住院诊断数据dump结束，时间是"+currentTime);
                    break;
                }

                //把返回数据映射为我们自己的OutPatientDO对象,并将OutPatientDO同步到本地库
                for(int i=0;i<backBodyJson.size();i++){
                    JSONObject job = backBodyJson.getJSONObject(i);
                    DoctorInDiagnosisDO doctorInDiagnosisDO = new DoctorInDiagnosisDO();
                    doctorInDiagnosisDO.setDoctorDiagnosisNumber(job.get("diagSno").toString());
                    doctorInDiagnosisDO.setDoctorDiagnosisName(job.get("diagName").toString());
                    doctorInDiagnosisDO.setDoctorDiagnosisCode(job.get("diagCode").toString());
                    doctorInDiagnosisDO.setPatientId(job.get("patientId").toString());
                    doctorInDiagnosisDO.setOrganizStructureCode(job.get("orgCode").toString());
                    doctorInDiagnosisDO.setLastEditedTime(sdf.parse(job.get("lastEditedTime").toString()));
                    doctorInDiagnosisDO.setValidFlag(job.get("cancelFlag").toString());
                    doctorInDiagnosisDO.setCreateId(0L);
                    doctorInDiagnosisDO.setCreateTime(currentTime);
                    doctorInDiagnosisDO.setUpdateId(0L);
                    doctorInDiagnosisDO.setUpdateTime(currentTime);
                    doctorInDiagnosisDAO.updateOrInsertDoctorInDiagnosis(doctorInDiagnosisDO);
                }
            }catch(Exception e){
                logger.error("住院诊断数据dump的时候报错"+e);
                pageIndex = pageIndex+1;
                continue;
            }
            pageIndex = pageIndex+1;
        }
    }

    @Override
    public List<OrganizStructureDO> selectDataBylastUpdateTime(Date lastUpdateTime) {
        OrganizStructureDO organizStructureDO = new OrganizStructureDO();
        organizStructureDO.setLastEditedTime(lastUpdateTime);
//        return organizStructureDAO.selectDataBylastUpdateTime(organizStructureDO);
        return null;
    }

}
