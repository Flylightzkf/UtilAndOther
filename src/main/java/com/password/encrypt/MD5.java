/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.password.encrypt;

import java.security.MessageDigest;

/**
 *
 * @author lguo
 */
public class MD5 {

    private final static String[] strDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String encrypt(String plaintext) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return byteToString(md.digest(plaintext.getBytes()));
    }

    private static String byteToString(byte[] bByte) {
        StringBuilder sBuffer = new StringBuilder();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }

    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }
}