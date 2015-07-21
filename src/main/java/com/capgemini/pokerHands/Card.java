package com.capgemini.pokerHands;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card>{
	
	private static final Map<Integer, String> cardCodeDict;
	private int value;
	private char suit;
	static {
		Map<Integer, String> dict = new HashMap<Integer, String>();;
		for (int i=1; i<=9; i++) {
			dict.put(i, Integer.toString(i));
		}
		dict.put(10, "T");
		dict.put(11, "J");
		dict.put(12, "Q");
		dict.put(13, "K");
		dict.put(14, "A");
		cardCodeDict = Collections.unmodifiableMap(dict);
	}
			
	public int getValue() {
		return value;
	}
	
	public char getSuit() {
		return suit;
	}
	
	public Card(char value, char suit){
		this.suit = suit;
		this.value = codeCardValue(value);
	}
	
	public String toString(){
		return new String(cardCodeDict.get(value)+suit);
	}
	
	public int compareTo(Card o) {
		if (this.value == o.getValue()) 
			return 0;
		if (this.value > o.getValue()) 
			return 1;
		return -1;
	}
	
	private int codeCardValue(char value){
		switch(value){
			case '2':
				return 2;
			case '3':
				return 3;
			case '4':
				return 4;
			case '5':
				return 5;
			case '6':
				return 6;
			case '7':
				return 7;
			case '8':
				return 8;
			case '9':
				return 9;
			case 'T':
				return 10;
			case 'J':
				return 11;
			case 'Q':
				return 12;
			case 'K':
				return 13;
			case 'A':
				return 14;
		}
		return 0;
	}
}
