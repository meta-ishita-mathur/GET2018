package com.metacube.training;

import java.util.Set;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	public static void main(String[] args)
	{
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
        Students student = (Students) factory.getBean("student");
        Set<String> studentSet = student.getStudentSet();
        System.out.println("Set of students:");
        
        for(String students: studentSet)
            System.out.println(students);
    }
}