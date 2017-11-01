package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FirstJDBC {
    public static void main(String[] args)
    {
        //调用连接数据库的操作
        Connection con = createConnection();
    }
    /**
     * JDBC 建立 SQL Server数据库连接
     */
    private static Connection createConnection() {

        //定义加载驱动程序
        String driverName = "com.mysql.jdbc.Driver";

        //定义 连接 服务器 和 数据库sample
        String dbURL = "jdbc:mysql://localhost:3306/johnnyCollege?serverTimezone=UTC";

        //默认用户名，不要用windows默认身份验证
        String userName = "root" ;
        String userPassword = "123456" ;
        Connection connection = null ;
        Statement sta = null ;

        try {
            //正式加载驱动
            Class.forName(driverName);
            //开始连接
            connection = DriverManager.getConnection(dbURL, userName, userPassword);
            System.out.println("Connection Success !");

            //向数据库中执行SQL语句
            sta = connection.createStatement() ;
            ResultSet rs = sta.executeQuery("SELECT studentId,studentName,studentSex,studentAge,studentEducation From student");
            while(rs.next())
            {
                int studentID = rs.getInt("studentID");
                String studentName = rs.getString("studentName");
                String studentSex = rs.getString("studentSex");
                int studentAge = rs.getInt("studentAge");
                String studentEducation = rs.getString("studentEducation");

                System.out.println("studentID = "+studentID+" studentName = "+studentName+" studentSex = "+studentSex+
                        "studentAge = "+studentAge+" studentEducation = "+studentEducation);
            }
        } catch (Exception e) {

            System.out.println("Connection Fail !");
            e.printStackTrace() ;
        }
        /**
         * 关闭数据库
         * @param connection
         */
        finally
        {
            try {
                if (null != sta)
                {
                    sta.close() ;
                    sta = null;
                    System.out.println("Statement 关闭成功");
                }
                if (null != connection)
                {
                    connection.close() ;
                    connection = null;
                    System.out.println("Connection 关闭成功");
                }
            } catch (Exception e) {

                e.printStackTrace() ;
            }
        }
        return connection ;
    }
}