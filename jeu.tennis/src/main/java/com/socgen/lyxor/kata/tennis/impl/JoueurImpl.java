package com.socgen.lyxor.kata.tennis.impl;

import com.socgen.lyxor.kata.tennis.Joueur;

public class JoueurImpl implements Joueur, Comparable<Joueur> {
	private Integer	points	= 0;
	private String	pseudo;

	@Override
	public String getPseudo() {
		return pseudo;
	}

	@Override
	public void gagnerPoint() {
		points += 1;
	}

	public JoueurImpl(String pseudo) {
		super();
		assert pseudo != null && pseudo.length() > 3;
		this.pseudo = pseudo;
	}

	@Override
	public String toString() {
		return "JoueurImpl [Pseudo=" + getPseudo() + "]";
	}

	@Override
	public int compareTo(Joueur o) {
		return this.pseudo.compareToIgnoreCase(o.getPseudo());
	}

	@Override
	public int getPoints() {
		return points;
	}
}
