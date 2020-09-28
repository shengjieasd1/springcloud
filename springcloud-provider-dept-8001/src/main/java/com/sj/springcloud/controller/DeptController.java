package com.sj.springcloud.controller;

import com.sj.springcloud.pojo.Dept;
import com.sj.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class DeptController {
    
    //获取一些配置信息，得到具体的微服务
    @Resource
    private DiscoveryClient client;
    
    @Resource
    private DeptService deptService;
    
    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }
    
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return deptService.queryById(id);
    }
    
    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }
    
    //注册进来的微服务 获取一些消息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务清单
        List<String> services = client.getServices();
        System.out.println("serivices:"+services);
    
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
    
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()
            );
        }
        
        return this.client;
    
    }
    
}
