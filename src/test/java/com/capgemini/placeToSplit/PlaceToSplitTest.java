package com.capgemini.placeToSplit;

import org.junit.Assert;
import org.junit.Test;

public class PlaceToSplitTest {

	@Test
	public void shouldTrueCanBalance() {
		int [] arr = {1, 1, 1, 2, 1};
    	Assert.assertEquals(true,PlaceToSplit.canBalance(arr));
	}

	@Test
	public void shouldTrueCanBalance2() {
		int [] arr = {10, 10};
		Assert.assertEquals(true,PlaceToSplit.canBalance(arr));
	}

	@Test
	public void shouldFalseCanBalance() {
		int [] arr = {2, 1, 1, 2, 1};
		Assert.assertEquals(false,PlaceToSplit.canBalance(arr));
	}

}
