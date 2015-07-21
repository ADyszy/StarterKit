package com.capgemini.taxiV2;

import java.util.Random;

public class TaxiMovementSimulator {
	private TaxiSet taxiSet;

	public TaxiMovementSimulator(TaxiSet taxiSet) {
		this.taxiSet = taxiSet;
	}

	public void moveTaxiesRandomly() {
		// The program is not interested of the city size
		// Taxies can go wherever they like.
		Random rand = new Random();
		for (Taxi taxi : taxiSet.getTaxies()) {
			int shiftX = rand.nextInt(3) - 1;
			int shiftY = rand.nextInt(3) - 1;
			taxi.move(shiftX, shiftY);
		} 

	}

	public void moveTaxiesRandomlyInBounds(int xBound, int yBound) {
		// First coordinate quadrant only. 
		Random rand = new Random();
		for (Taxi taxi : taxiSet.getTaxies()) {
			boolean found = false;
			int shiftX = 0;
			int shiftY = 0;
			while (!found) {
				shiftX = rand.nextInt(3) - 1;
				shiftY = rand.nextInt(3) - 1;
				if(0 < shiftX && shiftX < xBound && 0 < shiftY && shiftY < yBound)
					found = true;
			}
			taxi.move(shiftX, shiftY);
		}

	}
}
