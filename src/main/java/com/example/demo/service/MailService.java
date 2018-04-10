package com.example.demo.service;

/**
 * Created by xiaoxin on 2018/3/26 .
 */
public interface MailService {

    //简单文本
    public void sendSimpleMail(String to, String subject, String content);

    //html格式邮件
    public void sendHtmlMail(String to, String subject, String content);

    //附件邮件
    public void sendAttachmentsMail(String to, String subject, String content, String filePath);

    //静态资源邮件
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
