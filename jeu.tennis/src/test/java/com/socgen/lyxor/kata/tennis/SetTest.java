package com.socgen.lyxor.kata.tennis;

import static org.junit.Assert.assertEquals;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import org.junit.Before;
import org.junit.Test;

import com.socgen.lyxor.kata.tennis.impl.JoueurImpl;
import com.socgen.lyxor.kata.tennis.impl.SetImpl;

public class SetTest {

	Joueur	j1	= new JoueurImpl("YMB");
	Joueur	j2	= new JoueurImpl("LYX");
	Set		set;

	@Before
	public void init() {
		set = new SetImpl(j1, j2, 1);
	}

	@Test
	public void jeuCourantEndTest() {
		IntStream.range(0, 4).forEach(new IntConsumer() {
			@Override
			public void accept(int value) {
				j1.gagnerPoint();
			}
		});
		assertEquals(true, set.getJeuCourant().end());
	}
}
