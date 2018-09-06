package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	public static void main(String[] args) 
	{
		ApplicationContext factory = new ClassPathXmlApplicationContext("Beans.xml");
		TextEditor text =  (TextEditor) factory.getBean("text");
		text.showState();
	}
}
