package com.capgemini.pokerHands;

public abstract class HandRater {
	
	public abstract int rate(Hand player);
	
	public boolean firstWins(Hand player1, Hand player2) {
		return (rate(player1) > rate(player2))? true : false;
	}
	
	public boolean isDraw(Hand player1, Hand player2) {		
		return (rate(player1) == rate(player2))? true : false;
	}
}
