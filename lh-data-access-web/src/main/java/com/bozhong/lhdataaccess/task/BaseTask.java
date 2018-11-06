package com.bozhong.lhdataaccess.task;

import com.bozhong.myredis.MyRedis;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 定时任务集中调度基础类
 * 该类主要针对分布式定时任务同时进行触发,而只需要运行一台所设计的
 * 需要运用该类,定时标签[@Scheduled] 必须加在 方法[dispatching]上面
 *
 * @author bin
 * @create 2018-02-02 上午9:45
 **/
public abstract class BaseTask  {
    @Autowired
    private MyRedis myRedisClusterForHessian;

    /**
     * 对运行中超过5分钟的任务进行清除,让下个定时任务可以再次进入
     */
    private final static long CLEAR_TIME=1000*60*5;

    /**
     * 集中调度机制
     */
    public void dispatching(){
        String name=this.getClass().getName();
        //集群定时任务 调度
        long result= myRedisClusterForHessian.getJedisCluster().setnx(name,String.valueOf(System.currentTimeMillis()));
        if (result==0){
            long time=Long.valueOf(myRedisClusterForHessian.getJedisCluster().get(name));
            if (System.currentTimeMillis()-time>CLEAR_TIME)//防止没有执行到下面这行 expire方法,对redis中的值进行手工清理
                myRedisClusterForHessian.getJedisCluster().del(name);
            return;
        }
//      设置调度任务过期时间
        myRedisClusterForHessian.getJedisCluster().expire(name,9);

        run();
    }

    public abstract void run();

}