package com.socgen.lyxor.kata.tennis;

import java.util.stream.IntStream;

import org.junit.Assert;
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
		Assert.assertEquals(joueur.getPoints(), 6);
	}
}
