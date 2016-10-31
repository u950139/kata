package com.socgen.lyxor.kata.tennis;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import com.socgen.lyxor.kata.tennis.impl.JoueurImpl;

public class JoeurTest {
	Joueur joueur;

	@Before
	public void init() {
		joueur = new JoueurImpl("LYX");
	}

	@Test
	public void gagnerPointsTest() {
		IntStream.range(0, 6).forEach(i -> joueur.gagnerPoint());
		assertEquals(joueur.getPoints(), 6);
	}

	@Test
	public void resetScoreTest() {
		joueur.gagnerPoint();
		joueur.gagnerPoint();
		joueur.gagnerPoint();
		assertEquals(3, joueur.getPoints());
		joueur.resetScore();
		assertEquals(0, joueur.getPoints());
	}

	@Test
	public void getScoreTest() {
		assertEquals(0, joueur.getScore());
		joueur.gagnerPoint();
		assertEquals(15, joueur.getScore());
		joueur.gagnerPoint();
		assertEquals(30, joueur.getScore());
		joueur.gagnerPoint();
		assertEquals(40, joueur.getScore());
		joueur.gagnerPoint();
		assertEquals(40, joueur.getScore());
		joueur.gagnerPoint();
		assertEquals(40, joueur.getScore());
	}
}
