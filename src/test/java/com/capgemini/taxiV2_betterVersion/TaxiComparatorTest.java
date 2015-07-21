package com.capgemini.taxiV2_betterVersion;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TaxiComparatorTest {
	
	@Test
	public void Taxi1ShouldBeMoreThanTaxi2() {
		Taxi t1 = new Taxi(new Position(0, 100));
		Taxi t2 = new Taxi(new Position(0, 50));
		List<Taxi> taxies = new ArrayList<Taxi>();
		taxies.add(t1);
		taxies.add(t2);
		TaxiComparator tc = new TaxiComparator(new User(new TaxiSet(taxies), new Position(0, 0)));
		
		int result = tc.compare(t1, t2);
		Assert.assertEquals(1, result);
	}

	@Test
	public void Taxi2ShouldBeMoreThanTaxi1() {
		Taxi t1 = new Taxi(new Position(0, 100));
		Taxi t2 = new Taxi(new Position(0, 50));
		List<Taxi> taxies = new ArrayList<Taxi>();
		taxies.add(t1);
		taxies.add(t2);
		TaxiComparator tc = new TaxiComparator(new User(new TaxiSet(taxies), new Position(0, 0)));
		
		int result = tc.compare(t2, t1);
		Assert.assertEquals(-1, result);
	}

	@Test
	public void Taxi2ShouldBeEqualToTaxi1() {
		Taxi t1 = new Taxi(new Position(0, 50));
		Taxi t2 = new Taxi(new Position(0, 50));
		List<Taxi> taxies = new ArrayList<Taxi>();
		taxies.add(t1);
		taxies.add(t2);
		TaxiComparator tc = new TaxiComparator(new User(new TaxiSet(taxies), new Position(0, 0)));
		
		int result = tc.compare(t2, t1);
		Assert.assertEquals(0, result);
	}

}
