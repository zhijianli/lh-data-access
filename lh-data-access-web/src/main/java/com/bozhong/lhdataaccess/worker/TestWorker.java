package com.bozhong.lhdataaccess.worker;

import org.springframework.stereotype.Component;

/**
 * 消息发送任务worker
 *
 * @author bin
 * @create 2018-05-08 下午12:41
 **/
@Component
public class TestWorker {
//    private final int TASK_LENGTH = 6;
//
//    private Executor pool = Executors.newFixedThreadPool(TASK_LENGTH);
//    @Autowired
//    private RedisQueueService redisQueueService;
//    @Autowired
//    @Qualifier("messageSendTaskDispatcherService")
//    private MessageSendTaskDispatcherService messageSendTaskDispatcherService;
//    @PostConstruct
//    public void init(){
//        for(int i = 0; i < TASK_LENGTH; i++){
//            pool.execute(new MessageSendTaskThread(redisQueueService,messageSendTaskDispatcherService));
//        }
//
//    }

}

class TestThread implements Runnable{
    @Override
    public void run() {

    }
//    private static final Logger logger = MessageChannelLog.WORKER_LOG;
//    private RedisQueueService redisQueueService;
//
//    private MessageSendTaskDispatcherService messageSendTaskDispatcherService;
//
//    public MessageSendTaskThread(RedisQueueService redisQueueService,
//                                 MessageSendTaskDispatcherService messageSendTaskDispatcherService) {
//        this.redisQueueService = redisQueueService;
//        this.messageSendTaskDispatcherService= messageSendTaskDispatcherService;
//    }
//
//    @Override
//    public void run() {
//        while(true){
//            List<String> result=null;
//            try{
//                result = redisQueueService.messageSendTaskLpop();
//                if(result == null || result.isEmpty())
//                    continue;
//                if(result.size() < 2)
//                    continue;
//                String value = result.get(1);
//                if(StringUtils.isEmpty(value))
//                    continue;
//                messageSendTaskDispatcherService.dispatcher(JSON.parseObject(value,MessageSendTaskQueueVO.class));
//            }catch (Exception e){
//                String uuid=StringUtils.UUID();
//                logger.error("[MessageSendTaskWorker] ["+uuid+"]error value :"+ JSON.toJSONString(result));
//                logger.error("[MessageSendTaskWorker] ["+uuid+"]error",e);
//            }
//        }
//    }


}