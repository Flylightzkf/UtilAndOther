package com.password.encrypt;

/**
 * Created by jsguan on 2021/8/4.
 */
public class TestRSA {
    public static void main(String[] args) throws Exception {
        System.out.println(SHA1.verify("KhhKceDj031U+HM6jbYj2wEyq2A=", "kongtong0909"));
        System.out.println(SHA1.verify("mXY0DMy9Cny7oU/RgOZ1mrqwi94=", "MMM642937mmm"));
        System.out.println(SHA1.verify("t79Vjn34dOCsQidhXW1TMVT56u8=", "256016"));

        String password = "admin123";

        String encrypt = MD5.encrypt(password);
        System.out.println(encrypt);
    }
}
