package com.job.prepareJob.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("hello")
    public String printHello(){
        return "Hello";
    }
}
