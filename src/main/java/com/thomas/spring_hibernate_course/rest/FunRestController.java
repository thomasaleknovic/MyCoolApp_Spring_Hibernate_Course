package com.thomas.spring_hibernate_course.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello () {
        return  "Hello World!";
    }
}
