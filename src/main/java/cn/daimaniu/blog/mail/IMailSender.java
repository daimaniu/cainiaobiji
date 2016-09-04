package cn.daimaniu.blog.mail;

/**
 * Author :keepcleargas
 * Date   :2016-09-04 13:51.
 */
public interface IMailSender {
    boolean send(String to, String toName, String body);
}
