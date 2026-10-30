package com.sgic.lms.controller;

import com.sgic.lms.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private studentService studentService;

    @GetMapping("/print")
    public String print(){
        return studentService.getAppInfo();
    }
}
