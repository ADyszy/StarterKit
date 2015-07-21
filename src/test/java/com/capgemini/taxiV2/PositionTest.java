package com.capgemini.taxiV2;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.taxi.Position;

public class PositionTest {

	@Test
	public void distanceshould5() {
		Position p = new Position(0, 0);
		Assert.assertEquals(5, (int) p.getDistanceTo(new Position( 0, 5)));
	}

}
