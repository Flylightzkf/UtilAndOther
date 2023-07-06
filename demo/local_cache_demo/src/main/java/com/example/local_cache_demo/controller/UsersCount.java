package com.example.local_cache_demo.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UsersCount implements HttpSessionListener{
    @Override
    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("会话创建");
        // 1.获取ServletContext对象，在整个容器中只有一份
        ServletContext servletContext = event.getSession().getServletContext();
        System.out.println(event.getSession().getId());

        // 2.在线人数
        Object obj = servletContext.getAttribute("online");
        // 3.判断当前用户是否是第一个在线的
        if(obj == null){
            servletContext.setAttribute("online", 1);
        }else{
            int i = (int)obj;             // 若其不是第一个上线的，就 + 1
            servletContext.setAttribute("online", i + 1);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("会话销毁");
        event.getSession().invalidate();
        // 1.获取ServletContext对象，在整个容器中只有一份
        ServletContext servletContext = event.getSession().getServletContext();
        // 2.在线人数
        Object obj = servletContext.getAttribute("online");

        if(obj == null){
            servletContext.setAttribute("online", 0);
        }else{
            int i = (int)obj;             // 若其不是第一个上线的，就 + 1
            servletContext.setAttribute("online", i - 1);
        }
    }
}
