package com.capgemini.pascalrectangle;

public class InvalidArgumentsException extends Exception {

	private static final long serialVersionUID = 3219022476526092986L;

	public InvalidArgumentsException() {
		super();
	}

	public InvalidArgumentsException(String msg) {
		super(msg);
	}
}
