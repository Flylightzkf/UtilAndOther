package com.password.encrypt;

import com.sudytech.util.base.Base64;

import java.security.MessageDigest;
public final class MD51 {
    private static final String[] strDigits = new String[]{
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f"};

    @Deprecated
    public static String encrypt(String plaintext) throws Exception {
        byte[] content = plaintext.getBytes("UTF-8");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] digest = md5.digest(content);
        byte[] base64 = Base64.encodeBase64(digest);
        return new String(base64, "UTF-8");
    }

    public static String newEncrypt(String plaintext) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return byteToString(md.digest(plaintext.getBytes()));
    }

    private static String byteToString(byte[] bByte) {
        StringBuilder sBuffer = new StringBuilder();
        for (int i = 0; i < bByte.length; i++)
            sBuffer.append(byteToArrayString(bByte[i]));
        return sBuffer.toString();
    }

    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0)
            iRet += 256;
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return String.valueOf(strDigits[iD1]) + strDigits[iD2];
    }
}