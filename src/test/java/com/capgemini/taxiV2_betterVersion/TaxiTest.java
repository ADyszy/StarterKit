package com.capgemini.taxiV2_betterVersion;

import org.junit.Assert;
import org.junit.Test;

public class TaxiTest {

	@Test
	public void testidShouldIncrement() {
		Taxi.zeroId();
		Taxi t1 = new Taxi(new Position(2, 2));
		t1.isFree();
		Taxi t2 = new Taxi(new Position(2, 2));
		Assert.assertEquals(2, t2.getId());
	}
	
	@Test
	public void taxiShouldMoveToCoordinates4And4() {
		Taxi t = new Taxi(new Position(2, 2));
		boolean flag = false;
		t.move(2, 2);
		if (t.getPosition().getXPosition() == 4 && t.getPosition().getYPosition() == 4)
			flag = true;
		Assert.assertEquals(true, flag);
	}

}

