package com.capgemini.taxiV2;

public class Taxi {
	private Position position;
	private boolean free = true;
	private static int lastId = 0;
	private int id;

	public Taxi(Position position) {
		this.position = position;
		id = autoincrementId();
	}

	private static int autoincrementId() {
		return ++lastId;
	}
	
	public static void zeroId(){
		lastId = 0;
	}

	public boolean isFree() {
		return free;
	}

	public void occupied(boolean isOccupied) {
		free = isOccupied;
	}

	public void move(int shiftX, int shiftY) {
		moveOnX(shiftX);
		moveOnY(shiftY);
	}

	private void moveOnY(int shiftY) {
		position.setYPosition(position.getYPosition() + shiftY);
	}

	private void moveOnX(int shiftX) {
		position.setXPosition(position.getXPosition() + shiftX);
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String toString() {
		return new String("taxi no." + id + " on position: " + position);
	}

	public int getId() {
		return id;
	}
}
