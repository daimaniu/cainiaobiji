package cn.daimaniu.blog.xml;

import cn.daimaniu.blog.xml.model.XmlUserModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Author :keepcleargas
 * Date   :2016-09-15 16:28.
 */
public class XmlUtilTest {
    /**
     * 测试对象的xml解析
     */
    @Test
    public void testXmlObject() {
        XmlUserModel xmlUserModel = new XmlUserModel();
        xmlUserModel.setFirstName("chen");
        xmlUserModel.setLastName("billy");
        xmlUserModel.setEmail("wsncqs@gmail.com");
        xmlUserModel.setId(1);

        String xmlStr = XmlUtil.seriazileAsString(xmlUserModel, XmlUserModel.class);

        System.out.println(xmlStr);

        //jsonStr -> object
        XmlUserModel deXmlUserModel = XmlUtil.deserializeAsObject(xmlStr, XmlUserModel.class);

        assertEquals(xmlUserModel.getId(), deXmlUserModel.getId());
    }
}
