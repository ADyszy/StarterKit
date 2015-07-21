package com.capgemini.coins;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CoinsTest {

	private void addCoins(List<Integer> coins, int... c) {
		for (int i : c)
			coins.add(i);
	}
 
	@Test
	public void shouldGiveFour() {
		List<Integer> coins = new ArrayList<Integer>();
		addCoins(coins, 1, 1, 0, 1, 0, 0);
		Assert.assertEquals(4, Coins.solution(coins));
	}

	@Test
	public void shouldGiveAdjacencyTwo() {
		List<Integer> coins = new ArrayList<Integer>();
		addCoins(coins, 1, 1, 0, 1, 0, 0);
		Assert.assertEquals(2, Coins.adjacency(coins));
	}

	@Test
	public void shouldGive() {
		List<Integer> coins = new ArrayList<Integer>();
		addCoins(coins, 1, 1, 1, 1, 1, 1, 0);
		Assert.assertEquals(6, Coins.solution(coins));
	}

}
