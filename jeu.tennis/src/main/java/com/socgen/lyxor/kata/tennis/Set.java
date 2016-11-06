package com.socgen.lyxor.kata.tennis;

import java.util.Map;

public interface Set extends Playable, Scoreable<Map<Joueur, Integer>> {
	int getNumero();

	boolean isTieBreak();

	Jeu getJeuCourant();

	void setPointProvider(PointProvider pointProvider);
}
