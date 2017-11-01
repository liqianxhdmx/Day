package com.myjdbc.service;

import com.myjdbc.bean.Admin;
import com.myjdbc.bean.Student;
import com.myjdbc.dao.AdminDao;
import com.myjdbc.dao.StudentsDao;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class MainServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //获取路径
        String path=req.getServletPath();
            if("/findStudent.do".equals(path)){
                findStudent(req,res);
        }else
            if("/addStudent.do".equals(path)){
                addStudent(req,res);
        }else
            if("/add.do".equals(path)){
                add(req,res);
        }else
            if("/deleteStudent.do".equals(path)){
                deleteStudent(req,res);
        }else
            if("/login.do".equals(path)){
                Login(req,res);
        }else
            if ("/toLogin.do".equals(path)){
                toLogin(req,res);
            }
        else
            if("/toUpdate.do".equals(path)){
        toUpdate(req,res);
    }else
		if("/update.do".equals(path)){
        Update(req,res);
    }
        else{
            throw new RuntimeException("没有这个资源");
        }
    }

    /**
     * 登录验证
     * @param req HttpServletRequest
     * @param res HttpServletResponse
     * @throws IOException
     * @throws ServletException
     */
    private void Login(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        //接收参数
        String adminCode=req.getParameter("adminCode");
        String password=req.getParameter("password");
        //验证账号和密码
        AdminDao dao = new AdminDao();
        Admin a = dao.findByCode(adminCode);
        if(a == null){
            req.setAttribute("error", "账号错误");
            req.getRequestDispatcher("login.jsp").forward(req, res);
            JOptionPane.showMessageDialog(null, "你输入的账户不存在", "系统信息", JOptionPane.ERROR_MESSAGE);
            res.sendRedirect("toLogin.do");
        }else if(!a.getPassword().equals(password)){
            req.setAttribute("error", "密码错误");
            req.getRequestDispatcher("login.jsp").forward(req, res);
            JOptionPane.showMessageDialog(null, "密码错误,请重新输入", "系统信息", JOptionPane.ERROR_MESSAGE);
            res.sendRedirect("toLogin.do");
        }else{
            //将账号存入cookie
            Cookie cookie=new Cookie("user",adminCode);
            res.addCookie(cookie);
            //重定向到主页
            res.sendRedirect("findStudent.do");
        }
    }

    /**
     * 登录跳转
     * @param req HttpServletRequest
     * @param res HttpServletResponse
     * @throws IOException
     * @throws ServletException
     */
    private void toLogin(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        req.getRequestDispatcher("login.jsp").forward(req,res);
    }

    /**
     * 删除
     * @param req HttpServletRequest
     * @param res HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    private void deleteStudent(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //request.getAttribute()方法返回request范围内存在的对象，而request.getParameter()方法是获取http提交过来的数据。
        String id=req.getParameter("id");
        StudentsDao dao=new StudentsDao();
        dao.delete(new Integer(id));
        res.sendRedirect("findStudent.do");
    }

    /**
     * 查询学生列表
     * @param req HttpServletRequest
     * @param res HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    protected void findStudent(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        StudentsDao dao=new StudentsDao();
        List<Student>list=dao.findAll();
        req.setAttribute("students", list);
        req.getRequestDispatcher("table.jsp").forward(req, res);
    }

//    protected void findPart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//        StudentsDao dao=new StudentsDao();
//        List<Student>list=dao.findPart();
//    }

    /**
     * 添加学生直接跳转到add.jsp中执行其中代码
     * @param req HttpServletRequest
     * @param res HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    private void addStudent(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //req.getRequestDispatcher请求转发，只能使用绝对路径，返回一个RequestDispatcher对象，前后页面共享一个request
        req.getRequestDispatcher("add.jsp").forward(req, res);
    }

    /**
     * 填完数据后保存到数据库中
     * @param req HttpServletRequest
     * @param res HttpServletResponse
     * @throws IOException
     */
    private void add(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.setCharacterEncoding("utf-8");
        //getParameter方法用于读取提交表单中的值，得到的都是String类型的
        String id=req.getParameter("studentId");
        String name=req.getParameter("studentName");
        String sex=req.getParameter("studentSex");
        String age=req.getParameter("studentAge");
        String studentEducation=req.getParameter("studentEducation");
        //保存这条数据,封装
        Student s=new Student();
        s.setStudentId(Integer.parseInt(id));//用于将获取到的字符串类型转为int类型
        s.setStudentName(name);
        s.setStudentSex(sex);
        s.setStudentAge(Integer.parseInt(age));
        s.setStudentEducation(studentEducation);
        new StudentsDao().save(s);
       //重定向到查询
        res.sendRedirect("findStudent.do");
    }

    /**
     * 修改
     * @param req HttpServletRequest
     * @param res HttpServletResponse
     * @throws ServletException
     * @throws IOException
     */
    private void toUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String id=req.getParameter("id");
        StudentsDao dao=new StudentsDao();
        Student s=dao.findById(new Integer(id));
        req.setAttribute("student", s);
        req.getRequestDispatcher("update.jsp").forward(req, res);
    }

    private void Update(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.setCharacterEncoding("utf-8");
        String id=req.getParameter("studentId");
        String name=req.getParameter("studentName");
        String sex=req.getParameter("studentSex");
        String age=req.getParameter("studentAge");
        String education=req.getParameter("studentEducation");
        //修改数据
        Student s=new Student();
        s.setStudentId(Integer.parseInt(id));
        s.setStudentName(name);
        s.setStudentSex(sex);
        s.setStudentAge(Integer.parseInt(age));
        s.setStudentEducation(education);
        StudentsDao dao=new StudentsDao();
        dao.update(s);
        //重定向
        res.sendRedirect("findStudent.do");

    }
}
