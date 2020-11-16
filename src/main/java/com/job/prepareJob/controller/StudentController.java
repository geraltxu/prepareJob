package com.job.prepareJob.controller;

import com.ctc.wstx.shaded.msv_core.util.Uri;
import com.job.prepareJob.dao.StudentDao;
import com.job.prepareJob.model.Student;
import com.job.prepareJob.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    public RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
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
    @GetMapping("template")
    public List<Student> getByTemplate(@RequestHeader String domain, @RequestHeader String pwd){
        URI uri = null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("domain",domain);
        headers.add("password",pwd);
        try {
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/getAll");
            uri = builder.build().toUri();
        } catch (Exception e) {
            e.printStackTrace();
        }
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(uri, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Student>>() {
        }).getBody();
    }
}
