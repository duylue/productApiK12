package com.productk12Api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class BatchJob {
    @Scheduled(fixedDelay = 3000)
    public void test1(){
        System.out.println(" my job");
    }

    @Scheduled(cron = "0 15 10 15 * ?")
    public void test2(){
        System.out.println(" my job 22222");
    }
}
