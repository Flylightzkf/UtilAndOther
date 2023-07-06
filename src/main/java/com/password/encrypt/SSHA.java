/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.password.encrypt;

import java.security.MessageDigest;
import java.util.Random;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *
 * @author lguo
 */
public class SSHA {

  public static String encrypt(String plaintext) throws Exception {
    MessageDigest md = MessageDigest.getInstance("SHA");
    md.update(plaintext.getBytes());
    Random r1 = new Random();
    byte[] salt = new byte[8];
    r1.nextBytes(salt);
    md.update(salt);
    byte[] plaintextByte = md.digest();
    md.reset();
    md.update(plaintextByte);
    md.update(salt);
    byte[] all = new byte[plaintextByte.length + salt.length];
    System.arraycopy(plaintextByte, 0, all, 0, plaintextByte.length);
    System.arraycopy(salt, 0, all, plaintextByte.length, salt.length);
    return new BASE64Encoder().encode(all);
  }

  public static boolean verify(String ciphertext, String passowrd) throws Exception {
    MessageDigest md = MessageDigest.getInstance("SHA");
    byte[] ldappwbyte = new BASE64Decoder().decodeBuffer(ciphertext);
    byte[] shacode = new byte[20];
    byte[] salt = new byte[ldappwbyte.length - 20];
    System.arraycopy(ldappwbyte, 0, shacode, 0, 20);
    System.arraycopy(ldappwbyte, 20, salt, 0, salt.length);
    md.update(passowrd.getBytes());
    md.update(salt);
    byte[] inputpwbyte = md.digest();
    return MessageDigest.isEqual(shacode, inputpwbyte);
  }
}