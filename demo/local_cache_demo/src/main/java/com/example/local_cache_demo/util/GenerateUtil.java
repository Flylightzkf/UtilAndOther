package com.example.local_cache_demo.util;

import java.util.Random;

/**
 * @author benjamin_5
 * @Description
 * @date 2023/4/22
 */
public class GenerateUtil {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Random random = new Random();

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }

        return sb.toString();
    }

    public static String generateMemoryString(int sizeInMB) {
        int numOfChars = sizeInMB * 1024 * 1024 / 2; // 计算所需字符数

        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numOfChars; i++) {
            sb.append((char) ('a' + random.nextInt(26))); // 随机生成小写字母并拼接到字符串中
        }

        return sb.toString();
    }
}
