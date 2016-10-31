package com.socgen.lyxor.kata.tennis;

public interface Jeu {
	Status getStatus();

	Integer getId();

	public enum Status {
		DEUCE, AVANTAGE, GAGNE, CONTINUE;
	}
}
