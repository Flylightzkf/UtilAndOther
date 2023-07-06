package com.wu.mail_send_demo.util;

import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.List;

/**
 * @author benjamin_5
 * @Description spring-boot-starter-mail邮件工具类
 * @date 2022/10/5
 */
@Component
@AllArgsConstructor
public class EmailSpringUtil {

    private final JavaMailSender javaMailSender;
    private final MailProperties mailProperties;

    /**
     * 邮件发送
     *
     * @param subject              邮件主题
     * @param content              邮件内容
     * @param contentIsHtml        内容是否为html格式
     * @param fromMailPersonalName 发件人昵称
     * @param toMail               收件人邮箱
     * @param ccMail               抄送人邮箱
     * @param bccMail              秘密抄送人邮箱
     * @param fileNames            文件名（本地路径）
     * @throws GeneralSecurityException
     * @throws UnsupportedEncodingException
     * @throws MessagingException
     */
    public void sendEmail(String subject, String content, boolean contentIsHtml, String fromMailPersonalName,
                          String toMail, String ccMail, String bccMail, List<String> fileNames) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(mailProperties.getUsername(), fromMailPersonalName);
        helper.setTo(toMail);
        if (!ObjectUtils.isEmpty(ccMail)) {
            helper.setCc(ccMail);
        }
        if (!ObjectUtils.isEmpty(bccMail)) {
            helper.setBcc(bccMail);
        }
        helper.setSubject(subject);
        helper.setText(content, contentIsHtml);
        // 设置附件（注意这里的fileName必须是服务器本地文件名，不能是远程文件链接）
        if (!CollectionUtils.isEmpty(fileNames)) {
            for (String fileName : fileNames) {
                FileDataSource fileDataSource = new FileDataSource(fileName);
                helper.addAttachment(fileDataSource.getName(), fileDataSource);
            }
        }
        javaMailSender.send(message);
    }

    public void sendEmail(String subject, String content, boolean contentIsHtml, String fromMailPersonalName,
                          String toMail, String ccMail, String bccMail, File[] files) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(mailProperties.getUsername(), fromMailPersonalName);
        helper.setTo(toMail);
        if (!ObjectUtils.isEmpty(ccMail)) {
            helper.setCc(ccMail);
        }
        if (!ObjectUtils.isEmpty(bccMail)) {
            helper.setBcc(bccMail);
        }
        helper.setSubject(subject);
        helper.setText(content, contentIsHtml);
        // 设置附件（注意这里的fileName必须是服务器本地文件名，不能是远程文件链接）
        if (!ObjectUtils.isEmpty(files)) {
            for (File file : files) {
                helper.addAttachment(file.getName(), file);
            }
        }
        javaMailSender.send(message);
    }

    public void sendEmail(String subject, String content, boolean contentIsHtml, String fromMailPersonalName,
                          String toMail, String ccMail, String bccMail, String fileName, InputStreamSource fileInput) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(mailProperties.getUsername(), fromMailPersonalName);
        helper.setTo(toMail);
        if (!ObjectUtils.isEmpty(ccMail)) {
            helper.setCc(ccMail);
        }
        if (!ObjectUtils.isEmpty(bccMail)) {
            helper.setBcc(bccMail);
        }
        helper.setSubject(subject);
        helper.setText(content, contentIsHtml);
        // 设置附件（注意这里的fileName必须是服务器本地文件名，不能是远程文件链接）
        if (fileInput != null) {
            helper.addAttachment(fileName, fileInput);
        }
        javaMailSender.send(message);
    }
}
