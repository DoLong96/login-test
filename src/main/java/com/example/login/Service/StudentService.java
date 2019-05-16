package com.example.login.Service;

import com.example.login.Entity.Student;
import com.example.login.Request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    void  add (StudentRequest studentRequest);
    void edit(Long id,StudentRequest studentRequest);
    void remove(Long id);
    Student getById(Long id);
}
