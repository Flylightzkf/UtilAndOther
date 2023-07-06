package com.password.test;

import com.password.encrypt.AES;
import com.password.encrypt.MD4;
import com.password.encrypt.SSHA;
import com.password.encrypt.SUDY;

public class SudyPassword {

  public static void main(String[] args) throws Exception {

    try {
      System.out.println("=========================================================加密");

//      // 明文->MD5加密
//      System.out.println("明文===================>Password");
//      String loginName1 = "admin";
//      String password1 = "Imp-2022-hFu!";
//      System.out.println(SUDY.idsPasswordEncrypt(loginName1, password1));
//
//      // 明文->MD4加密
//      System.out.println("明文===================>Field22");
//      String loginName2 = "rwang";
//      String password2 = "124858";
//      System.out.println(MD4.encrypt(password2));
//
//      // 明文->SSHA加密->AES加密
//      System.out.println("明文===================>Field29");
//      String loginName3 = "ids_admin";
//      String password3 = "jvic12#$";
//      System.out.println(SUDY.idsField29Encrypt(loginName3, password3)); // 值不固定
//
//      // 明文->SSHA加密
//      System.out.println("明文===================>ldap密码");
//      String loginName4 = "";
//      String password4 = "123abc";
//      System.out.println(SUDY.ldapPasswordEncrypt(password4)); // 值不固定
//
//      System.out.println();
//      System.out.println("=========================================================解密");

      //明文->AES加密 ->AES解密
      System.out.println("passtrace======================>明文");
      try {
        String loginName6 = "";
        String srcValue = "";
        //System.out.println(AES.decrypt(srcValue, "sudy@ids&m47"));

        //System.out.println(AES.decrypt("2CAE66435C5628BF3F68B1067FCBB55B", "Just102738"));
        System.out.println(AES.decrypt("2CAE66435C5628BF3F68B1067FCBB55B", "sudy@ids&m47"));

      } catch (Exception ex) {
        System.out.println("解析异常");
        System.out.println(ex);
      }

//      // 明文->AES加密 ->AES解密
//      System.out.println("passtrace老版===================>明文");
//      try {
//        String loginName7 = "202300000079";
//        String ciphertext = "2CAE66435C5628BF3F68B1067FCBB55B";
//        System.out.println(AES.decrypt(ciphertext, loginName7));
//      } catch (Exception ex) {
//        System.out.println("解析异常");
//      }

//      // 明文->SSHA加密->AES加密 ->AES解密
//      System.out.println("Field29========================>ldap密码");
//      String loginName5 = "12102289";
//      String field29 = "86A4E7AA681CF13503511CB694E11CCB2E287211988295157C35A7AA1B72F5871BDA5D706FC3430F84461B7692234A86";
//      try {
//        System.out.println(SUDY.idsField29Decrypt(field29, loginName5));
//      } catch (Exception ex) {
//        System.out.println("解析异常");
//      }
//
//      System.out.println(AES.encrypt("{SSHA}Lg9xKAaRdTdDqteeYkwSd/C7kRjlqSALyqaTww==", "ids#s12" + "010507"));
//      System.out.println(AES.decrypt("764083639193F028D25A7FB27CC02A555D79FEAD39958AC267771ED73BB2758082FE511DD168E015E822C91775F14E28", "ids#s12" + "010507"));
//      System.out.println(SUDY.idsField29Decrypt("764083639193F028D25A7FB27CC02A555D79FEAD39958AC267771ED73BB2758082FE511DD168E015E822C91775F14E28", "010507"));
//      System.out.println();
//      System.out.println("=========================================================校验");
//      // 明文密文->校验合法,注意去掉密文前缀{SSHA},
//      System.out.println("校验ldap密码================================>是否合法");
//      System.out.println(SSHA.verify("v7BLOGse5CMBxxXY49ml9ECWcvLhV/DrD3VHtg==", "melissa003"));
//
//      // 明文密文->校验合法
//      System.out.println("校验Field29================================>是否合法");
//      try {
//        System.out.println(SUDY.verifyIdsField29(
//                "8101D98B960A843012C0A5705E9015D9FDBCEA5C20AE00E9D5E0B9B462319705",
//                "10200710", "Ntkfdx_10200710"));
//      } catch (Exception ex) {
//        System.out.println("解析异常");
//      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
