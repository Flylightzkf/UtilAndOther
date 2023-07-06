package com.example.powerjobdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PowerjobDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PowerjobDemoApplication.class, args);
    }

}
