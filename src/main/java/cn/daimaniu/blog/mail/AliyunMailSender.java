package cn.daimaniu.blog.mail;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * Author :keepcleargas
 * Date   :2016-09-04 13:55.
 * <p>
 * 通过Aliyun Java SDK 发送邮件
 */
public class AliyunMailSender implements IMailSender {
    public boolean send(String to, String toName, String body) {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<your accessKey>", "<your accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendMailRequest request = new SingleSendMailRequest();
        try {
            request.setAccountName("<控制台创建的发信地址>");
            request.setFromAlias("菜鸟笔记"); //发送人的昵称
            request.setAddressType(1);
            request.setTagName("<控制台创建的标签>");
            request.setReplyToAddress(true);
            request.setToAddress(to);
            request.setSubject("你好" + toName + ",我是一封来自菜鸟笔记的邮件!!!");
            request.setHtmlBody(body);
            SingleSendMailResponse httpResponse = client.getAcsResponse(request);
            System.out.println("res:" + httpResponse.toString());
            return true;
        } catch (ServerException e) {
            e.printStackTrace();
            return false;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }
}
