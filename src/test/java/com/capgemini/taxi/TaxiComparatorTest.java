package com.capgemini.taxi;

import org.junit.Assert;
import org.junit.Test;

public class TaxiComparatorTest {

	@Test
	public void shouldOne() throws PositionOutOfBoundsException {
		CitySpace citySpace = new CitySpace(500, 500);
		User user = new User(citySpace, new Position(1, 1));
		TaxiComparator comparator = new TaxiComparator(user);
		Assert.assertEquals(1,comparator.compare(new Taxi(citySpace, 1, 8), new Taxi(citySpace, 1, 1)));
	}

	@Test
	public void shouldMinusOne() throws PositionOutOfBoundsException {
		CitySpace citySpace = new CitySpace(500, 500);
		User user = new User(citySpace, new Position(1, 1));
		TaxiComparator comparator = new TaxiComparator(user);
		Assert.assertEquals(-1,comparator.compare(new Taxi(citySpace, 1, 1), new Taxi(citySpace, 1, 8)));
	}

	@Test
	public void shouldZero() throws PositionOutOfBoundsException {
		CitySpace citySpace = new CitySpace(500, 500);
		User user = new User(citySpace, new Position(1, 1));
		TaxiComparator comparator = new TaxiComparator(user);
		Assert.assertEquals(0,comparator.compare(new Taxi(citySpace, 1, 1), new Taxi(citySpace, 1, 1)));
	}

}
