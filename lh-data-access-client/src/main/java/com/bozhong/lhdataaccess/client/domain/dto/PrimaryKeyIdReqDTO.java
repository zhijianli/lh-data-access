package com.bozhong.lhdataaccess.client.domain.dto;


/**
 * @author gongwq
 * @create 2017-10-17 16:01
 */
public class PrimaryKeyIdReqDTO extends BaseReqDTO{
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public void validation() {
    }

    @Override
    public String controllerValidation() {
        if(id == null || id == 0){
            return "id不能为空";
        }
        return null;
    }
}
