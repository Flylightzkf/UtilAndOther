package com.example.cpu_oom_demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/15
 */
@RestController
@RequestMapping("cpu")
public class CpuController {

    String pattern = " ^([\\u4e00-\\u9fa5]+)((·[\\u4e00-\\u9fa5]+)+|([\\u4e00-\\u9fa5]+))$";
    String defaultName = "张三·无论其是看都看呐阿斯顿啊·萨肯萨肯打开你发都看啊看你发个卡看那可能发看那个可能看呐";

    /**
     * 构造cpu爆满
     *
     * @param time
     */
    @GetMapping("build")
    public void cpuBuild(Integer time) throws InterruptedException {
        System.out.println("执行校验");
        if(time == null){
            time = 20;
        }
        String result = null;
        while (true){
            if(time > 0){
                Thread.sleep(time);
            }
            result = defaultName.matches(pattern) ? "姓名合法" : "姓名不合法";
        }
    }



    @GetMapping("test")
    public void test() {
        System.out.println("执行校验");
        jiazai();
        testStream();
        System.out.println("完成");
    }

    public String jiazai(){
        System.out.println("1134");
        int i=1;
        System.out.println("1134");
        int t=2;
        System.out.println("1134");
        return "";
    }



    public void testStream(){
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<String> stringlist=list.stream()
                .filter(Objects::nonNull)
                .filter(i ->i%2==0)
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(stringlist);
    }
}
