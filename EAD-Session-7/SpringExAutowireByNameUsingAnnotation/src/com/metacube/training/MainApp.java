package com.metacube.training;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
	public static void main(String[] args)
	{

		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
		TextEditor textEditor = (TextEditor) factory.getBean("textEditor");
		textEditor.showState();
	}
}