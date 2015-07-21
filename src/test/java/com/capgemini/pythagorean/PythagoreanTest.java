package com.capgemini.pythagorean;

import org.junit.Assert;
import org.junit.Test;

public class PythagoreanTest {

	@Test
	public void should31875000() {
		Assert.assertEquals(31875000, Pythagorean.pythagoreanTriplet(1000));
	}

	@Test
	public void should4200() {
		Assert.assertEquals(4200, Pythagorean.pythagoreanTriplet(56));
	}

}
