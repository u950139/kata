package com.socgen.lyxor.kata.tennis.impl;

import com.socgen.lyxor.kata.tennis.Jeu;
import com.socgen.lyxor.kata.tennis.Joueur;

public class JeuImpl extends PlayableSupport implements Jeu, Comparable<Jeu> {

	private Integer id;

	public JeuImpl(Joueur joueur1, Joueur joueur2, Integer id) {
		super(joueur1, joueur2);
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
	public Status getStatus() {
		if (joueur1.getPoints() >= 3 || joueur2.getPoints() >= 3) {
			if (end()) {
				return Status.GAGNE;
			} else if (joueur1.getPoints() == joueur2.getPoints()) {
				return Status.DEUCE;
			} else {
				return Status.AVANTAGE;
			}
		}
		return Status.CONTINUE;
	}

	private boolean end() {
		return (joueur1.getPoints() > 3 || joueur2.getPoints() > 3)
		        && Math.abs(joueur1.getPoints() - joueur2.getPoints()) > 1;
	}

	@Override
	public int compareTo(Jeu o) {
		return this.id.compareTo(o.getId());
	}
}
