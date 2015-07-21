package com.capgemini.gameOfLife;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CellTest {

	private static List<Integer> testArrayList(Integer... args) {
		List<Integer> testList = new ArrayList<Integer>();
		for (Integer integer : args)
			testList.add(integer);
		return testList;
	}

	@Test
	public void cellListShouldHaveSize400() {
		List<Cell> cellList = Cell.createCellList(20, 20);
		Assert.assertEquals(400, cellList.size());
	}

	@Test
	public void shouldHaveParticularNeighbors() {
		boolean flag = true;
		List<Cell> cellList = Cell.createCellList(5, 5);
		List<Cell> neighbors = cellList.get(8).getNeighborhood();
		List<Integer> testList = testArrayList(2, 3, 4, 7, 9, 12, 13, 14);
		for (Cell cell : neighbors) {
			if (!testList.contains(cell.getPositioner().getPositionIndex()))
				flag = false;
		}
		Assert.assertEquals(true, flag);
	}

	@Test
	public void shouldHaveParticularNeighborsInCorner() {
		boolean flag = true;
		List<Cell> cellList = Cell.createCellList(5, 5);
		List<Cell> neighbors = cellList.get(4).getNeighborhood();
		List<Integer> testList = testArrayList(3, 8, 9);
		if (neighbors.size() != testList.size())
			flag = false;
		for (Cell cell : neighbors) {
			if (!testList.contains(cell.getPositioner().getPositionIndex()))
				flag = false;
		}
		Assert.assertEquals(true, flag);
	}

	@Test
	public void shouldHaveParticularNeighborsOnEdge() {
		boolean flag = true;
		List<Cell> cellList = Cell.createCellList(5, 5);
		List<Cell> neighbors = cellList.get(22).getNeighborhood();
		List<Integer> testList = testArrayList(21, 16, 17, 18, 23);
		if (neighbors.size() != testList.size())
			flag = false;
		for (Cell cell : neighbors) {
			if (!testList.contains(cell.getPositioner().getPositionIndex()))
				flag = false;
		}
		Assert.assertEquals(true, flag);
	}

	static void makeCellsAlive(List<Cell> cellList, int... ind) {
		for (int i : ind) {
			cellList.get(i).alive(true);
		}
	}

	static boolean areOnlyCellsWithThisIndexLiving(List<Cell> cellList, int... ind) {
		for (int i = 0; i < cellList.size(); i++) {
			if (cellList.get(i).isAlive()) {
				boolean isOk = false;
				for (int j : ind)
					if (i == j)
						isOk = true;
				if (!isOk)
					return false;
			}
		}
		return true;
	}

	@Test
	public void shouldHaveParticularCellsAlive() {
		List<Cell> cellList = Cell.createCellList(5, 5);
		makeCellsAlive(cellList, 6, 7, 12, 8);
		Assert.assertEquals(true, areOnlyCellsWithThisIndexLiving(cellList, 6, 7, 12, 8));
	}

	private void simulateLiving(List<Cell> cellList) {
		for (Cell cell : cellList)
			cell.checkIfAliveAtNextStep();
		for (Cell cell : cellList)
			cell.update();
	}

	@Test
	public void shouldHaveParticularCellsAliveAfterUpdate() {
		List<Cell> cellList = Cell.createCellList(5, 5);
		makeCellsAlive(cellList, 6, 7, 12, 8);
		simulateLiving(cellList);
		Assert.assertEquals(true, areOnlyCellsWithThisIndexLiving(cellList, 2, 6, 7, 8, 11, 12, 13));
	}

	@Test
	public void shouldHaveParticularCellsAliveAfterSecondUpdate() {
		List<Cell> cellList = Cell.createCellList(5, 5);
		makeCellsAlive(cellList, 6, 7, 12, 8);
		simulateLiving(cellList);
		simulateLiving(cellList);
		Assert.assertEquals(true, areOnlyCellsWithThisIndexLiving(cellList, 1, 2, 3, 11, 13, 17));
	}

}
