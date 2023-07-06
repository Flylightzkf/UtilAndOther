package com.example.local_cache_demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/show")
public class showServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        if(httpSession == null){
            System.out.println("未登录，请重新登录");
            resp.sendRedirect("login.html");
            return;
        }

        Object obj = req.getServletContext().getAttribute("online");
        if (obj == null){
            System.out.println("当前用户此前登录过");
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().write("<h4><u>当前用户此前登录过，请清除浏览器缓存后再行登录</u></h4>");
        }
        int count = (int)obj;
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("在线人数为：" + count);
    }
}
