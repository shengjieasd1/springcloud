package com.sj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by sj on 2020/9/28 15:32
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication_9527 {
    
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_9527.class,args);
    }
}
