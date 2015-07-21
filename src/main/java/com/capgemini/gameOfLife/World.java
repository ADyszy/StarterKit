package com.capgemini.gameOfLife;

import java.util.List;

public class World {

	private int xSize;
	private int ySize;
	private List<Cell> cells; 

	public int getxSize() {
		return xSize;
	}

	public int getySize() {
		return ySize;
	}

	public World(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.cells = Cell.createCellList(this.xSize, this.ySize);
	}

	public List<Cell> getCells() {
		return cells;
	}
}
