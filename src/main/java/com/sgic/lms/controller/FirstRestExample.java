package com.sgic.lms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FirstRestExample {
    @GetMapping("/hello")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok("Hello this is my Rest API");
    }

@RequestMapping("/hello-first")
    public Map<String,String> callMethod(){
        Map<String,String>map = new HashMap<>();
        map.put("Message","Hello");
        map.put("Message","Hello2");
        map.put("Message1","Mirusiga");
        map.put("Message1","Hello");
        return map;
}
}
