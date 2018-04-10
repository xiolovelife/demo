package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.service.MailService;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Created by xiaoxin on 2018/3/26 .
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService MailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() throws Exception {
        MailService.sendSimpleMail("980462113@qq.com","my code test spring boot","hello,my code test spring boot!");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        MailService.sendHtmlMail("980462113@qq.com","test simple mail",content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath=" C:\\Users\\Administrator\\Desktop\\pomdd.xml";
        MailService.sendAttachmentsMail("980462113@qq.com", "请查收论文附件", "附件为欧新栋论文，请查收！", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "xiaoxin";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\Administrator\\Desktop\\dsdsd.jpg";

        MailService.sendInlineResourceMail("980462113@qq.com", "SpringBoot Mail Img", content, imgPath, rscId);
    }

    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("wd", "spring boot");
        String emailContent = templateEngine.process("emailTemplate", context);

        MailService.sendHtmlMail("980462113@qq.com","主题：这是模板邮件",emailContent);
    }
}
