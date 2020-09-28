package com.sj.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Dept implements Serializable { //Dept实体类

    private Long deptid;
    
    public Dept(String dname) {
        this.dname = dname;
    }
    
    private String dname;

    private String db_source;
    
    
}
