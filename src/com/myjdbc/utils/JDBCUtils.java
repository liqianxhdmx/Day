package com.myjdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtils {
    /**
     * 获取连接
     *
     */
    public static Connection getConnection()
    {
        String driverName = "com.mysql.jdbc.Driver";

        String url = "jdbc:mysql://localhost:3306/johnnyCollege?serverTimezone=UTC";
        String user = "root" ;
        String password = "123456";
        Connection con = null ;
        try {

            Class.forName(driverName);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con ;

    }

    /**
     * 关闭连接
     */
    public static void free( Connection con)
    {
        try {
            if(null != con)
            {
                con.close();
                con = null ;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试连接
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        Connection conn=JDBCUtils.getConnection();
        System.out.println(conn);
        JDBCUtils.free(conn);

    }
}


