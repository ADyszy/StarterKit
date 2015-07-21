package com.capgemini.fibonacci;

public class FibException extends Exception {

	private static final long serialVersionUID = -2115263643294724022L;

	public FibException() {
		super();
	}
	
	public FibException(String msg) {
		super(msg);
	}
}
