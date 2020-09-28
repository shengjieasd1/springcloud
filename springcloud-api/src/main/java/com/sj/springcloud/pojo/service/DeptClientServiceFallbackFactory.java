package com.sj.springcloud.pojo.service;

import com.sj.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by sj on 2020/9/28 11:29
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept queryById(Long id) {
                return new Dept()
                        .setDeptid(id)
                        .setDname("id=>"+id+"没用对应的信息")
                        .setDb_source("没有数据");
            }
    
            @Override
            public List<Dept> queryAll() {
                return null;
            }
    
            @Override
            public Boolean addDept(Dept dept) {
                return null;
            }
        };
    }
}
