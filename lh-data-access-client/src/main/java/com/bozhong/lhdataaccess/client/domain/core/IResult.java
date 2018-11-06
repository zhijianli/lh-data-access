package com.bozhong.lhdataaccess.client.domain.core;

import java.io.Serializable;

/**
 * Created by renyueliang on 17/3/25.
 */
public interface IResult extends Serializable {

    boolean isSuccess();

    void setSuccess(boolean success);

    String getErrCode();

    void setErrCode(String errCode);

    String getErrMsg();

}
