package com.metacube.training;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	public static void main(String[] args)
	{    
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		Students students = (Students) factory.getBean("students");
		List<String> studentList = students.getStudentList();
		System.out.println("List of students:");

		for(String student: studentList)
		{
			System.out.println(student);
		}
	}
}