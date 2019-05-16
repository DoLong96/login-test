package com.example.login.Request;

import javax.persistence.*;
import java.sql.Date;

public class StudentRequest {
    private String fullname;
    private java.sql.Date brithday;
    private String phone;
    private String address;

        public StudentRequest(){

        };
    public StudentRequest(String fullname, Date brithday, String phone, String address) {
        this.fullname = fullname;
        this.brithday = brithday;
        this.phone = phone;
        this.address = address;
    }

    @Basic
    @Column(name = "fullname")
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    @Basic
    @Column(name = "brithday")
    public java.sql.Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
