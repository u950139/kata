package com.socgen.lyxor.kata.tennis.impl;

import com.socgen.lyxor.kata.tennis.Jeu;
import com.socgen.lyxor.kata.tennis.Joueur;
import com.socgen.lyxor.kata.tennis.PointProvider;

public class JeuImpl extends PlayableSupport implements Jeu, Comparable<Jeu> {

	private Integer id;
	private PointProvider pointProvider;

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

	@Override
	public boolean end() {
		return (joueur1.getPoints() > 3 || joueur2.getPoints() > 3)
		        && Math.abs(joueur1.getPoints() - joueur2.getPoints()) > 1;
	}

	@Override
	public int compareTo(Jeu o) {
		return this.id.compareTo(o.getId());
	}

	@Override
	public String getScore() {
		switch (getStatus()) {
		case DEUCE:
			return Status.DEUCE.name();
		case GAGNE:
			return getJoueurAvantageux().getPseudo() + "- Gagne / " + getJoueurNonAvantageux().getPseudo() + "- "
			        + (getJoueurNonAvantageux().getScore() == 0 ? "LOVE" : getJoueurNonAvantageux().getScore());
		case AVANTAGE:
			return getJoueurAvantageux().getPseudo() + "- ADV / " + getJoueurNonAvantageux().getPseudo() + "- "
			        + getJoueurNonAvantageux().getScore();
		default:
			break;
		}

		return getJoueur1().getPseudo() + "-" + (getJoueur1().getScore() == 0 ? "LOVE" : getJoueur1().getScore())
		        + " / " + getJoueur2().getPseudo() + "-"
		        + (getJoueur2().getScore() == 0 ? "LOVE" : getJoueur2().getScore());
	}

	public Joueur getJoueurAvantageux() {
		if (joueur1.getScore() <= 3 && joueur2.getScore() <= 3) {
			return null;
		}
		return (joueur1.getScore() > joueur2.getScore() ? joueur1 : joueur2);
	}

	public Joueur getJoueurNonAvantageux() {

		if (getJoueurAvantageux().equals(joueur1)) {
			return joueur2;
		}
		return joueur1;
	}

	@Override
	public void resetScore() {
		joueur1.resetScore();
		joueur2.resetScore();
	}

	@Override
	public void afficherScore() {
		System.out.println("\n" + getScore());
	}

	@Override
	public void play() {
		int key = pointProvider.providePoint();
		switch (key) {
		case 0:
			System.exit(key);
			break;
		case 1:
			joueur1.gagnerPoint();
			break;
		case 2:
			joueur2.gagnerPoint();
			break;
		case 9:
			afficherScore();
		default:
			break;
		}
	}

	@Override
	public Joueur[] getJoeurs() {
		return new Joueur[] { joueur1, joueur2 };
	}

	@Override
	public void setPointProvider(PointProvider pointProvider) {
		this.pointProvider=pointProvider;
	}
}
