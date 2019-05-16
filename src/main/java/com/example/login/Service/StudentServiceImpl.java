package com.example.login.Service;

import com.example.login.Entity.Student;
import com.example.login.Repository.StudentRepository;
import com.example.login.Request.StudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public void add(StudentRequest studentRequest) {
        Student student=new Student();
        student.setFullname(studentRequest.getFullname());
        student.setBrithday((Date) studentRequest.getBrithday());
        student.setPhone(studentRequest.getPhone());
        student.setAddress(studentRequest.getAddress());
        studentRepository.save(student);
    }

    @Override
    public void edit(Long id, StudentRequest studentRequest) {
        Student student=studentRepository.findById(id).get();
        student.setFullname(studentRequest.getFullname());
        student.setBrithday((Date) studentRequest.getBrithday());
        student.setPhone(studentRequest.getPhone());
        student.setAddress(studentRequest.getAddress());
        studentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).get();
    }
}
