package com.capgemini.gameOfLife;

public class Position {
	private int xPosition;
	private int yPosition;

	public Position(int xPosition, int yPosition) {
		setXPosition(xPosition);
		setYPosition(yPosition);
	}

	public int getYPosition() {
		return yPosition;
	}

	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getXPosition() {
		return xPosition;
	}

	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public void setPosition(int xPosition, int yPosition) {
		setXPosition(xPosition);
		setYPosition(yPosition);
	}
}

