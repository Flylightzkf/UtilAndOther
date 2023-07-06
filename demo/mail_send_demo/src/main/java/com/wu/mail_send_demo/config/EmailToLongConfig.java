package com.wu.mail_send_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author benjamin_5
 * @Description
 * @date 2022/10/5
 */
@Configuration
public class EmailToLongConfig {

    @PostConstruct
    private void init(){
        // 解决邮件附件名称太长会自动截取，导致附件变成.bin格式问题
        System.setProperty("mail.mime.splitlongparameters","false");
    }

}
