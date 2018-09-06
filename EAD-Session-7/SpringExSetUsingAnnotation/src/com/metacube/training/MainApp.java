package com.metacube.training;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp
{
	public static void main(String[] args)
	{    
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		Students students = (Students) factory.getBean("students");
		Set<String> studentSet = students.getStudentSet();
		System.out.println("Set of students:");

		for(String student: studentSet)
		{
			System.out.println(student);
		}
	}
}