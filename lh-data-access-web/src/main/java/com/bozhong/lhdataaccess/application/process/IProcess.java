package com.bozhong.lhdataaccess.application.process;


import com.bozhong.lhdataaccess.application.Context;

/**
 * @author bin
 * @create 2018-04-28 下午5:50
 **/
public interface IProcess<P,M> {


    public void start(Context<P, M> context);


    void onStarted(Context<P, M> context);


    void process(Context<P, M> context);


    void onSuccess(Context<P, M> context);


    void onError(Context<P, M> context, Throwable e);


    void onEnd(Context<P, M> context);
}
