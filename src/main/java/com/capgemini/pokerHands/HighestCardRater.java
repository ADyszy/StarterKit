package com.capgemini.pokerHands;

public class HighestCardRater extends HandRater {

	@Override
	public int rate(Hand player) {
		return player.rateByHighestCard();
	}


}
