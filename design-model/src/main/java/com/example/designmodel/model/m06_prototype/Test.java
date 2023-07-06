package com.example.designmodel.model.m06_prototype;

import com.alibaba.fastjson.JSON;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/19
 */
public class Test {

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.setName("benjamin");
        r1.setAge("18");
        r1.setSex("男");
        Resume r2 = r1.clone();
        System.out.println(JSON.toJSONString(r2));

    }
}
