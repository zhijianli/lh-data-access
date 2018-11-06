package com.bozhong.lhdataaccess.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author bin
 * @create 2018-05-15 下午3:24
 **/
@Component
public class TestTask extends BaseTask {

//    @Autowired
//    private TaskInfoAwakeService taskInfoAwakeService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void dispatching() {
        super.dispatching();
    }

    @Override
    public void run() {

//        taskInfoAwakeService.taskAwake();
    }
}