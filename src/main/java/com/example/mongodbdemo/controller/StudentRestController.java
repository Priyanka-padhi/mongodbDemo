package com.example.mongodbdemo.controller;


import com.example.mongodbdemo.dto.StudentDTO;
import com.example.mongodbdemo.model.Student;
import com.example.mongodbdemo.service.StudentService;
import com.example.mongodbdemo.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/")
    public List<StudentDTO> getAllStudents(){
        return ObjectMapperUtils.mapAll(studentService.findAll(),StudentDTO.class);
    }

    @GetMapping(value = "/byStudentNo/{studentNumber}")
    public StudentDTO getStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber){
        return ObjectMapperUtils.map(studentService.findByStudentNumber(studentNumber), StudentDTO.class);
    }

    @GetMapping("/byEmail/{email}")
    public StudentDTO getStudentByEmail(@PathVariable("email") String email){
        return ObjectMapperUtils.map(studentService.findByEmail(email), StudentDTO.class);
    }

    @GetMapping(value = "/orderByGpa")
    public List<StudentDTO> findAllByOrderByGpaDesc() {
        return ObjectMapperUtils.mapAll(studentService.findAllByOrderByGpaDesc(), StudentDTO.class);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveOrUpdateStudent(@RequestBody StudentDTO studentDTO){
        studentService.saveOrUpdateStudent(ObjectMapperUtils.map(studentDTO, Student.class));
        return new ResponseEntity("Student added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{studentNumber}")
    public ResponseEntity<?> deleteStudentByStudentNumber(@PathVariable long studentNumber) {
        studentService.deleteStudentById(studentService.findByStudentNumber(studentNumber).getId());
        return new ResponseEntity("Student deleted successfully", HttpStatus.OK);
    }

}
