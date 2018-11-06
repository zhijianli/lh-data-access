package com.bozhong.lhdataaccess.client.rpc;


import com.bozhong.lhdataaccess.client.domain.core.Result;
import com.bozhong.lhdataaccess.client.domain.dto.BaseReqDTO;
import com.bozhong.lhdataaccess.client.domain.dto.BaseRespDTO;

/**
 * @author bin
 * @create 2018-06-21 下午7:28
 **/
public class TestClient implements TestRPC {

    private TestRPC testRPC;

    public void setTestRPC(TestRPC testRPC) {
        this.testRPC = testRPC;
    }


    @Override
    public Result<BaseRespDTO> test(BaseReqDTO reqDTO) {
        reqDTO.validation();
        return testRPC.test(reqDTO);
    }
}