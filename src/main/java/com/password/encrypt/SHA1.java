package com.password.encrypt;

import java.security.MessageDigest;

import com.sudytech.util.base.Base64;

public class SHA1 {

  public static String encrypt(String plaintext) throws Exception {
    MessageDigest sha = MessageDigest.getInstance("SHA");
    byte[] byteArray = plaintext.getBytes("UTF-8");
    byte[] md5Bytes = sha.digest(byteArray);
    byte[] base64 = Base64.encodeBase64(md5Bytes);
    return new String(base64, "UTF-8");
  }

  public static boolean verify(String ciphertext, String passowrd) throws Exception {
    return encrypt(passowrd).equals(ciphertext);
  }
}