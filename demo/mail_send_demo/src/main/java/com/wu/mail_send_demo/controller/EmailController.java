package com.wu.mail_send_demo.controller;

import com.wu.mail_send_demo.util.EmailCommonsUtil;
import com.wu.mail_send_demo.util.EmailSpringUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.mail.EmailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author benjamin_5
 * @Description
 * @date 2022/10/5
 */
@RestController
@AllArgsConstructor
public class EmailController {

    private final EmailCommonsUtil emailCommonsUtil;
    private final EmailSpringUtil emailSpringUtil;

    @GetMapping("sendCommonEmail")
    public void sendCommonEmail(){
        String subject = "这是一个测试标题";
        String html = "<h1>统计数据如下所示：</h1>" +
                "<table border=\"1\">\n" +
                "  <tr>\n" +
                "    <th>月度销售额</th>\n" +
                "    <th>年度销售额</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>10000</td>\n" +
                "    <td>2000000</td>\n" +
                "  </tr>\n" +
                "</table>";
        String[] toMail = new String[]{"wuhanxue5@sina.com"};
        String[] ccMail = new String[]{"wuhanxue5@163.com"};
        File file = new File("/Users/wuhanxue/Downloads/供应商接口参数.xlsx");
        try {
           emailCommonsUtil.sendEmail(subject,html,true,toMail,ccMail,null,new File[]{file});
        } catch (EmailException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("sendSpringEmail")
    public void sendSpringEmail(){
        String subject = "这是一个测试标题";
        String html = "<h1>统计数据如下所示：</h1>" +
                "<table border=\"1\">\n" +
                "  <tr>\n" +
                "    <th>月度销售额</th>\n" +
                "    <th>年度销售额</th>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td>10000</td>\n" +
                "    <td>2000000</td>\n" +
                "  </tr>\n" +
                "</table>";
        String toMail = "wuhanxue5@sina.com";
        String ccMail = "wuhanxue5@163.com";
        String fileName = "/Users/wuhanxue/Downloads/供应商接口参数.xlsx";
        try {
            emailSpringUtil.sendEmail(subject,html,true,"邮件提醒系统",toMail,ccMail,null, Arrays.asList(fileName));
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
