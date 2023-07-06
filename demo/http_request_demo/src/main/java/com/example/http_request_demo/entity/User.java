package com.example.http_request_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/1/30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private Date birthday;
}
