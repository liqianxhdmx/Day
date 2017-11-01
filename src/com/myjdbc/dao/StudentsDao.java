package com.myjdbc.dao;

import com.myjdbc.bean.Student;
import com.myjdbc.utils.JDBCUtils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StudentsDao implements Serializable {
    /**
     * 查询
     * @return
     */
    public List<Student>findAll(){
        Connection conn=null;
        try {
            conn= JDBCUtils.getConnection();
            String sql="select * from student order by studentId";
            //实例化Satement对象
            Statement smt=conn.createStatement();
            //executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中供我们使用
            ResultSet rs=smt.executeQuery(sql);
            //创建了一个集合,他的类型是student,集合的名字是list
            List<Student>list=new ArrayList<Student>();
            while(rs.next()){ //如果有下一行数据，则滚动到下一行。
                Student s=new Student();
                s.setStudentId(rs.getInt("studentId"));
                s.setStudentName(rs.getString("studentName"));
                s.setStudentSex(rs.getString("studentSex"));
                s.setStudentAge(rs.getInt("studentAge"));
                s.setStudentEducation(rs.getString("studentEducation"));
                list.add(s);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.free( conn);
        }
        return null;
    }

    //保存
    public void save(Student s){

        Connection conn=null;
        try {
            conn=JDBCUtils.getConnection();
            //用占位符的方式写SQL语句
            String sql="insert into student values(?,?,?,?,?)";
            PreparedStatement ps=conn.prepareStatement(sql);
            //对占位符进行设置,第一个参数是占位符的位置,第二个参数是占位符的值.
            ps.setInt(1, s.getStudentId());
            ps.setString(2, s.getStudentName());
            ps.setString(3, s.getStudentSex());
            ps.setInt(4, s.getStudentAge());
            ps.setString(5, s.getStudentEducation());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("保存失败",e);
        }finally{
            JDBCUtils.free(conn);
        }
    }

    //删除
    public void delete(int id){
        Connection conn=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="delete from student where studentId=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.free( conn);
        }
    }

    /**
     * 修改
     * @param rs
     * @return
     * @throws SQLException
     */
    private Student createStudent(ResultSet rs) throws SQLException{
        Student s=new Student();
        s.setStudentId(rs.getInt("studentId"));
        s.setStudentName(rs.getString("studentName"));
        s.setStudentSex(rs.getString("studentSex"));
        s.setStudentAge(rs.getInt("studentAge"));
        s.setStudentEducation(rs.getString("studentEducation"));
        return s;
    }
    public Student findById(int id){
        Connection conn=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="select * from student where studentId=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                return createStudent(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.free(conn);
        }
        return null;
    }
    public void update(Student s){
        if(s==null)
            return;
        Connection conn=null;
        try {
            conn=JDBCUtils.getConnection();
            String sql="update student set studentName=?,studentSex=?,studentAge=?,studentEducation=? where studentId=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(5, s.getStudentId());
            ps.setString(1, s.getStudentName());
            ps.setString(2, s.getStudentSex());
            ps.setInt(3, s.getStudentAge());
            ps.setString(4, s.getStudentEducation());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.free(conn);
        }
    }

    //模糊查询
    public void quireStudent(){
        Connection conn = null;
        try{
            conn=JDBCUtils.getConnection();
            String sql = "select studentId,studentName,studentSex,studentAge,studentEducation from student where studentName like %?%";
            PreparedStatement ps=conn.prepareStatement(sql);
           ps.setString(1,"杨雅静");
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    //测试
    public static void main(String[] args) {
        StudentsDao dao = new StudentsDao();
        Student s = new Student();
        s.setStudentName("杨雅静");
        s.setStudentSex("女");
        s.setStudentAge(21);
        s.setStudentEducation("华为畅想");
        dao.save(s);
    }

}