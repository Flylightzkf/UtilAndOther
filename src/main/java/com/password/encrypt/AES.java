/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.password.encrypt;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author lguo
 */
public class AES {

    public static String encrypt(String plaintext, String password) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(password.getBytes());
        kgen.init(128, random);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        byte[] byteContent = plaintext.getBytes("utf-8");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return DataHandler.parseByte2HexStr(cipher.doFinal(byteContent));
    }

    public static String decrypt(String ciphertext, String password) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(password.getBytes());
        kgen.init(128, random);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] byteContent = DataHandler.parseHexStr2Byte(ciphertext);
        return new String(cipher.doFinal(byteContent), "utf-8");
    }
}