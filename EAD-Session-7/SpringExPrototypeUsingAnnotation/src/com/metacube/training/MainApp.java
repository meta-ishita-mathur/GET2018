package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	public static void main(String[] args)
	{    
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);

		Person firstPerson = (Person) factory.getBean("person");
		System.out.println("Name of first person : " + firstPerson.getName());
		firstPerson.setName("Aakanksha");
		System.out.println("Updated name of first person : " + firstPerson.getName());

		Person secondPerson = (Person) factory.getBean("person");
		System.out.println("Name of second person : " + secondPerson.getName());
	}
}