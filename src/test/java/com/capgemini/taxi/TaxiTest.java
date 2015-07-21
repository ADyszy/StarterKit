package com.capgemini.taxi;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class TaxiTest {

	@Test
	public void taxiIdsShouldBeInSequence1And2() throws PositionOutOfBoundsException {
		Taxi taxi1 = new Taxi(new CitySpace(10, 10), 0, 0);
		Taxi taxi2 = new Taxi(new CitySpace(10, 10), 0, 0);
		Assert.assertEquals(true, taxi1.getTaxiId() == 1 && taxi2.getTaxiId() == 2);
	}

	@After
	public void clearsID() {
		Taxi.clearLastID();
	}

	@Test
	public void taxiShouldBeInCitySpace() throws PositionOutOfBoundsException {
		CitySpace cs = new CitySpace(10, 10);
		cs.addTaxiToCitySpace(new Taxi(cs, 1, 1));
		Assert.assertEquals(false, cs.getTaxies().isEmpty());
	}

	@Test
	public void distanceToUserShouldBe1000() throws PositionOutOfBoundsException {
		CitySpace cs = new CitySpace(10, 10);
		User user = new User(cs, new Position(0, 0));
		cs.addTaxiToCitySpace(new Taxi(cs, 5, 5));
		Assert.assertEquals(7, (int) Math.round(cs.getTaxies().get(0).distanceToUser(user)));
	}

	@Test
	public void afterRandomStepsShouldBeStillInBounds() throws PositionOutOfBoundsException {
		CitySpace cs = new CitySpace(2, 2);
		Taxi taxi = new Taxi(cs, 1, 1);
		cs.addTaxiToCitySpace(taxi);
		for (int i = 0; i < 100; i++)
			taxi.makeRandomStep();
		Assert.assertEquals(true, taxi.inBoundsOfCitySpace(taxi.getPosition()));
	}

	@Test(expected = NullPointerException.class)
	public void shouldThrowNullPointerExceptionBecauseOfNoCitySpaceInitialised()
			throws NullPointerException, PositionOutOfBoundsException {
		CitySpace cs = null;
		Taxi taxi = new Taxi(cs, 1, 1);
		for (int i = 0; i < 100; i++)
			taxi.makeRandomStep();
		Assert.assertEquals(true, taxi.inBoundsOfCitySpace(taxi.getPosition()));
	}

	@Test(expected = PositionOutOfBoundsException.class)
	public void shouldThrowPosiotionOutOfBoundsException()
			throws NullPointerException, PositionOutOfBoundsException {
		CitySpace cs = new CitySpace(2, 2);
		Taxi taxi = new Taxi(cs, 100, 100);
		for (int i = 0; i < 100; i++)
			taxi.makeRandomStep();
		Assert.assertEquals(true, taxi.inBoundsOfCitySpace(taxi.getPosition()));
	}

}
