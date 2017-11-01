package com.myjdbc.bean;


import java.io.Serializable;

public class Admin implements Serializable {

    private String adminCode;
    private String password;


    public Admin(String adminCode) {
        switch (this.adminCode = adminCode) {
        }
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
