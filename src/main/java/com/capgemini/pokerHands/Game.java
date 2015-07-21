package com.capgemini.pokerHands;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
	private Hand player1;
	private Hand player2;
	private BufferedReader file;
		
	Game(String fileName){
		try {
			file = new BufferedReader( new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.err.println("File "+fileName+" not found.");
			e.printStackTrace();
		}
	}
		
	private boolean readNextHands(){
		String line;
		try {
			if((line = file.readLine()) != null){
				initPlayers(line);
				player1.checkHand();
				player2.checkHand();
				return true;
			}
		} catch (IOException e) {
			System.err.println("File stream error.");
			e.printStackTrace();
		}
		return false;
	}
	
	
	private void initPlayers(String line){
		String [] split = line.split(" ");
		List <Card> cards = new ArrayList<Card>();
		for (String i:split){
			cards.add(new Card(i.charAt(0), i.charAt(1)));
		}
		player1 = new Hand(cards.subList(0, 5));
		player2 = new Hand(cards.subList(5, cards.size()));
	}
		
	private boolean firstWins() {
		player1.checkHand();
		player2.checkHand();
		List<HandRater> raters = new ArrayList<HandRater>();
		raters.add(new ComboHandRater());
		raters.add(new HighestCardRateRater());
		raters.add(new HighestCardRater());
		for (HandRater handRater : raters) {			
			if(!handRater.isDraw(player1, player2))
				return handRater.firstWins(player1, player2);
		}
		return false;
	}
	 	
	public static int play(){
		int count=0;
		Game g = new Game("C:/Users/adyszy/Documents/workspace/javaExercises/src/main/java/com/capgemini/pokerHands/poker.txt");
		while(g.readNextHands()) {
			if (g.firstWins()) {
				count ++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(play());
	}
	
}
