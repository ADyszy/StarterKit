package com.capgemini.gameOfLife;

import java.util.ArrayList;
import java.util.List;

public class CellListPositioner {

	private int x_Bound;
	private int y_Bound;
	private int positionIndex;
	private Position position;

	enum Directions {
		NORTH(0, -1), SOUTH(0, 1), EAST(1, 0), WEST(-1, 0), NORTH_WEST(-1, -1), NORTH_EAST(1, -1), 
		SOUTH_WEST(-1, 1), SOUTH_EAST(1, 1),;

		final int x;
		final int y;

		private Directions(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public CellListPositioner(int xBound, int yBound, int positionIndex) {
		setBounds(xBound, yBound);
		setPositionIndex(positionIndex);
		calculateIndexToXY();
	}

	private void setPositionIndex(int indexInList) {
		this.positionIndex = indexInList;
	}

	private void calculateIndexToXY() {
		this.position = convertIndexToPosition(positionIndex);
	}

	Position convertIndexToPosition(int index) {
		int xPosition = (index) % x_Bound;
		int yPosition = (int) (Math.floor((double) (index) / x_Bound));
		return new Position(xPosition, yPosition);
	}

	int convertXYToIndex(int x, int y) {
		return y * (x_Bound) + x;
	}

	public int getPositionIndex() {
		return positionIndex;
	}

	private void setBounds(int xBound, int yBound) {
		x_Bound = xBound;
		y_Bound = yBound;
	}

	public List<Integer> getNeighborIndexes() {
		List<Integer> neighbors = new ArrayList<Integer>();
		int newX, newY;
		for (Directions direction : Directions.values()) {
			newX = position.getXPosition() + direction.x;
			newY = position.getYPosition() + direction.y;
			if (inBounds(newX, newY))
				neighbors.add(convertXYToIndex(newX, newY));
		}
		return neighbors;
	}

	public int getPositionX() {
		return this.position.getXPosition();
	}

	public int getPositionY() { 
		return this.position.getYPosition();
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(int xPosition, int yPosition) {
		this.position.setPosition(xPosition, yPosition);
	}

	private boolean inBounds(int x, int y) {
		return (x >= 0 && x < x_Bound && y >= 0 && y < y_Bound);
	}

}
