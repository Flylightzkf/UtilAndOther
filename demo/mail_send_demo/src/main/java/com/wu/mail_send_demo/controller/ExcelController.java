package com.wu.mail_send_demo.controller;

import com.wu.mail_send_demo.entity.CustomerData;
import com.wu.mail_send_demo.util.EmailSpringUtil;
import com.wu.mail_send_demo.util.ExcelUtil;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author benjamin_5
 * @Description
 * @date 2022/10/5
 */
@RestController
@RequestMapping("excel")
@AllArgsConstructor
public class ExcelController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final EmailSpringUtil emailSpringUtil;

    @GetMapping("generateExcelAndSend")
    public void generateExcelAndSend(){
        long start = System.currentTimeMillis();
        List<CustomerData> dataList = new ArrayList<>();
        // 构造假数据
        for (int i = 0; i < 100; i++) {
            CustomerData data = new CustomerData();
            data.setName("客户"+i);
            data.setAddress("贵州省贵阳市观山湖区101号");
            data.setPhone("13889999999");
            data.setAmount(BigDecimal.valueOf(Math.random()*10000));
            data.setCreateDate(new Date());
            dataList.add(data);
        }
        // 获取资源文件存放路径，用于临时存放生成的excel文件
        String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource("")).getPath();
        // 文件名：采用UUID，防止多线程同时生成导致的文件重名
        String fileName = String.format("%s客户统计数据-%s.xlsx",path,UUID.randomUUID());
        try {
            // 生成excel文件
            File excel = ExcelUtil.generateExcel(fileName, dataList, CustomerData.class);
            // 发送邮件
            String content = "客户统计数据如附件所示";
            String toMail = "wuhanxue5@sina.com";
            String ccMail = "wuhanxue5@163.com";
            emailSpringUtil.sendEmail("客户统计数据",content,false,"邮件提醒系统",
                    toMail,ccMail,null, new File[]{excel});
            // 邮件发送完成后删除临时生成的excel文件
            excel.delete();
        } catch (IOException e) {
            logger.error(String.format("生成excel失败，原因：%s",e));
            e.printStackTrace();
        } catch (MessagingException e) {
            logger.error(String.format("邮件发送失败，原因：%s",e));
            e.printStackTrace();
        }finally {
            long end = System.currentTimeMillis();
            System.out.println("耗时：" + (end - start));
        }
    }

    @GetMapping("generateExcelAndSend2")
    public void generateExcelAndSend2() throws IOException {
        long start = System.currentTimeMillis();
        List<CustomerData> dataList = new ArrayList<>();
        // 构造假数据
        for (int i = 0; i < 100; i++) {
            CustomerData data = new CustomerData();
            data.setName("客户"+i);
            data.setAddress("贵州省贵阳市观山湖区101号");
            data.setPhone("13889999999");
            data.setAmount(BigDecimal.valueOf(Math.random()*10000));
            data.setCreateDate(new Date());
            dataList.add(data);
        }
        // 获取资源文件存放路径，用于临时存放生成的excel文件
        String path = Objects.requireNonNull(this.getClass().getClassLoader().getResource("")).getPath();
        // 文件名：采用UUID，防止多线程同时生成导致的文件重名
        String fileName = String.format("%s客户统计数据-%s.xlsx",path,UUID.randomUUID());
        ByteArrayOutputStream out = null;
        try {
            // 生成excel文件
            out = ExcelUtil.generateExcel(dataList, CustomerData.class);
            // 发送邮件
            String content = "客户统计数据如附件所示";
            String toMail = "wuhanxue5@sina.com";
            String ccMail = "wuhanxue5@163.com";
            emailSpringUtil.sendEmail("客户统计数据",content,false,"邮件提醒系统",
                    toMail,ccMail,null, fileName, new ByteArrayResource(out.toByteArray()));
        } catch (IOException e) {
            logger.error(String.format("生成excel失败，原因：%s",e));
            e.printStackTrace();
        } catch (MessagingException e) {
            logger.error(String.format("邮件发送失败，原因：%s",e));
            e.printStackTrace();
        }finally {
            if(out != null){
                out.close();
            }
            long end = System.currentTimeMillis();
            System.out.println("耗时：" + (end - start));
        }
    }
}
