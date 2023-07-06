/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.password.encrypt;


import com.sudytech.util.base.Base64;

import java.security.MessageDigest;

/**
 *
 * @author lguo
 */
public class SUDY {

	public static String idsField29Encrypt(String loginName, String password) throws Exception {
		String npassword = ldapPasswordEncrypt(password);
		return AES.encrypt(npassword, "ids#s12" + loginName);
	}

	public static String idsField29Decrypt(String ciphertext, String loginName) throws Exception {
		return AES.decrypt(ciphertext, "ids#s12" + loginName);
	}

	public static boolean verifyIdsField29(String ciphertext, String loginName, String password) throws Exception {
		String ldapPassword = idsField29Decrypt(ciphertext, loginName);

		String npassword = "{MD5}" + MD51.encrypt(password);
		if (isSHA1(ldapPassword)) {
			return SHA1.verify(ciphertext.substring(5), password);
		} else {
			return SSHA.verify(ldapPassword.substring(6), password);
		}
	}

	public static String idsField29AesEncrypt(String loginName, String password) throws Exception {
		return AES.encrypt(password, "ids#s12" + loginName);
	}

	private static boolean isSHA1(String ldapPassword) {
		return ldapPassword.startsWith("{SHA}");
	}

	private static boolean isMD5(String ldapPassword) {
		return ldapPassword.startsWith("{MD5}");
	}

	public static String ldapPasswordEncrypt(String password) throws Exception {
		return "{SSHA}" + SSHA.encrypt(password);
	}

	public static String idsPasswordEncrypt(String loginName, String password) throws Exception {
		String plaintext = loginName + password;
		byte[] content = plaintext.getBytes("UTF-8");
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] digest = md5.digest(content);
		byte[] base64 = Base64.encodeBase64(digest);
		return new String(base64, "UTF-8");
	}
}