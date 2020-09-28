package com.sj.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sj on 2020/9/25 15:16
 */
@Configuration
public class SjRule {
    
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
    
}
