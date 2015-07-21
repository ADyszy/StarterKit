package com.capgemini.taxiV2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.taxiV2.Taxi;
import com.capgemini.taxiV2.TaxiSet;


public class TaxiSetTest {

	@Test
	public void shouldHave5Taxies() {
		List<Taxi> taxies = new ArrayList<Taxi>();
		Position p = new Position(0, 0);
		for (int i = 0; i < 5; i++) {
			taxies.add(new Taxi(p));			
		}
		TaxiSet t = new TaxiSet(taxies);
		Assert.assertEquals(5, t.getTaxies().size());
	}

}
