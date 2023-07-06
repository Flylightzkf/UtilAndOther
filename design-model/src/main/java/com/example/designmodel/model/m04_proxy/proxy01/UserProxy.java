package com.example.designmodel.model.m04_proxy.proxy01;

/**
 * @author benjamin_5
 * @Description 静态代理
 * @date 2023/4/16
 */
public class UserProxy {

    // 真实调用对象
    private UserService userService;

    public UserProxy(UserService userService) {
        this.userService = userService;
    }

    public void eatFood() {
        System.out.println("静态代理：吃饭前来接你");
        userService.eatFood();
        System.out.println("静态代理：吃饭后送你回家");
    }

}
