package com.sgic.lms.service;

import com.sgic.lms.entity.student;
import com.sgic.lms.repository.studentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class studentService {

    private final studentRepository repository;

    public student saveStudent(student student){
        return repository.save(student);
    }

    public List<student> getAllStudents(){
        return repository.findAll();
    }

   @Value("${app.name}")
    private String appName;
    @Value("${app.version}")
    private String appVersion;

    public String getAppInfo(){
        return "App Name: " + appName + "App Version: " + appVersion;
    }

    public  student findbyid(long id){
        return repository.findById(id).orElse(null);

    }

    public  void deletebyid(long id){
        repository.deleteById(id);
    }

    public Page<student> getAllStudents(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public student updateStudent(long id, student updatedStudent) {

        student existingStudent = repository.findById(id).orElse(null);

        if (existingStudent != null) {
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setAddress(updatedStudent.getAddress());

            return repository.save(existingStudent);
        }

        return null;
    }
}
