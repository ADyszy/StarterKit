package com.capgemini.taxiV2_betterVersion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaxiSearchingSimulation {

	private final static int BOUND = 100000;
	private final static int NUM_OF_TAXIES = 1000000;
	
	private static List<Position> generateRandomPositionsList(int amount, int max) {
		List<Position> posList = new ArrayList<Position>();
		Random rand = new Random();
		for (int i = 0; i < amount; i++)
			posList.add(new Position(rand.nextInt(max), rand.nextInt(max)));
		return posList;
	}

	public static void main(String[] args) {
		List<Position> p = generateRandomPositionsList(NUM_OF_TAXIES, BOUND);
		List<Taxi> taxies = new TaxiesInitialiser(p).getTaxies();
		TaxiSet taxiSet = new TaxiSet(taxies);
		Position usersPosition = new Position(0, 0);
		User user = new User(taxiSet, usersPosition);
		taxiSet.addObserver(user);
		TaxiMovementSimulator tms = new TaxiMovementSimulator(taxiSet);
		TaxiUsageSimulator tus = new TaxiUsageSimulator(taxiSet);
		while (true) {
			tms.moveTaxiesRandomlyInBounds(BOUND , BOUND );
			tus.useTaxiesRandomly();
			taxiSet.changed();
			taxiSet.notifyObservers();
			System.out.println(user);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
