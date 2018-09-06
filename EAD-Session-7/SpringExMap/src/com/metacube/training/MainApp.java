package com.metacube.training;

import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	public static void main(String[] args)
	{
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
        StudentMarks marks = (StudentMarks) factory.getBean("marks");
        Map<String, Double> averageMarks = marks.getAverageMarks();
        System.out.println("Average marks of students:");
        System.out.println("Student\t\tAverage Marks");
        
        for(String student: averageMarks.keySet())
        {
            System.out.println(student + "\t\t" + averageMarks.get(student));
        }
    }
}