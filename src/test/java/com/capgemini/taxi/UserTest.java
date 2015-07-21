package com.capgemini.taxi;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

	@Test
	public void RadiusTest() throws PositionOutOfBoundsException {
		CitySpace cs = new CitySpace(20000, 20000);
		new Taxi(cs, 1, 1);
		new Taxi(cs, 1, 10);
		new Taxi(cs, 1, 100);
		new Taxi(cs, 1, 1000);
		new Taxi(cs, 1, 10000);
		User user = new User(cs, new Position(0, 0));
		Assert.assertEquals(3,user.searchAllTaxiesInRadius().size());
	}

	
	private void createTaxiesInFirstLine(CitySpace cs , int ... pos) throws PositionOutOfBoundsException {
		for (int i : pos)
			new Taxi(cs, 1, i);
	}
	@Test
	public void usersTaxiListShouldHaveSizeOf10() throws PositionOutOfBoundsException {
		CitySpace cs = new CitySpace(20000, 20000);
		createTaxiesInFirstLine(cs, 10,10,10,10,10,10,10,12,12,12,12,12,14);
		User user = new User(cs, new Position(0, 0));
		user.findTaxies();
		Assert.assertEquals(10 , user.getUsersTaxies().size() );
	}

	@Test
	public void usersTaxiListShouldHaveLastElementWithDistanceToUserEqual12() throws PositionOutOfBoundsException {
		CitySpace cs = new CitySpace(20000, 20000);
		createTaxiesInFirstLine(cs, 10,10,10,10,10,10,10,12,12,12,12,12,14);
		User user = new User(cs, new Position(0, 0));
		user.findTaxies();
		Assert.assertEquals(12 , (int) user.getUsersTaxies().get(user.getUsersTaxies().size()-1).distanceToUser(user));
	}

}
