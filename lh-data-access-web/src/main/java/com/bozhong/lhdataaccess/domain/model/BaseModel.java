package com.bozhong.lhdataaccess.domain.model;

/**
 * Created by ACA on 2017/6/19.
 */
public class BaseModel<T> {

    private T doObject;

    public BaseModel(T doObject) {
        this.doObject = doObject;
    }

    public T getDO() {
        return doObject;
    }

    public void setDO(T doObject) {
        this.doObject = doObject;
    }

    public boolean isValid() {
        return this.getDO() != null;
    }
}
