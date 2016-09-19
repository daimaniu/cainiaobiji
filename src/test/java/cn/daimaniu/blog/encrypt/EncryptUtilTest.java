package cn.daimaniu.blog.encrypt;

import cn.daimaniu.blog.secret.EncryptUtils;
import org.junit.Test;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

/**
 * Author :keepcleargas
 * Date   :2016-09-19 14:25.
 */
public class EncryptUtilTest {

    @Test
    public void testBase64() {
        String encodeStr = EncryptUtils.base64Encode("hello,world");
        System.out.println("encodeStr:" + encodeStr);

        String decodeStr = EncryptUtils.base64Decode(encodeStr);
        assertEquals("hello,world", decodeStr);
    }

    @Test
    public void testMd5() {
        String md5str = EncryptUtils.md5("123456");
        System.out.println("123456的md5值:" + md5str);
    }

    @Test
    public void testSha() {
        String shaStr = EncryptUtils.sha512("123456");
        System.out.println("123456的sha值:" + shaStr);
    }

    @Test
    public void testEncrypt() throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, BadPaddingException, UnsupportedEncodingException {
        KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
        SecretKey deskey = keygenerator.generateKey();

        byte[] encryptBytes = EncryptUtils.desEncrypt(deskey, "12345678");

        assertEquals("12345678", EncryptUtils.desDecrypt(deskey, encryptBytes));
    }
}
