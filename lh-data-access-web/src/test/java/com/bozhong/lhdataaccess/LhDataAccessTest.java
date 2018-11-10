package com.bozhong.lhdataaccess;

//import com.bozhong.lhdataaccess.client.domain.dto.request.AdverInfoAddReqDTO;
//import com.bozhong.lhdataaccess.client.domain.dto.request.AdverInfoUpdateReqDTO;
//import com.bozhong.lhdataaccess.client.domain.dto.request.AdverInfoUpdateStatusReqDTO;
//import com.bozhong.lhdataaccess.client.domain.query.adverinfo.AdverInfoQuery;
//import com.zhicall.core.mybatis.page.Page;
import com.bozhong.lhdataaccess.observation.DumpDataPubisher;
import com.bozhong.lhdataaccess.observation.DumpDataEvent;
import com.bozhong.lhdataaccess.infrastructure.service.OrganizStructureService;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: chenq
 * @Date: 2018/11/1 12:22
 * @Description:
 */
public class LhDataAccessTest extends BaseTest {

    private OrganizStructureService organizStructureService;
    private DumpDataPubisher dumpDataPubisher;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        organizStructureService = (OrganizStructureService) applicationContext.getBean("organizStructureService");
        dumpDataPubisher = (DumpDataPubisher) applicationContext.getBean("dumpDataPubisher");
//        adverInfoWriteService = (AdverInfoWriteService) applicationContext.getBean("adverInfoWriteService");
    }

    @Test
    public void dumpData(){
        try {
             Date lastUpdateTime=new SimpleDateFormat("yyyy-MM-dd").parse("2018-10-03");
             dumpDataPubisher.setLastEditedTime(lastUpdateTime);
             dumpDataPubisher.publishEvent(new DumpDataEvent(dumpDataPubisher));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    @Test
//    public void dumpOrganizStructureData(){
//        try {
//            Date lastUpdateTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-07-01 00:00:00");
//            organizStructureService.dumpOrganizStructureData(lastUpdateTime);
////             dumpData.dumpData(lastUpdateTime);
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void pageQuery(){
//        AdverInfoQuery adverInfoQuery = new AdverInfoQuery();
//        adverInfoQuery.setPageNum(1);
//        adverInfoQuery.setPageSize(20);
//        Page<AdverInfoRespDTO> page = adverInfoReadService.queryAdverInfoByPage(adverInfoQuery);
//        printJson(page.getResult());
//    }
//
//    @Test
//    public void add(){
//        AdverInfoAddReqDTO adverInfoAddReqDTO = new AdverInfoAddReqDTO();
//        adverInfoAddReqDTO.setTitle("标题3");
//        adverInfoAddReqDTO.setContentType(1);
//        adverInfoAddReqDTO.setContent("www.baidu.com");
//        adverInfoAddReqDTO.setImageId("测试3");
//        adverInfoAddReqDTO.setCreateBy("chenqi");
//        adverInfoWriteService.addAdverInfo(adverInfoAddReqDTO);
//
//    }
//    @Test
//    public void updateInfo(){
//        AdverInfoUpdateReqDTO adverInfoUpdateReqDTO = new AdverInfoUpdateReqDTO();
//        adverInfoUpdateReqDTO.setId(1L);
//        adverInfoUpdateReqDTO.setTitle("标题2");
//        adverInfoUpdateReqDTO.setContentType(1);
//        adverInfoUpdateReqDTO.setContent("www.baidu.com");
//        adverInfoUpdateReqDTO.setImageId("测试2");
//        adverInfoUpdateReqDTO.setUpdateBy("chenqi");
//        adverInfoWriteService.updateAdverInfo(adverInfoUpdateReqDTO);
//
//    }
//
//    @Test
//    public void updateInfoStatus(){
//        AdverInfoUpdateStatusReqDTO adverInfoUpdateStatusReqDTO = new AdverInfoUpdateStatusReqDTO();
//        adverInfoUpdateStatusReqDTO.setId(1L);
//        adverInfoUpdateStatusReqDTO.setType(2);
//        adverInfoUpdateStatusReqDTO.setStatus(0);
//        adverInfoUpdateStatusReqDTO.setUpdateBy("chenqi");
//        adverInfoWriteService.udpateAdverInfoStatus(adverInfoUpdateStatusReqDTO);
//
//    }
}
