package com.password.test;

import com.password.encrypt.SUDY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by jsguan on 2021/8/24.
 */
public class TestPassInit {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getMysqlConn();
            String sql = "SELECT LoginName,`Password`,IdCard,Field29 FROM T_USERTEST WHERE LENGTH(IdCard)>0 AND `Password` IS NOT NULL ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            String xh = null;
            String xm = null;
            System.out.println("===========开始生成密码");
            while (rs.next()) {
                String dlm = rs.getString("LoginName");
                String idCard = rs.getString("IdCard");

                String password1 = rs.getString("Password");

                //idCard = idCard.substring(idCard.length() - 6, idCard.length());

                String enPass = idCard.substring(idCard.length() - 6, idCard.length());
                String password = SUDY.idsPasswordEncrypt(dlm, enPass);

                if (password.equals(password1)) {
                    System.out.println("UPDATE T_USER SET PASSWORD = NULL,Field29 = NULL ,Field22 = NULL,Field30 = NULL WHERE LoginName = '" + dlm + "';");
                }
                //String idsPassword = SUDY.idsPasswordEncrypt(dlm, password);
                //String ldapPassword = SUDY.ldapPasswordEncrypt(password);
                //String fieldPassword = SUDY.idsField29AesEncrypt(dlm, ldapPassword);
                //System.out.println("INSERT INTO T_PASS_RESULT (`dlm`,`password`) VALUES('" + dlm + "'" + ",'" + password + "');");
                //System.out.println("UPDATE T_USER SET PASSWORD = '" + password + "',Field29 = '" + fieldPassword + "' WHERE LoginName = '" + dlm + "';");


            }
            //SUDY.idsPasswordEncrypt("", password1)
            System.out.println("===========结束生成密码");

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            releaseRes(ps, "can not close PreparedStatement!");
        }
    }


    public static Connection getMysqlConn() throws Exception {
        String username = "root";
        String password = "12344";
        String driver = "com.mysql.jdbc.Driver";
        //String driver = "oracle.jdbc.driver.OracleDriver";
        //String url = "jdbc:oracle:thin:@202.121.127.221:1521:urpdb";
        //String url = "jdbc:oracle:thin:@(description=(address=(protocol=tcp)(port=1521)(host=172.16.31.100)(PORT = 1521))(connect_data=(SERVER = DEDICATED)(sid_name=urpdb)))";
        String url = "jdbc:mysql://170.18.10.97:3306/CUC_JSGUAN?characterEncoding=UTF-8";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static void releaseRes(PreparedStatement ps, String msg) {
        try {
            ps.close();
        } catch (Exception ex) {

        }
    }
}

