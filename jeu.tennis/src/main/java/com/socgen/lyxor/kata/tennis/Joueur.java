package com.socgen.lyxor.kata.tennis;

public interface Joueur extends Scoreable<Integer> {
	void gagnerPoint();

	int getPoints();

	String getPseudo();

	Set getSetCourant();

	void setSetCourant(Set setCourant);

}
