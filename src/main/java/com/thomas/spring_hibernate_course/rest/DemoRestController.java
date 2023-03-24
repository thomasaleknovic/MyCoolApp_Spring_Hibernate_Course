package com.thomas.spring_hibernate_course.rest;

import com.thomas.spring_hibernate_course.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    private Coach myCoach;

    @Autowired
    public DemoRestController(Coach theCoach) {
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout () {
       return myCoach.getDailyWorkout();
    }

}
