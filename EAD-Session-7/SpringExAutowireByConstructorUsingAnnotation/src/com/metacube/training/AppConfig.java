package com.metacube.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
	@Bean
	public SpellChecker spellChecker()
	{
		return new SpellChecker("on");
		
	}
	
	@Bean
	public TextEditor textEditor()
	{
		return new TextEditor(spellChecker());
	}
}
