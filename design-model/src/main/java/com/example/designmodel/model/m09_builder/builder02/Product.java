package com.example.designmodel.model.m09_builder.builder02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author benjamin_5
 * @Description 产品
 * @date 2023/4/24
 */
public class Product {

    List<String> parts = new ArrayList<>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.println("产品 创建 ----");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
