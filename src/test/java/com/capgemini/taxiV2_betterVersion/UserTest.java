package com.capgemini.taxiV2_betterVersion;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

	@Test
	public void shouldNotifyAndSeeTaxies() {
		List<Taxi> taxies = new ArrayList<Taxi>();
		Position p = new Position(0, 0);
		for (int i = 0; i < 5; i++) {
			taxies.add(new Taxi(p));			
		}
		TaxiSet t = new TaxiSet(taxies);
		User user = new User(t, new Position(0, 0));
		t.addObserver(user);
		t.changed();
		t.notifyObservers();
		Assert.assertEquals(5,user.getUsersTaxies().size());
	}

}
