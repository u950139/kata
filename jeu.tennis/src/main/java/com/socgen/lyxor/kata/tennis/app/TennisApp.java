package com.socgen.lyxor.kata.tennis.app;


import com.socgen.lyxor.kata.tennis.PointProvider;
import com.socgen.lyxor.kata.tennis.Set;
import com.socgen.lyxor.kata.tennis.impl.JoueurImpl;

import com.socgen.lyxor.kata.tennis.impl.SetImpl;
import com.socgen.lyxor.kata.tennis.impl.provider.SystemInputPointProvider;

public class TennisApp {
	
	PointProvider pointProvider = new SystemInputPointProvider();
	
	public static void main(String... argv) {
			new TennisApp().run();	
	}
	
	public void run() {
		Set set = new SetImpl(new JoueurImpl("YMB"), new JoueurImpl("LYX"),1);	
		set.setPointProvider(pointProvider);
		while(!set.end()) {
			set.play();		
		}
		set.afficherScore();
	}
}
