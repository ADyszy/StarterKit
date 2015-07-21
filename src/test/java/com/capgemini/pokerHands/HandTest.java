package com.capgemini.pokerHands;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class HandTest {
	
	private static void addCardsToHand(List <Card> cards, String ... cardString) {
		for (String s : cardString) 
			cards.add(new Card(s.charAt(0), s.charAt(1)));
	}
	
	@Test
	public void shouldOnePair() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "8C", "8S", "KC", "9H", "4S");
		Hand h = new Hand(cards);
		Assert.assertEquals(true, h.checkIfOnePair());
	}
	
	@Test
	public void shouldOnePairRate8() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "8C", "8S", "KC", "9H", "4S");
		Hand h = new Hand(cards);
		h.checkHand();
		Assert.assertEquals(8, h.rateByHighestRateCard());
	}

	@Test
	public void shouldTwoPair() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "8C", "8S", "KC", "KH", "4S");
		Hand h = new Hand(cards);
		Assert.assertEquals(true, h.checkIfTwoPair());
	}

	@Test
	public void shouldTwoPairRate13() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "8C", "8S", "KC", "KH", "4S");
		Hand h = new Hand(cards);
		h.checkHand();
		Assert.assertEquals(13, h.rateByHighestRateCard());
	}
	
	@Test
	public void shouldThreeOfKind() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "8C", "8S", "8H", "KH", "4S");
		Hand h = new Hand(cards);
		Assert.assertEquals(true, h.checkIfThreeOfKind());
	}

	@Test
	public void shouldThreeOfKindRate8() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "8C", "8S", "8H", "KH", "4S");
		Hand h = new Hand(cards);
		h.checkHand();
		Assert.assertEquals(8, h.rateByHighestRateCard());
	}
	
	@Test
	public void shouldStraight() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "8C", "9S", "TH", "QH", "JS");
		Hand h = new Hand(cards);
		Assert.assertEquals(true, h.checkIfStraight());
	}
	
	@Test
	public void shouldFlush() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "8C", "9C", "TC", "KC", "JC");
		Hand h = new Hand(cards);
		Assert.assertEquals(true, h.checkIfFlush());
	}
	
	@Test
	public void shouldFourOfKind() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "8C", "8S", "TH", "8D", "8H");
		Hand h = new Hand(cards);
		Assert.assertEquals(true, h.checkIfFourOfKind());
	}

	@Test
	public void shouldNotFourOfKind() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "8C", "2S", "TH", "8D", "8H");
		Hand h = new Hand(cards);
		Assert.assertEquals(false, h.checkIfFourOfKind());
	}

	@Test
	public void shouldFourOfKindRate8() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "8C", "8S", "TH", "8D", "8H");
		Hand h = new Hand(cards);
		h.checkHand();
		Assert.assertEquals(8, h.rateByHighestRateCard());
	}
	
	@Test
	public void shouldFullHouse() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "8C", "8S", "TH", "TD", "8H");
		Hand h = new Hand(cards);
		Assert.assertEquals(true, h.checkIfFullHouse());
	}

	@Test
	public void shouldFullHouseRate8() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "8C", "8S", "TH", "TD", "8H");
		Hand h = new Hand(cards);
		h.checkHand();
		Assert.assertEquals(8, h.rateByHighestRateCard());
	}
	
	@Test
	public void shouldStraightFlush() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "8C", "9C", "TC", "QC", "JC");
		Hand h = new Hand(cards);
		Assert.assertEquals(true, h.checkIfStraightFlush());
	}

	@Test
	public void shouldRoyalFlush() {
		List <Card> cards = new ArrayList<Card>();
		addCardsToHand(cards, "AC", "KC", "TC", "QC", "JC");
		Hand h = new Hand(cards);
		Assert.assertEquals(true, h.checkIfRoyalFlush());
	}
	
	
}
