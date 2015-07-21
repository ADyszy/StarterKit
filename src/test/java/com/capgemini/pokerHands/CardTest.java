package com.capgemini.pokerHands;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {

	@Test
	public void shouldGiveMinusOne() {
		Card card = new Card('5', 'C');
		Assert.assertEquals(-1, card.compareTo(new Card('A', 'C')));
	}
	
	@Test
	public void shouldGiveZero() {
		Card card = new Card('5', 'C');
		Assert.assertEquals(0, card.compareTo(new Card('5', 'S')));
	}

}
