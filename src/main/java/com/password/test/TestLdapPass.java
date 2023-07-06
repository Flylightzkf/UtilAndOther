package com.password.test;

import com.password.encrypt.SUDY;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class TestLdapPass {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        ResultSet rs = null;
        try {
            conn = getMysqlConn();
            String sql = "SELECT LoginName,Field29 FROM T_USER_LDAP";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            conn.setAutoCommit(false);
            System.out.println("===========开始生成密码");
            int index = 0;
            String passSql = "UPDATE T_USER_LDAP SET LdapPass = ? WHERE LoginName = ?";
            ps1 = conn.prepareStatement(passSql);
            Map<String,String>  map = new HashMap<>();
            while (rs.next()) {
                String dlm = rs.getString("LoginName");
                String field29 = rs.getString("Field29");
                String ldapPass = "";
                try {
                    ldapPass = SUDY.idsField29Decrypt(field29, dlm);
                    //System.out.println(ldapPass);
                } catch (Exception ex) {
                    System.out.println("解析异常");
                }

                map.put(dlm,ldapPass);
                ps1.setString(1,ldapPass);
                ps1.setString(2,dlm);
                ps1.addBatch();
                index++;
                if(index ==1000){
                    ps1.executeBatch();
                    index =0;
                    map = new HashMap<>();
                }
            }

            //SUDY.idsPasswordEncrypt("", password1)
            for(Map.Entry<String,String> entry:map.entrySet()){
                String loginName = entry.getKey();
                String pass = entry.getValue();
                //String passql = "UPDATE T_USER_LDAP SET LdapPass = '"+pass+"' WHERE LoginName = '" + loginName + "'";
                ps1.setString(1,pass);
                ps1.setString(2,loginName);
                ps1.addBatch();
            }
            ps1.executeBatch();
            conn.commit();
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
        String url = "jdbc:mysql://127.0.0.1:3306/RYZX_TEST?characterEncoding=UTF-8";
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