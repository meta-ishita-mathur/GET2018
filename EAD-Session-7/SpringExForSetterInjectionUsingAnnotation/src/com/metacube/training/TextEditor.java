package com.metacube.training;

public class TextEditor
{
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