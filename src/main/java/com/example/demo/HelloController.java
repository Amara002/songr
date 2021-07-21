package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



import java.util.ArrayList;

@Controller
public class HelloController {
    @Autowired
    private AlbumRepo AlbumRepo;
    @GetMapping("/hello")
    String helloWorld(){
        return "hello";
    }

    @GetMapping("/capitalize/{id}")
    String hello(Model model, @PathVariable("id") String id) {
        id.toUpperCase();
        model.addAttribute("name",id.toUpperCase());
        return "HelloWorld";
    }



