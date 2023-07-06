package com.example.local_cache_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LocalCacheDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocalCacheDemoApplication.class, args);
    }

}
