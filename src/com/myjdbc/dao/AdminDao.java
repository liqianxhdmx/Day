package com.myjdbc.dao;

import com.myjdbc.bean.Admin;
import com.myjdbc.utils.JDBCUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao implements Serializable {
    public Admin findByCode(String admin_code){
        Connection conn=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from admin_info where admin_code=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, admin_code);//占位符（？）的下标从1开始.
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Admin a=new Admin(admin_code);
                a.setAdminCode(rs.getString("admin_code"));
                a.setPassword(rs.getString("password"));
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("登陆失败",e);
        }finally{
            JDBCUtils.free(conn);
        }
        return null;
    }

    //测试
    public static void main(String[] args) {
        AdminDao dao=new AdminDao();
        Admin a=dao.findByCode("yangyajing");
        System.out.println(a.getPassword());

    }

}
