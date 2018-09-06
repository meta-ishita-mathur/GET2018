package com.metacube.training;

public class TextEditor
{
	SpellChecker spellChecker;

	public TextEditor(SpellChecker spellChecker)
	{
		this.spellChecker = spellChecker;
	}

	public SpellChecker getSpellChecker()
	{
		return spellChecker;
	}

	public void showState()
	{
		System.out.println("Spell checker is " + spellChecker.getState());
	}
}