package com.example.local_cache_demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/21
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private Boolean sex;
}
