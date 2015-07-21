package com.capgemini.taxiV2;

import java.util.ArrayList;
import java.util.List;

public class TaxiesInitialiser {
	List<Taxi> taxies = new ArrayList<Taxi>();

	public TaxiesInitialiser(List<Position> positions) {
		for (Position position : positions) {
			taxies.add(new Taxi(position));
		}
	}

	List<Taxi> getTaxies() {
		return this.taxies;
	}
}
