package com.capgemini.pokerHands;

public class HighestCardRateRater extends HandRater {

	@Override
	public int rate(Hand player) {
		return player.rateByHighestRateCard();
	}

}
