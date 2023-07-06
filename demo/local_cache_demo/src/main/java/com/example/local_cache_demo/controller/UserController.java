package com.example.local_cache_demo.controller;

import com.example.local_cache_demo.entity.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import static com.example.local_cache_demo.util.GenerateUtil.generateMemoryString;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/21
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("test")
    public void test() {
        System.out.println("get第一次获取，不走缓存");
    }



    @GetMapping("get")
    @Cacheable(cacheNames = "user", key = "#id")
    public User getById(Integer id) {
        System.out.println("get第一次获取，不走缓存");
        User user = new User();
        user.setId(id);
        user.setAge(18);
        user.setName("benjamin_"+id);
        user.setSex(true);
        return user;
    }

    @PostMapping("update")
    @CachePut(cacheNames = "user", key = "#search.id")
    public User update(@RequestBody User search) {
        System.out.println("update更新缓存");
        User user = new User();
        Integer id = search.getId();
        user.setId(id);
        user.setAge(search.getAge() != null ? search.getAge()+1 : 0);
        user.setName("update_benjamin_"+id);
        user.setSex(true);
        return user;
    }

    @GetMapping("build")
    @Cacheable(cacheNames = "user", key = "#id")
    public User build(Integer id) {
        System.out.println("get第一次获取，不走缓存");
        User user = new User();
        user.setId(id);
        user.setAge(18);
        // 生成指定大小的字符串
        user.setName(generateMemoryString(id));
        user.setSex(true);
        return user;
    }

}
