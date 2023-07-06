package com.example.http_request_demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.http_request_demo.entity.User;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author benjamin_5
 * @Description 测试用接口
 * @date 2023/1/30
 */
@RestController
@RequestMapping("api")
public class RequestDataController {


    @RequestMapping("list/user")
    public List<User> listUser(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            User user = new User((long)i,"name"+i, 20, new Date());
            list.add(user);
        }
        return list;
    }

    @RequestMapping("list/user/json")
    public JSONObject listUserJson(){
        List<User> list = listUser();
        JSONObject result = new JSONObject();
        result.put("data",list);
        result.put("total", list.size());
        result.put("success", true);
        return result;
    }

    @PostMapping("get/user")
    public JSONObject getUserById(@RequestParam("id") Long id){
        User user = new User(id,"name"+id, 20, new Date());
        JSONObject result = new JSONObject();
        result.put("data",user);
        result.put("success", true);
        return result;
    }

    @PostMapping("get/user/json")
    public JSONObject getUserJson(@RequestBody User user){
        user.setName(user.getName()+" new");
        JSONObject result = new JSONObject();
        result.put("data",user);
        result.put("success", true);
        return result;
    }

    @PostMapping("get/header")
    public JSONObject getUserJson(HttpServletRequest request){
        String token = request.getHeader("token");
        JSONObject result = new JSONObject();
        result.put("data",token);
        result.put("success", true);
        return result;
    }

}
