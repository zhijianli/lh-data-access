package com.bozhong.lhdataaccess.infrastructure.service.impl;

//import com.bozhong.longhuawebsite.client.domain.dto.response.DiseaseInfoRespDTO;
//import com.bozhong.longhuawebsite.client.domain.query.DiseaseByProgramaNameQuery;
//import com.bozhong.longhuawebsite.domain.dbdo.DiseaseInfoDO;
//import com.bozhong.longhuawebsite.domain.model.DiseaseInfoFactory;
//import com.bozhong.longhuawebsite.infrastructure.dao.DiseaseInfoDao;
//import com.bozhong.longhuawebsite.infrastructure.service.DiseaseInfoReadService;
//import com.google.common.base.Function;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import com.bozhong.lhdataaccess.common.util.HttpUtil;
import com.bozhong.lhdataaccess.domain.OrganizStructureDO;
import com.bozhong.lhdataaccess.infrastructure.dao.OrganizStructureDAO;
import com.bozhong.lhdataaccess.infrastructure.service.OrganizStructureService;

import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: 李志坚
 * Date: 2018/11/5
 * 组织机构数据的Serviced的实例
 */
@Service("organizStructureService")
public class OrganizStructureServiceImpl implements OrganizStructureService {

    private static final Logger logger = LoggerFactory.getLogger("dlDataAccessLog");

    @Autowired
    private OrganizStructureDAO organizStructureDAO;

    @Override
    public void dumpOrganizStructureData(Date lastUpdateTime) {

        int pageIndex = 0;
        int pageSize = 50;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date currentTime = new Date();
        while(true){

            //避免死循环
            if(pageIndex>2000){
                logger.error("组织机构数据dump的时候，循环超出了范围，时间是"+currentTime);
                break;
            }
            try{
                //调用中兴接口获取组织机构代码数据
                Map<String, String> attributes = new HashMap<String, String>();
                attributes.put("orgCode", "");
                attributes.put("pageIndex",Integer.toString(pageIndex));
                attributes.put("pageSize", Integer.toString(pageSize));
                attributes.put("lastEditedTime", sdf.format(lastUpdateTime));
                Map resultMap = JSONObject.fromObject(HttpUtil.httpPostWithJson("http://118.178.131.147:6002/personDetails/organizationDetail", attributes));
                JSONArray backBodyJson = JSONArray.fromObject(resultMap.get("doctorDetail"));
                if(backBodyJson==null || backBodyJson.size()<=0){
                    logger.error("组织机构数据dump结束，时间是"+currentTime);
                    break;
                }

                //把返回数据映射为我们自己的OrganizStructureDO对象,并将OrganizStructureDO同步到本地库
                for(int i=0;i<backBodyJson.size();i++){
                    JSONObject job = backBodyJson.getJSONObject(i);
                    OrganizStructureDO organizStructureDO = new OrganizStructureDO();
                    organizStructureDO.setOrganizStructureCode(job.get("orgCode").toString());
                    organizStructureDO.setDepartCode(job.get("deptCode").toString());
                    organizStructureDO.setDepartName(job.get("deptName").toString());
                    organizStructureDO.setWardCode(job.get("wardCode").toString());
                    organizStructureDO.setWardName(job.get("wardName").toString());
                    organizStructureDO.setValidFlag(job.get("cancelFlag").toString());
                    organizStructureDO.setCreateId(0L);
                    organizStructureDO.setCreateTime(currentTime);
                    organizStructureDO.setUpdateId(0L);
                    organizStructureDO.setUpdateTime(currentTime);
                    organizStructureDAO.updateOrInsertOrganizStructure(organizStructureDO);
                }
            }catch(Exception e){
                logger.error("组织机构数据dump的时候报错"+e);
            }
            pageIndex = pageIndex+1;
        }
    }

    @Override
    public List<OrganizStructureDO> selectDataBylastUpdateTime(Date lastUpdateTime) {
        OrganizStructureDO organizStructureDO = new OrganizStructureDO();
        organizStructureDO.setUpdateTime(lastUpdateTime);
        return organizStructureDAO.selectDataBylastUpdateTime(organizStructureDO);
    }

}
