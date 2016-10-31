package com.socgen.lyxor.kata.tennis;

import static org.junit.Assert.assertEquals;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import com.socgen.lyxor.kata.tennis.Jeu.Status;
import com.socgen.lyxor.kata.tennis.impl.JeuImpl;
import com.socgen.lyxor.kata.tennis.impl.JoueurImpl;

public class JeuTest {
	private Jeu				jeu;
	private PointProvider pointProvider = new RandomPointProvider();
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

		assertEquals(Status.DEUCE, jeu.getStatus());

		j2.gagnerPoint();
		assertEquals("J2 doit avoir AVANTAGE", Status.AVANTAGE, jeu.getStatus());
		j1.gagnerPoint();
		assertEquals("Le jeu doit revenir a DEUCE", Status.DEUCE, jeu.getStatus());
	}

	@Test
	public void jeuDeuceEtGagneTest() {
		IntStream.range(0, 3).forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				j1.gagnerPoint();
				j2.gagnerPoint();
			}
		});

		assertEquals(Status.DEUCE, jeu.getStatus());

		j2.gagnerPoint();
		assertEquals("J2 doit avoir AVANTAGE", Status.AVANTAGE, jeu.getStatus());
		j2.gagnerPoint();
		assertEquals("Le jeu doit être gagné", Status.GAGNE, jeu.getStatus());
	}

	@Test
	public void resetScoreTest() {
		IntStream.range(0, 3).forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				j1.gagnerPoint();
				j2.gagnerPoint();
			}
		});
		jeu.resetScore();
		assertEquals(0, j1.getScore().intValue());
		assertEquals(0, j2.getScore().intValue());
	}

	@Test
	public void getScoreTest() {
		j1.gagnerPoint();
		assertEquals("YMB-15 / LYXOR-LOVE", jeu.getScore());
		j1.resetScore();
		IntStream.range(0, 3).forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				j1.gagnerPoint();
				j2.gagnerPoint();
			}
		});

		assertEquals("DEUCE", jeu.getScore());

		j2.gagnerPoint();
		assertEquals("J2 doit avoir AVANTAGE", "LYXOR- ADV / YMB- 40", jeu.getScore());
		j2.gagnerPoint();
		assertEquals("LYXOR- Gagne / YMB- 40", jeu.getScore());
	}
	
	@Test
	public void randomPlay() {
		jeu.setPointProvider(randomPointProvider);
		jeu.play();
		assertEquals(true, jeu.end());
	}
}
