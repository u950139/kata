package com.socgen.lyxor.kata.tennis;

public interface Scoreable<T> {
	T getScore();

	void resetScore();
}
