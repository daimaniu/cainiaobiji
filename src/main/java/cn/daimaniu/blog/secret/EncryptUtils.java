package cn.daimaniu.blog.secret;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Author :keepcleargas
 * Date   :2016-09-19 11:25.
 */
public class EncryptUtils {
    /**
     * base 64 编码
     *
     * @param input 字符串输入
     * @return base64 字符串输出
     */
    public static String base64Encode(String input) {
        return Base64.encodeBase64String(input.getBytes());
    }

    /**
     * base64 解码
     *
     * @param input
     * @return
     */
    public static String base64Decode(String input) {
        return new String(Base64.decodeBase64(input));
    }

    /**
     * md5 加密
     *
     * @param str 字符串
     * @return
     */
    public static String md5(String str) {
        try {
            return md5(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * md5 加密 字节为输入
     *
     * @param arr
     * @return
     */
    public static String md5(byte[] arr) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            // must specify "UTF-8" encoding
            md.update(arr);
            byte[] array = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String sha512(String str) {
        try {
            return sha512(str.getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String sha512(byte[] arr) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-512");
            sha.reset();
            // must specify "UTF-8" encoding
            sha.update(arr);
            byte[] array = sha.digest();
            // Use Base64 encoding here
            String hashed = Base64.encodeBase64URLSafeString(array);
            StringBuilder sb = new StringBuilder(32);
            if (hashed.length() > 32) {
                sb.append(hashed.substring(0, 32));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] desEncrypt(SecretKey deskey, String input) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        // Create the cipher
        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        // Initialize the cipher for encryption
        desCipher.init(Cipher.ENCRYPT_MODE, deskey);

        //sensitive information
        byte[] text = input.getBytes();

        System.out.println("Text [Byte Format] : " + text);
        System.out.println("Text : " + new String(text));

        // Encrypt the text
        byte[] textEncrypted = desCipher.doFinal(text);

        return textEncrypted;
    }

    public static String desDecrypt(SecretKey deskey, byte[] input) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, UnsupportedEncodingException {
        // Create the cipher
        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        // Initialize the same cipher for decryption
        desCipher.init(Cipher.DECRYPT_MODE, deskey);

        // Decrypt the text
        byte[] textDecrypted = desCipher.doFinal(input);

        System.out.println("Text Decryted : " + new String(textDecrypted));

        return new String(textDecrypted);
    }
}
