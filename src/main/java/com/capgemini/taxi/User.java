package com.capgemini.taxi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class User {
	public static final int MAX_NUMBER_OF_TAXIES_SEARCHED = 10;
	public static final int SEARCHING_RADIUS = 1000;

	private Position position;
	private List<Taxi> usersTaxies = new ArrayList<Taxi>();
	CitySpace citySpace;

	public User(CitySpace citySpace, Position p) {
		this.citySpace = citySpace;
		position = p;
	} 

	public Position getPosition() {
		return position;
	}

	public List<Taxi> getUsersTaxies() {
		return usersTaxies;
	}

	List<Taxi> searchAllTaxiesInRadius() {
		synchronized (citySpace) {
			List<Taxi> taxiesInRadius = new ArrayList<Taxi>();
			for (Taxi taxi : citySpace.getTaxies())
				if (taxi.distanceToUser(this) <= SEARCHING_RADIUS)
					taxiesInRadius.add(taxi);
			return taxiesInRadius;
		}
	}

	List<Taxi> findNearestTaxiesForUser(List<Taxi> searchedTaxies) {
		synchronized (citySpace) {
			Comparator<Taxi> comparator = new TaxiComparator(this);
			Collections.sort(searchedTaxies, comparator);
			if (searchedTaxies.size() > MAX_NUMBER_OF_TAXIES_SEARCHED)
				return new ArrayList<Taxi>(searchedTaxies.subList(0, MAX_NUMBER_OF_TAXIES_SEARCHED));
			return searchedTaxies;
		}
	}

	public void findTaxies() {
		synchronized (citySpace) {
			usersTaxies.clear();
			for (Taxi taxi : findNearestTaxiesForUser(searchAllTaxiesInRadius())) {
				if (taxi.isFree())
					usersTaxies.add(taxi);
			}
		}
	}

	public void printUsersTaxies() {
		for (Taxi taxi : usersTaxies) {
			System.out.println(taxi);
		}
	}

}
