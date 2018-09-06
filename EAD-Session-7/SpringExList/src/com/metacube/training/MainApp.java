package com.metacube.training;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	public static void main(String[] args)
	{
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
        Students student = (Students) factory.getBean("student");
        List<String> studentList = student.getStudentList();
        System.out.println("List of students:");
        
        for(String students: studentList)
            System.out.println(students);
    }
}