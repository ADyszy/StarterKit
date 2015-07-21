package com.capgemini.taxiV2;

public class TaxiUsageSimulator {
	private TaxiSet taxiSet;

	public TaxiUsageSimulator(TaxiSet taxiSet) {
		this.taxiSet = taxiSet;
	}

	public void useTaxiesRandomly() {
		for (Taxi taxi : taxiSet.getTaxies()) {
			taxi.occupied(Math.random() < 0.5);
		}
	}
}
