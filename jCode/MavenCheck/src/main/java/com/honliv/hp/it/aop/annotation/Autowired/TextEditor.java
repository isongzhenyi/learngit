package com.honliv.hp.it.aop.annotation.Autowired;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor
{
	@Autowired
	private SpellChecker spellChecker;

	// @Autowired
	// public void setSpellChecker(SpellChecker spellChecker)
	// {
	// this.spellChecker = spellChecker;
	// }

	// public SpellChecker getSpellChecker()
	// {
	// return spellChecker;
	// }

	// private SpellChecker spellChecker;
	//
	// public void setSpellChecker(SpellChecker spellChecker)
	// {
	// this.spellChecker = spellChecker;
	// }
	//
	// public SpellChecker getSpellChecker()
	// {
	// return spellChecker;
	// }

	public void spellCheck()
	{
		spellChecker.checkSpelling();
	}
}
