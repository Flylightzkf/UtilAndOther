package com.example.designmodel.model.m06_prototype;

import lombok.Data;

/**
 * @author benjamin_5
 * @Description 原型模式，本意就是克隆：申明Cloneable接口，实现clone方法即可
 * @date 2023/4/19
 */
@Data
public class Resume implements Cloneable{

    private String name;
    private String sex;
    private String age;

    @Override
    public Resume clone(){
        Resume resume = null;
        try {
            resume = (Resume) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return resume;
    }

}
