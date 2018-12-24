package com.wk.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoTask {
   // @Scheduled(cron = "${task.timer.cron}")
    public  void scheDemo(){
        System.out.println("定时任务处理器");
    }


}
