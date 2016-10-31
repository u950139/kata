package com.socgen.lyxor.kata.tennis.impl;

import com.socgen.lyxor.kata.tennis.Jeu;
import com.socgen.lyxor.kata.tennis.Joueur;

public class JeuImpl implements Jeu, Comparable<Jeu> {
	protected Joueur	joueur1, joueur2;
	private Integer		id;

	public JeuImpl(Joueur joueur1, Joueur joueur2, Integer id) {
		super();
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.id = id;
	}

	public Joueur getJoueur1() {
		return joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String getStatus() {
		if (joueur1.getPoints() >= 3 || joueur2.getPoints() >= 3) {
			if ((joueur1.getPoints() > 3 || joueur2.getPoints() > 3)
			        && Math.abs(joueur1.getPoints() - joueur2.getPoints()) > 1) {
				return "GAGNE";
			} else if (joueur1.getPoints() == joueur2.getPoints()) {
				return "DEUCE";
			} else {
				return "AVANTAGE";
			}
		}
		return "CONTINUE";
	}

	@Override
	public int compareTo(Jeu o) {
		return this.id.compareTo(o.getId());
	}
}
