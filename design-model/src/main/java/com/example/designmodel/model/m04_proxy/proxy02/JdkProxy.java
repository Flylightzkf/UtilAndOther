package com.example.designmodel.model.m04_proxy.proxy02;

import java.lang.reflect.Proxy;

/**
 * @author benjamin_5
 * @Description JDK动态代理
 * @date 2023/4/16
 */
public class JdkProxy {

    // 真实调用对象
    private Object target;

    public JdkProxy(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
            System.out.println("jdk动态代理：吃饭前来接你");
            Object result = method.invoke(target, args);
            System.out.println("jdk动态代理：吃饭后送你回家");
            return result;
        });
    }
}
