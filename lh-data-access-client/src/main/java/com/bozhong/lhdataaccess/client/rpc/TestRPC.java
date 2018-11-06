package com.bozhong.lhdataaccess.client.rpc;


import com.bozhong.lhdataaccess.client.domain.core.Result;
import com.bozhong.lhdataaccess.client.domain.dto.BaseReqDTO;
import com.bozhong.lhdataaccess.client.domain.dto.BaseRespDTO;


/**
 * rpc模板
 *
 * @author bin
 * @create 2018-06-21 下午7:27
 **/
public interface TestRPC {

    Result<BaseRespDTO> test(BaseReqDTO reqDTO);

}