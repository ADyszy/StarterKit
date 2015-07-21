package com.capgemini.pokerHands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hand {

	private Card[] cards;

	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		cards = new Card[] { c1, c2, c3, c4, c5 };
		Arrays.sort(cards);
	}

	public Hand(List<Card> list) {
		this(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
	}

	private List<Card> usageList = new ArrayList<Card>();
	
	private int[] cardAlignments = new int[9];

	private enum Configs {
		ONE_PAIR(0), TWO_PAIR(1), THREE_OF_KIND(2), STRAIGHT(3), FLUSH(4), FULL_HOUSE(5), 
		FOUR_OF_KIND(6), STRIAIGHT_OF_FLUSH(7), ROYAL_FLUSH(8),;
		
		final int val;

		private Configs(int val) {
			this.val = val;
		}
	}

	int rateByCardCombination() {
		for (int i = cardAlignments.length - 1; i >= 0; i--)
			if (cardAlignments[i] > 0)
				return i + 1;
		return 1;
	}

	int rateByHighestRateCard() {
		return cardAlignments[rateByCardCombination() - 1];
	}

	Card highestCard() {
		for (int i = cards.length - 1; i >= 0; i--) {
			if (!usageList.contains(cards[i]))
				return cards[i];
		}
		return cards[cards.length];
	}

	int rateByHighestCard() {
		return highestCard().getValue();
	}

	private void updateCardAlignments(int configValue, int value) {
		cardAlignments[configValue] = value;
	}
	
	private void updateUsageList(Card card){
		usageList.add(card);
	}
	
	boolean checkIfStraight() {
		for (int i = 1; i < cards.length; i++)
			if (cards[i].getValue() - cards[i - 1].getValue() != 1)
				return false;
		updateCardAlignments(Configs.STRAIGHT.val, 1);
		return true;
	}

	boolean isAce() {
		for (Card card : cards) {
			if (card.getValue() == 14)
				return true;
		}
		return false;
	}

	boolean checkIfFlush() {
		for (Card card : cards) {
			if (cards[0].getSuit() != card.getSuit())
				return false;
		}
		updateCardAlignments(Configs.FLUSH.val, 1);
		return true;
	}

	private int repetition(int numOfRepetitions){
		// zero if not found
		int count = 1;
		for (int i = 1; i < cards.length; i++) {
			if (cards[i].getValue() == cards[i - 1].getValue())
				count++;
			else
				count = 1;
			if (count == numOfRepetitions)
				return i;
		}
		return -1;
	}

	private boolean repetitionOfKind(int cardConfig, int numOfRepetitions){
		int tmp = repetition(numOfRepetitions);
		if(tmp >= 0){
			updateCardAlignments(cardConfig, cards[tmp].getValue());
			updateUsageList(cards[tmp]);
			return true;
		}
		return false;
	}
	
	boolean checkIfThreeOfKind() {
		return repetitionOfKind(Configs.THREE_OF_KIND.val, 3);
	}

	boolean checkIfFourOfKind() {
		return repetitionOfKind(Configs.FOUR_OF_KIND.val, 4);
	}

	boolean checkIfOnePair() {
		for (int i = 1; i < cards.length; i++) {
			if (cards[i].getValue() == cards[i - 1].getValue()) {
				updateCardAlignments(Configs.ONE_PAIR.val, cards[i].getValue());
				updateUsageList(cards[i]);
				return true;
			}
		}
		return false;
	}

	boolean checkIfTwoPair() {
		int count = 0;
		for (int i = 1; i < cards.length; i++) {
			if (cards[i].getValue() == cards[i - 1].getValue()) {
				count++;
				updateUsageList(cards[i]);
			}
			if (count == 2) {
				updateCardAlignments(Configs.TWO_PAIR.val, cards[i].getValue());
				updateUsageList(cards[i]);
				return true;
			}
		}
		return false;
	}

	boolean checkIfFullHouse() {
		if (checkIfTwoPair() && checkIfThreeOfKind() && !checkIfFourOfKind())
			return true;
		return false;
	}

	// [Out of date] Use after straight and flush check only
	// TODO: change that. = done.
	boolean checkIfStraightFlush() {
		if (checkIfStraight() && checkIfFlush()) {
			updateCardAlignments(Configs.STRIAIGHT_OF_FLUSH.val, 1);
			return true;
		} else
			return false;
	}

	// [Out of date] Use after straigthFlush check only
	// TODO: change that. = done.
	boolean checkIfRoyalFlush() {
		if (checkIfStraightFlush() && isAce()) {
			updateCardAlignments(Configs.ROYAL_FLUSH.val, 1);
			return true;
		} else
			return false;
	}

	public void checkHand() {
		if (checkIfStraight() && checkIfFlush()) {
			if (checkIfRoyalFlush())
				return;
			checkIfStraightFlush();
		}
		if (checkIfOnePair())
			checkIfTwoPair();
		if (checkIfThreeOfKind()) {
			if (checkIfFullHouse())
				return;
			checkIfFourOfKind();
		}
	}

	public String toString() {
		String str = new String();
		for (Card i : cards)
			str += i + " ";
		return str;
	}
}