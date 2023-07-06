package com.password.encrypt;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.util.Base64;

/**
 * Created by jsguan on 2021/8/4.
 */
public class testPass {

    public static void main(String[] args) throws Exception {

        System.out.println(SUDY.verifyIdsField29("07F3143160255B0F8D96F272ACC7E0F8EF710B5B8091AE9D7CF86A33C1BDCDFF92887205CAD7309D662704CAB37E7445", "10", "154215"));

        try {

            String str = "{\"code\":\"001\",\"account\":\"test\",\"password\":\"123456\",\"package_group_id\":\"1\",\"serial_number\":\"20161111123433\"}";
            byte[] bytes = str.getBytes();
            System.out.println(Base64.getEncoder().encodeToString(bytes));
            String timestamp="20181231235959";
            String key = "eyJjb2RlIjoiMDAxIiwiYWNjb3VudCI6InRlc3QiLCJwYXNzd29yZCI6IjEyMzQ1NiIsInBhY2thZ2VfZ3JvdXBfaWQiOiIxIiwic2VyaWFsX251bWJlciI6IjIwMTYxMTExMTIzNDMzIn0=20181231235959abcdefg123";

            System.out.println("121222222222222222222222="+MD5.encrypt(key));


            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            byte[] b = key.getBytes();
            byte[] digest = md5.digest(b);
            System.out.println("==========="+base64en.encode(digest));


            System.out.println(true&&true&&true&&true&&true&&true&&true&&true&&false);

            System.out.println("=========================================================加密");

            // 明文->MD5加密
            System.out.println("明文===================>Password");
            String loginName1 = "admin";
            String password1 = "Sudy!#lvu123";
            System.out.println(SUDY.idsPasswordEncrypt(loginName1, password1));

            // 明文->MD4加密
            System.out.println("明文===================>Field22");
            String loginName2 = "rwang";
            String password2 = "124858";
            System.out.println(MD4.encrypt(password2));

            // 明文->SSHA加密->AES加密
            System.out.println("明文===================>Field29");
            String loginName3 = "ids_admin";
            String password3 = "jvic12#$";
            System.out.println(SUDY.idsField29Encrypt(loginName3, password3)); // 值不固定

            // 明文->SSHA加密
            System.out.println("明文===================>ldap密码");
            String loginName4 = "";
            String password4 = "123abc";
            System.out.println(SUDY.ldapPasswordEncrypt(password4)); // 值不固定

            System.out.println();
            System.out.println("=========================================================解密");

            // 明文->AES加密 ->AES解密
            System.out.println("passtrace======================>明文");
            try {
                String loginName6 = "";
                String srcValue = "EBDF39011CA831C50F778792E7A3F067";
                System.out.println(AES.decrypt(srcValue, "sudy@ids&m47"));
            } catch (Exception ex) {
                System.out.println("解析异常");
            }

            // 明文->AES加密 ->AES解密
            System.out.println("passtrace老版===================>明文");
            try {
                String loginName7 = "rwang";
                String ciphertext = "FE14E27A5A1A6737E04680926791EC55";
                System.out.println(AES.decrypt(ciphertext, loginName7));
            } catch (Exception ex) {
                System.out.println("解析异常");
            }

            // 明文->SSHA加密->AES加密 ->AES解密
            System.out.println("Field29========================>ldap密码");
            String loginName5 = "admin";
            //String field29 = "33EB39FF7C18BF8689128D4E588F54AFE46F293A66580ED633225BE59A2AC14BB3B6A4F5E172E1F98BB8DB8A0E1746FB";
            String field29 = "93DA1C5E4745B3B932FC9D32AC7DCEF938FD37EA84A50A21D827E13B95872CF36A0275D94B03F4FDDB47EA0E73FE8F12";
            try {
                System.out.println(SUDY.idsField29Decrypt(field29, loginName5));
            } catch (Exception ex) {
                System.out.println("解析异常");
            }

            System.out.println();
            System.out.println("=========================================================校验");
            // 明文密文->校验合法,注意去掉密文前缀{SSHA},
            System.out.println("校验ldap密码================================>是否合法");
            System.out.println(SSHA.verify("HoJBV7rgCFXePBSXP4dfjJ6E02W7kMbJvw3Mmw==", "admin123"));

            // 明文密文->校验合法
            System.out.println("校验Field29================================>是否合法");
            try {
                System.out.println(SUDY.verifyIdsField29(
                        "0FFA4DDBD2D79D8C0DFF3E60CF42C71B9C626BB33A635CE994C49709BD1E3043",
                        "test002", "gjs?19950520"));
            } catch (Exception ex) {
                System.out.println("解析异常");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
