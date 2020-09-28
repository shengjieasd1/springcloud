package com.sj.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sj.springcloud.pojo.Dept;
import com.sj.springcloud.service.DeptService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController {
    
    @Resource
    private DeptService deptService;
    
    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hyGet")
    public Dept get(@PathVariable("id") Long id) {
        Dept dept = deptService.queryById(id);
        if(dept == null){
            throw new RuntimeException("id="+id+"不存在");
        }
        
        return dept;
    }
    
    
    public Dept hyGet(@PathVariable("id") Long id) {
        return new Dept()
                .setDeptid(id)
                .setDname("id="+id+"不存在")
                .setDb_source("no this database in mysql");
    }
}
