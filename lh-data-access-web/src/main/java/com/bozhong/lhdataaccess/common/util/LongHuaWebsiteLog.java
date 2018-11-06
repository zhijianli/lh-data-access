package com.bozhong.lhdataaccess.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息通道日志类
 *
 * @author bin
 * @create 2018-04-28 上午10:51
 **/
public class LongHuaWebsiteLog {

    /**
     * 任务日志
     */
    public static Logger WORKER_LOG=LoggerFactory.getLogger("WORKER_LOG");

    /**
     * 安全信息日志
     */
    public static Logger SECURITY_LOG=LoggerFactory.getLogger("SECURITY_LOG");

    /**
     * 查询process日志
     */
    public static Logger PROCESS_QUERY_LOG=LoggerFactory.getLogger("PROCESS_QUERY_LOG");

    /**
     * 编辑process日志
     */
    public static Logger PROCESS_WRITE_LOG=LoggerFactory.getLogger("PROCESS_WRITE_LOG");

}