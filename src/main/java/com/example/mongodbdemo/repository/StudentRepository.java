package com.example.mongodbdemo.repository;

import com.example.mongodbdemo.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student,String> {

 Student findByEmail(String email);
 Student findByStudentNumber(long studentNumber);

 List<Student> findAllByOrderByGpaDesc();

}
