package com.metacube.training;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
	@Bean
	public Students students()
	{
		List<String> studentList = new ArrayList<String>();
		Students students = new Students();
		studentList.add("Ishita");
		studentList.add("Aakanksha");
		studentList.add("Utkarsh");
		studentList.add("Ajay");
		students.setStudentList(studentList);
		return students;
	}
}