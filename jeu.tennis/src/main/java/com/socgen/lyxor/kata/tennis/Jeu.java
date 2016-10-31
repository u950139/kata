package com.socgen.lyxor.kata.tennis;

public interface Jeu extends Scoreable<String> {
	Status getStatus();

	Integer getId();

	public enum Status {
		DEUCE, AVANTAGE, GAGNE, CONTINUE;
	}
}
