package com.capgemini.pokerHands;

public class ComboHandRater extends HandRater {

	@Override
	public int rate(Hand player) {
		return player.rateByCardCombination();
	}

}
