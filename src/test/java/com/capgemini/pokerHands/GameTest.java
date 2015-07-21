package com.capgemini.pokerHands;



import org.junit.Assert;
import org.junit.Test;

public class GameTest {

	@Test
	public void should376Wins() {
		Assert.assertEquals(376, Game.play());
	}

}
