package com.socgen.lyxor.kata.tennis.impl;

import com.socgen.lyxor.kata.tennis.Joueur;
import com.socgen.lyxor.kata.tennis.Playable;

public abstract class PlayableSupport implements Playable {

	protected Joueur joueur1, joueur2;

	public PlayableSupport(Joueur joueur1, Joueur joueur2) {
		super();
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}
}
