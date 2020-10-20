package com.job.prepareJob.controller;

import com.job.prepareJob.dao.StudentDao;
import com.job.prepareJob.model.Student;
import com.job.prepareJob.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("hello")
    public String printHello(){
        return "Hello";
    }
    @PostMapping("insert")
    public String insertStudent(@RequestBody Student stu){
        return (studentService.insertStudent(stu))? "insert success":"insert fail";
    }
    @GetMapping("getAll")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
}
