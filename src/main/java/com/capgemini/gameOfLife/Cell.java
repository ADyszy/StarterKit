package com.capgemini.gameOfLife;

import java.util.ArrayList;
import java.util.List;

public class Cell {
	private CellListPositioner positioner;

	public CellListPositioner getPositioner() {
		return positioner;
	}

	private List<Cell> neighborhood;
	private boolean alive = false;
	private boolean aliveAtNextStep = false;

	public Cell(CellListPositioner positioner) {
		this.positioner = positioner;
		this.neighborhood = null;
	}

	public void alive(boolean isAlive) {
		this.alive = isAlive; 
	}

	public boolean checkIfAliveAtNextStep() {
		int neighborCount = numOfNeighborsAlive();
		if (alive) {
			if (neighborCount == 2 || neighborCount == 3)
				return aliveAtNextStep = true;
			return aliveAtNextStep = false;
		}
		if (neighborCount == 3) {
			return aliveAtNextStep = true;
		}
		return aliveAtNextStep = false;
	}

	// TODO: Handle neighbor == null situation
	private int numOfNeighborsAlive() {
		int count = 0; 
		for (Cell cell : neighborhood)
			if (cell.isAlive())
				count++;
		return count;
	}

	public boolean isAlive() {
		return alive;
	}

	// TODO: Handle neighbor == null situation
	public List<Cell> getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(List<Cell> neighborhood) {
		this.neighborhood = neighborhood;
	}

	private void adaptToCellList(List<Cell> cellList) {
		// TODO: Handle empty cellList
		List<Cell> neighbors = new ArrayList<Cell>();
		if (cellList.isEmpty())
			return;
		List<Integer> indiceList = positioner.getNeighborIndexes();
		for (Integer i : indiceList)
			neighbors.add(cellList.get(i));
		setNeighborhood(neighbors);
	}

	// Achtung: Must use to create a cell list.
	public static List<Cell> createCellList(int xSize, int ySize) {
		List<Cell> cellList = new ArrayList<Cell>();
		for (int i = 0; i < xSize * ySize; i++)
			cellList.add(new Cell(new CellListPositioner(xSize, ySize, i)));
		for (Cell cell : cellList)
			cell.adaptToCellList(cellList);
		return cellList;
	}

	public void update() {
		alive = aliveAtNextStep;
		aliveAtNextStep = false;
	}

	@Override
	public String toString() {
		return "index: " + positioner.getPositionIndex() + ((alive) ? " 1" : " 0");
	}
}
