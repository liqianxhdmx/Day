package com.myjdbc.dao;

import com.myjdbc.bean.Student;

public interface StudentDAO {

    public int addStudent(Student student);

    public int deleteStudent(String name);

    public int updateStudent(String name);
}
