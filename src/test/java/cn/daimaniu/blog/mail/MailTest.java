package cn.daimaniu.blog.mail;

import org.junit.Test;

/**
 * Author :chenqisheng
 * Date   :2016-09-04 14:22.
 */
public class MailTest {
    @Test
    public void TestJavaMailSender() {
        IMailSender mailSender = new JavaMailSender();
        mailSender.send("wsncqs@gmail.com", "keepcleargas", "我是来自菜鸟笔记的邮件正文");
    }

    @Test
    public void TestAliyunMailSender() {
        IMailSender mailSender = new AliyunMailSender();
        mailSender.send("wsncqs@gmail.com", "keepcleargas", "我是来自菜鸟笔记的邮件正文(1)");
    }

    @Test
    public void VelocityHtmlTest() {
        IMailSender mailSender = new JavaMailSender();
        mailSender.send("wsncqs@gmail.com", "keepcleargas", VelocityUtil.genRegMail("wsncqs@gmail.com", "keepcleargas", "666666"));
    }
}
