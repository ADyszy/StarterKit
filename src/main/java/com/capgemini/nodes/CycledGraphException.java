package com.capgemini.nodes;

public class CycledGraphException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6144264479169047196L;
	public CycledGraphException() {
		super();
	}
	public CycledGraphException(String msg) {
		super(msg);
	}
}
