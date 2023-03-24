package com.thomas.spring_hibernate_course.common;

import org.springframework.stereotype.Component;

@Component
public class TenisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Pratice your backhand volley";
    }
}
