package com.example.local_cache_demo.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/onlineUsers")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        if(!userName.equals("zhangsan")){
            resp.sendRedirect("login.html");
        }

        HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute("userName", userName);
        resp.sendRedirect("show");
    }
}
