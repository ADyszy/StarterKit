package com.capgemini.taxi;

import java.util.ArrayList;
import java.util.List;

public class CitySpace {

	private List<Taxi> taxies = new ArrayList<Taxi>();
	private int xSize;
	private int ySize;

	public CitySpace(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
	}

	public int getxSize() {
		return xSize;
	}

	public int getySize() {
		return ySize;
	}

	public void addTaxiToCitySpace(Taxi taxi) {
		taxies.add(taxi);
	}

	public List<Taxi> getTaxies() {
		return taxies;
	}

	public void setTaxies(List<Taxi> taxies) {
		this.taxies = taxies;
	}

}
