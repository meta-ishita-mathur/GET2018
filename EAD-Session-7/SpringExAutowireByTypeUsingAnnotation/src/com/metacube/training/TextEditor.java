package com.metacube.training;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor
{
    SpellChecker spellChecker;
    
    public SpellChecker getSpellChecker()
    {
        return spellChecker;
    }
    
    @Autowired
    public void setSpellChecker(SpellChecker spellChecker)
    {
        this.spellChecker = spellChecker;
    }
    
    public void showState()
    { 
    	System.out.println("Spell checker is " + spellChecker.getState());
    }
}
