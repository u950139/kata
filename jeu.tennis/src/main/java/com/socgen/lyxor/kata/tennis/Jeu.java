package com.socgen.lyxor.kata.tennis;

public interface Jeu extends Playable, Scoreable<String> {
	Status getStatus();

	Integer getId();

	public enum Status {
		DEUCE, AVANTAGE, GAGNE, CONTINUE;
	}

	Joueur getJoueurAvantageux();

	Joueur[] getJoeurs();

	void setPointProvider(PointProvider randomPointProvider);
}
