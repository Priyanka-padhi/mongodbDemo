package com.example.mongodbdemo.service;

import com.example.mongodbdemo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentService {


    List<Student> findAll();

    Student findByStudentNumber(long studentNumber);

    Student findByEmail(String email);

    List<Student> findAllByOrderByGpaDesc();

    Student saveOrUpdateStudent(Student student);

    void deleteStudentById(String id);

}
