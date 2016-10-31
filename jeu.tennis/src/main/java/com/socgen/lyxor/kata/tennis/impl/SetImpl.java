package com.socgen.lyxor.kata.tennis.impl;

import java.util.HashMap;
import java.util.Map;

import com.socgen.lyxor.kata.tennis.Jeu;
import com.socgen.lyxor.kata.tennis.Joueur;
import com.socgen.lyxor.kata.tennis.Set;

public class SetImpl extends PlayableSupport implements Set {

	private Map<Joueur, Integer>	score		= new HashMap<>();
	private int						numero;
	private int						nombreJeux	= 1;
	private Jeu						jeuCourant;
	public boolean					tieBreak	= false;

	public SetImpl(Joueur joueur1, Joueur joueur2, int numero) {
		super(joueur1, joueur2);
		joueur1.setSetCourant(this);
		joueur2.setSetCourant(this);
		this.numero = numero;
		jeuCourant = new JeuImpl(joueur1, joueur2, 1);
	}

	@Override
	public Map<Joueur, Integer> getScore() {
		afficherScore();
		return score;
	}

	@Override
	public void afficherScore() {
		System.out.println("|Set N° " + numero + (isTieBreak() ? "(TieBreak)" : ""));
		System.out.println("|-------------------------------------------------------");
		score.forEach((joueur, score) -> {
			System.out.println("|   " + joueur.getPseudo() + ": " + score);
		});
		System.out.println();
	}

	@Override
	public int getNumero() {
		return numero;
	}

	@Override
	public void play() {
		initScore();
		while (!end()) {
			jeuCourant = new JeuImpl(joueur1, joueur2, nombreJeux);
			jeuCourant.resetScore();
			while (!jeuCourant.end()) {
				jeuCourant.play();
			}
			nombreJeux++;
			score.put(jeuCourant.getJoueurAvantageux(), score.get(jeuCourant.getJoueurAvantageux()) + 1);
			if (tieBreak) {
				break;
			}
		}
	}

	@Override
	public boolean end() {
		boolean sixGameReached = jeuCourant != null && score.get(jeuCourant.getJoeurs()[0]) != null
		        && (score.get(jeuCourant.getJoeurs()[0]) >= 6 || score.get(jeuCourant.getJoeurs()[1]) >= 6);
		if (sixGameReached && !tieBreak) {
			tieBreak = Math.abs(score.get(jeuCourant.getJoeurs()[0]) - score.get(jeuCourant.getJoeurs()[1])) == 0;
		}
		return sixGameReached
		        && Math.abs(score.get(jeuCourant.getJoeurs()[0]) - score.get(jeuCourant.getJoeurs()[1])) >= 2;
	}

	private void initScore() {
		score.put(joueur1, new Integer(0));
		score.put(joueur2, new Integer(0));
	}

	@Override
	public void resetScore() {
		score.clear();
	}

	@Override
	public boolean isTieBreak() {
		return tieBreak;
	}

	@Override
	public Jeu getJeuCourant() {
		return jeuCourant;
	}

}
