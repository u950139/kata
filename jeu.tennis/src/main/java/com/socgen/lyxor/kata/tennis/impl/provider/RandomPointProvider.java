package com.socgen.lyxor.kata.tennis.impl.provider;

import java.util.Random;

import com.socgen.lyxor.kata.tennis.PointProvider;

public class RandomPointProvider implements PointProvider {

	@Override
	public int providePoint() {
		if (new Random().nextBoolean())
			return 1;
		return 2;
	}

}
