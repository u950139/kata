package com.socgen.lyxor.kata.tennis.impl;

import com.socgen.lyxor.kata.tennis.Joueur;

public class JoueurImpl implements Joueur, Comparable<Joueur> {
	private Integer				points	= 0;
	private String				pseudo;
	private static final int[]	SCORE	= { 0, 15, 30, 40 };

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

	@Override
	public void resetScore() {
		points = 0;
	}

	@Override
	public Integer getScore() {
		if (points <= 3)
			return SCORE[points];
		return SCORE[3];
	}
}
