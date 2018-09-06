package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor
{
	@Autowired
	SpellChecker spellChecker;
	
	public SpellChecker getSpellChecker()
	{
        return spellChecker;
    }
	
	public void setSpellChecker(SpellChecker spellChecker)
	{
        this.spellChecker = spellChecker;
    }
	
	public void showState()
	{
		System.out.println("Spell checker is " + spellChecker.getState());
	}
}
