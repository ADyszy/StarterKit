package com.capgemini.gameOfLife;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CellListPositionerTest {

	private List<Integer> testArrayList(Integer... args) {
		List<Integer> testList = new ArrayList<Integer>();
		for (Integer integer : args)
			testList.add(integer);
		return testList;
	}

	@Test 
	public void shouldGiveXEqual3() {
		CellListPositioner clp = new CellListPositioner(5, 5, 8);
		Assert.assertEquals(3, clp.getPositionX());
	}

	@Test
	public void shouldGiveYEqual1() {
		CellListPositioner clp = new CellListPositioner(5, 5, 8);
		Assert.assertEquals(1, clp.getPositionY());
	}

	@Test
	public void shouldGiveIndexEqual8() {
		CellListPositioner clp = new CellListPositioner(5, 5, 21);
		Assert.assertEquals(8, clp.convertXYToIndex(3, 1));
	}

	@Test
	public void shouldGiveParticularNeighbors() {
		CellListPositioner clp = new CellListPositioner(5, 5, 8);
		List<Integer> testList = testArrayList(2, 3, 4, 7, 9, 12, 13, 14);
		Collections.sort(testList);
		List<Integer> testedList = clp.getNeighborIndexes();
		Collections.sort(testedList);
		Assert.assertEquals(true, testList.equals(testedList));
	}

	@Test
	public void shouldGiveParticularNeighborsInCorner() {
		CellListPositioner clp = new CellListPositioner(5, 5, 0);
		List<Integer> testList = testArrayList(5, 6, 1);
		Collections.sort(testList);
		List<Integer> testedList = clp.getNeighborIndexes();
		Collections.sort(testedList);
		Assert.assertEquals(true, testList.equals(testedList));
	}

	@Test
	public void shouldGiveParticularNeighborsOnTheEdge() {
		CellListPositioner clp = new CellListPositioner(5, 5, 14);
		List<Integer> testList = testArrayList(9, 8, 13, 18, 19);
		Collections.sort(testList);
		List<Integer> testedList = clp.getNeighborIndexes();
		Collections.sort(testedList);
		Assert.assertEquals(true, testList.equals(testedList));
	}

}
