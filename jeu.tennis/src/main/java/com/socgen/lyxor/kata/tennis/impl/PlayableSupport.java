package com.socgen.lyxor.kata.tennis.impl;

import com.socgen.lyxor.kata.tennis.Joueur;

public abstract class PlayableSupport {

	protected Joueur joueur1, joueur2;

	public PlayableSupport(Joueur joueur1, Joueur joueur2) {
		super();
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}
}
