package com.password.test;

import com.password.encrypt.SUDY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by jsguan on 2022-09-14.
 */
public class TestXb {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = getMysqlConn();
            String sql = "SELECT LoginName,IdCard FROM T_USER";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            String xh = null;
            String xm = null;
            System.out.println("===========开始生成密码");
            while (rs.next()) {
                String dlm = rs.getString("LoginName");
                //String idCard = rs.getString("IdCard");
                String idCard = rs.getString("IdCard");
                //idCard = idCard.substring(idCard.length() - 6, idCard.length());
                if(idCard.length()>17){


                int i=Integer.parseInt(idCard.substring(16,17));

                String xb = (i%2)>0?"1":"2";

                //String idsPassword = SUDY.idsPasswordEncrypt(dlm, password);

                //System.out.println("INSERT INTO T_PASS_RESULT (`dlm`,`password`) VALUES('" + dlm + "'" + ",'" + password + "');");
                System.out.println("UPDATE T_RYZX_RY SET XB = '" + xb +"' WHERE DLM = '" + dlm + "';");
                }

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
        String url = "jdbc:mysql://127.0.0.1:33006/testpass?characterEncoding=UTF-8";
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
