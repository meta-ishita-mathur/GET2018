package com.metacube.training;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
    @Bean
    public StudentMarks marks()
    {    
        StudentMarks marks = new StudentMarks();
        Map<String, Double> averageMarks = new HashMap<String, Double>();
        averageMarks.put("Ishita", 75.8);
        averageMarks.put("Renu", 55.0);
        averageMarks.put("Utkarsh", 80.0);
        averageMarks.put("Ajay", 64.0);
        
        marks.setAverageMarks(averageMarks);
        return marks;
    }
}