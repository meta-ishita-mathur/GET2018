package com.metacube.training;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
	@Bean
	public Students students()
	{    
		Students students = new Students();
		Set<String> studentSet = new HashSet<String>();
		studentSet.add("Ishita");
		studentSet.add("Aakanksha");
		studentSet.add("Utkarsh");
		studentSet.add("Ajay");
		studentSet.add("Ishita");

		students.setStudentSet(studentSet);
		return students;
	}
}