package com.sgic.lms.controller;

import com.sgic.lms.entity.student;
import com.sgic.lms.service.studentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class api {
    private final studentService service;

    @PostMapping
    public student
    addStudent(@RequestBody student student){
        return service.saveStudent(student);
    }

    @GetMapping("/all")
    public List<student>getAllStudent(){
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public  student findbyid(@PathVariable long id){
        return service.findbyid(id);

    }

    @DeleteMapping("/{id}")
    public String deleteby(@PathVariable long id){
        service.deletebyid(id);
        return  "delete successfully";
    }

    @PutMapping("/{id}")
    public student updateStudent(@PathVariable long id, @RequestBody student student) {
        return service.updateStudent(id, student);
    }

    @GetMapping
    public Page<student> getAllStudent(
            @PageableDefault(size = 10) Pageable pageable) {

        return service.getAllStudents(pageable);
    }
}