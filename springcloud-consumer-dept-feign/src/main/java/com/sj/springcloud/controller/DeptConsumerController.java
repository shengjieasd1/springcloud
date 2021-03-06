package com.sj.springcloud.controller;

import com.sj.springcloud.pojo.Dept;
import com.sj.springcloud.pojo.service.DeptClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

    //RestTemplate
    
    @Resource
    private RestTemplate restTemplate;
    
    @Resource
    private DeptClientService deptClientService = null;
    
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
   // private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";
    
    @RequestMapping("/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        //return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get"+id,Dept.class);
        return deptClientService.queryById(id);
    }
    
    @RequestMapping("/add")
    public boolean add(Dept dept){
        //return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
        return this.deptClientService.addDept(dept);
    }
    
    @RequestMapping("/list")
    public List<Dept> list(){
        return deptClientService.queryAll();
        //return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
    
}
