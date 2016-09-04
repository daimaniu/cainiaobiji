package cn.daimaniu.blog.mail;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;

/**
 * Author :keepcleargas
 * Date   :2016-09-04 17:17.
 */
public class VelocityUtil {
    /**
     * 生成 注册邮件
     *
     * @param to     接收人的邮件地址
     * @param toName 接收人的昵称
     * @param code   邮件验证码
     * @return
     */
    public static String genRegMail(String to, String toName, String code) {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        ve.init();

        Template t = ve.getTemplate("template/reg.vm", "utf-8");
        VelocityContext ctx = new VelocityContext();
        ctx.put("to", to);
        ctx.put("toName", toName);
        //code random
        ctx.put("code", code);

        StringWriter sw = new StringWriter();
        t.merge(ctx, sw);
        return sw.toString();
    }
}
