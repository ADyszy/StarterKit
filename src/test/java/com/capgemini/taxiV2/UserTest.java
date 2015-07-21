package com.capgemini.taxiV2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

	@Test
	public void shouldHave5Taxies() {
		List<Taxi> taxies = new ArrayList<Taxi>();
		Position p = new Position(0, 0);
		for (int i = 0; i < 5; i++) {
			taxies.add(new Taxi(p));			
		}
		TaxiSet t = new TaxiSet(taxies);
		User u = new User(t, p);
		t.addObserver(u);
		t.changed();
		t.notifyObservers();
		Assert.assertEquals(5, u.getUsersTaxies().size());
	}

	@Test
	public void shouldHave10Taxies() {
		List<Taxi> taxies = new ArrayList<Taxi>();
		Position p = new Position(0, 0);
		for (int i = 0; i < 50; i++) {
			taxies.add(new Taxi(p));			
		}
		TaxiSet t = new TaxiSet(taxies);
		User u = new User(t, p);
		t.addObserver(u);
		t.changed();
		t.notifyObservers();
		Assert.assertEquals(10, u.getUsersTaxies().size());
	}

	@Test
	public void nearestTaxiShouldBeInX1Y1() {
		List<Taxi> taxies = new ArrayList<Taxi>();
		Position p = new Position(1, 5);
		for (int i = 0; i < 50; i++) {
			taxies.add(new Taxi(p));			
		}
		taxies.add(new Taxi(new Position(1, 1)));
		TaxiSet t = new TaxiSet(taxies);
		User u = new User(t, p);
		t.addObserver(u);
		t.changed();
		t.notifyObservers();
		Assert.assertEquals(1, u.getUsersTaxies().get(0).getPosition().getXPosition());
	}

}
