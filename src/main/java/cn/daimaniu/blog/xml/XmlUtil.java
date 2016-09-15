package cn.daimaniu.blog.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Author :keepcleargas
 * Date   :2016-09-15 13:45.
 */
public class XmlUtil {
    /**
     * java-object as xml-string
     *
     * @param object
     * @return
     */
    public static String seriazileAsString(Object object, Class clazz) {
        if (object == null) {
            return "";
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            java.io.StringWriter sw = new StringWriter();

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(object, sw);

            return sw.toString();
        } catch (JAXBException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * xml-string to java-object
     *
     * @param xmlString
     * @return
     */
    public static <T> T deserializeAsObject(String xmlString, Class clazz) {
        if (xmlString == null || clazz == null) {
            return null;
        }
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(xmlString);
            T userModel = (T) jaxbUnmarshaller.unmarshal(reader);
            return userModel;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
