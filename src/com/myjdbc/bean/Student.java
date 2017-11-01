package com.myjdbc.bean;

import java.io.Serializable;

public class Student implements Serializable{

    private Integer studentId;
    private String studentName ;
    private String studentSex;
    private Integer studentAge ;
    private String studentEducation ;

    public Integer getStudentId() {
        return studentId;
    }
    public void setStudentId(Integer studentId) { //这里用到了方法的重载
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public Integer getStudentAge() {
        return studentAge;
    }
    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }
    public String getStudentSex() {
        return studentSex;
    }
    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }
    public String getStudentEducation() {
        return studentEducation;
    }
    public void setStudentEducation(String studentEducation) {
        this.studentEducation = studentEducation;
    }
}
