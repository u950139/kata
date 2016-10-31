package com.socgen.lyxor.kata.tennis;

import static org.junit.Assert.assertEquals;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import com.socgen.lyxor.kata.tennis.impl.JeuImpl;
import com.socgen.lyxor.kata.tennis.impl.JoueurImpl;

public class JeuTest {
	private Jeu				jeu;
	private final Joueur	j1	= new JoueurImpl("YMB");
	private final Joueur	j2	= new JoueurImpl("LYXOR");

	@Before
	public void init() {
		j1.resetScore();
		j2.resetScore();
		jeu = new JeuImpl(j1, j2, 1);
	}

	@Test
	public void jeuDeuceEtAvantageTest() {
		IntStream.range(0, 3).forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				j1.gagnerPoint();
				j2.gagnerPoint();
			}
		});

		assertEquals("DEUCE", jeu.getStatus());

		j2.gagnerPoint();
		assertEquals("J2 doit avoir AVANTAGE", "AVANTAGE", jeu.getStatus());
		j1.gagnerPoint();
		assertEquals("Le jeu doit revenir a DEUCE", "DEUCE", jeu.getStatus());
	}
}
