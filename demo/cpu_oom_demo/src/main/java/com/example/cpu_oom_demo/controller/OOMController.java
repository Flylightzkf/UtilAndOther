package com.example.cpu_oom_demo.controller;

import com.example.cpu_oom_demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/3/18
 */
@RestController
@RequestMapping("oom")
public class OOMController {

    @GetMapping("test")
    public String test(){
        return "test ready !!!";
    }

    /**
     * 构造死循环，产生OOM问题
     * @param time
     */
    @GetMapping("build")
    public void oomBuild(int time){
        List<User> list = new ArrayList<>();
        // 死循环构造OOM
        while (true){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new User());
        }
    }


}