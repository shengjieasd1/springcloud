package com.sj.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by sj on 2020/9/25 14:06
 */
@Configuration
public class ConfigBean {
    //配置负载均衡实现RestTemple
    //IRule
    //RoundRobinRule 轮询
    //RandomRule
    //AvailobilittyFilteringRule : 会先过滤掉 跳闸 访问故障的服务 对剩下的进行轮询
    //RetryRule : 会先按照轮询获取服务，如果服务失败，则会在指定的时间内进行，
    @Bean
    @LoadBalanced//Ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    
 
    
}
