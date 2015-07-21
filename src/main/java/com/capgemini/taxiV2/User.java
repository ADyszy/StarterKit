package com.capgemini.taxiV2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class User implements Observer {

	private TaxiSet observedTaxiSet;

	private static final int DEFAULT_RADIUS = 1000;
	private static final int DEFAULT_NUM_OF_TAXIES = 10;

	private Position position;
	private List<Taxi> usersTaxies;

	public User(TaxiSet taxiSet, Position position) {
		this.observedTaxiSet = taxiSet;
		this.position = position;
	}

	public void update(Observable arg0, Object arg1) {
		findUsersTaxies(DEFAULT_RADIUS, DEFAULT_NUM_OF_TAXIES);
	}

	private void findUsersTaxies(int radius, int numberOfChosenTaxies) {
		setUsersTaxies(getNearestTaxies(substractTaxiesInRadius(radius), numberOfChosenTaxies));
	}

	private List<Taxi> getNearestTaxies(List<Taxi> listOfTaxies, int numberOfChosenTaxies) {
		Collections.sort(listOfTaxies, new TaxiComparator(this));
		if (numberOfChosenTaxies <= listOfTaxies.size())
			return listOfTaxies.subList(0, numberOfChosenTaxies);
		else
			return listOfTaxies;
	}

	private List<Taxi> substractTaxiesInRadius(int radius) {
		List<Taxi> tmpList = new ArrayList<Taxi>();
		for (Taxi taxi : this.observedTaxiSet.getTaxies()) {
			if (taxi.getPosition().getDistanceTo(this.getPosition()) <= radius && taxi.isFree()) {
				tmpList.add(taxi);
			}
		}
		return tmpList;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public List<Taxi> getUsersTaxies() {
		return usersTaxies;
	}

	public void setUsersTaxies(List<Taxi> usersTaxies) {
		this.usersTaxies = usersTaxies;
	}

	public String toString() {
		String str = "User on position: " + position;
		str += "\nTaxies for user:";
		if (usersTaxies.isEmpty()) {
			str += "\nNo taxies for user found yet.";
			return str;
		}
		DecimalFormat f = new DecimalFormat("##.00");
		for (Taxi taxi : usersTaxies) {
			str += "\n" + taxi + " distance to User: " + f.format(taxi.getPosition().getDistanceTo(this.position));
		}
		return str;
	}

}
