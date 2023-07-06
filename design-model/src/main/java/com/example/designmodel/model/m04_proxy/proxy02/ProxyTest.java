package com.example.designmodel.model.m04_proxy.proxy02;

import com.example.designmodel.model.m04_proxy.proxy01.UserService;
import com.example.designmodel.model.m04_proxy.proxy01.UserServiceImpl;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/16
 */
public class ProxyTest {

    public static void main(String[] args) {
        // 若是bean，则直接注入即可
        UserService userService = new UserServiceImpl();
        UserService proxyInstance =(UserService) new JdkProxy(userService).getProxyInstance();
        proxyInstance.eatFood();
    }
}
