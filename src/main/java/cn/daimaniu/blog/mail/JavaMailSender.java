package cn.daimaniu.blog.mail;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;
import org.codemonkey.simplejavamail.TransportStrategy;

import javax.mail.Message;

/**
 * Author :keepcleargas
 * Date   :2016-09-04 13:52.
 * <p>
 * 通过Java Mail 发送邮件,@see{ org.codemonkey.simplejavamail 简单化的Mail发送}
 */
public class JavaMailSender implements IMailSender {
    private final String host = "smtp.126.com"; // smtp host
    private final int port = 465; //smtp 端口
    private final String user = "<请填写你的host相对应的邮件地址>"; //发送者邮件地址 如 xxx@126.com
    private final String password = "<邮件密码>"; //邮件密码
    private final String sender = "<发件人名称>"; //发送人名称

    public boolean send(String to, String toName, String body) {
        Email email = new Email();
        email.setFromAddress(sender, user);
        email.setReplyToAddress(sender, user);
        email.addRecipient(toName, to, Message.RecipientType.TO);
        email.setTextHTML(body);
        email.setSubject("你好" + toName + ",我是一封来自菜鸟笔记的邮件!!!");
        new Mailer(host, port, user, password, TransportStrategy.SMTP_SSL).sendMail(email);
        return true;
    }
}
