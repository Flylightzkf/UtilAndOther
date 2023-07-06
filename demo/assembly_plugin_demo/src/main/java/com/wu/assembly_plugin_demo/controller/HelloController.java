package com.wu.assembly_plugin_demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author benjamin_5
 * @Description
 * @date 2022/8/27
 */
@RestController
public class HelloController {

    @Value("${application.version}")
    private String version;

    @GetMapping("/hello")
    public String hello(){
        return "hello~~";
    }

    @GetMapping("/hello2")
    public String hello2(){
        return "hello~~"+version;
    }

}
