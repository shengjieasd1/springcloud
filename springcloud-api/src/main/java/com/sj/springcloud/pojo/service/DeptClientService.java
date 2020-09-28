package com.sj.springcloud.pojo.service;

import com.sj.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by sj on 2020/9/27 9:28
 */
@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    
    @GetMapping("/dept/get/{id}")
    public Dept queryById(@PathVariable("id") Long id);
    
    @GetMapping("/dept/list")
    public List<Dept> queryAll();
    
    @GetMapping("/dept/add")
    public Boolean addDept(Dept dept);
}
