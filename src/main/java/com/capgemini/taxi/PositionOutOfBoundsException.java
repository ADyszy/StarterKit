package com.capgemini.taxi;

public class PositionOutOfBoundsException extends Exception {

	private static final long serialVersionUID = 1157193265111897984L;

	public PositionOutOfBoundsException(String msg) {
		super(msg);
	}

	public PositionOutOfBoundsException() {
		super();
	}

}
