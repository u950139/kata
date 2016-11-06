package com.socgen.lyxor.kata.tennis.impl.provider;

import java.util.Scanner;

import com.socgen.lyxor.kata.tennis.PointProvider;

public class SystemInputPointProvider implements PointProvider {

	@Override
	public int providePoint() {
		System.out.print("Veuillez saisir un nombre (0=Quit,1=Joueur1, 2=Joueur 2, 9=Scores):  ");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}
