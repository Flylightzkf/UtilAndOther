package com.example.designmodel.model.m04_proxy.proxy01;

import org.springframework.stereotype.Service;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/16
 */
public class UserServiceImpl implements UserService {

    @Override
    public void eatFood() {
        System.out.println("吃饭");
    }

}
