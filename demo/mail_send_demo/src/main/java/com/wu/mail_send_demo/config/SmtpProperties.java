package com.wu.mail_send_demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author benjamin_5
 * @Description
 * @date 2022/10/5
 */
@Data
@Component
@ConfigurationProperties(value = "email.smtp")
public class SmtpProperties {

    /**
     * smtp服务地址
     */
    private String host;

    /**
     * 发件人邮箱
     */
    private String email;

    /**
     * 发件人昵称
     */
    private String name;

    /**
     * 邮箱授权码
     */
    private String password;

    /**
     * 邮箱服务端口
     */
    private Integer port=25;
}
