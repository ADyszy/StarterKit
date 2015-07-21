package com.capgemini.fibonacci;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void shouldFib2584() throws FibException{
		long a = Fibonacci.fib(18);
		assertEquals(2584,a);
	} 
	
	@Test
	public void shouldFib144() throws FibException{
		assertEquals(144,Fibonacci.fib(12));
	}

	@Test
	public void shouldFib1() throws FibException{
		assertEquals(1,Fibonacci.fib(1));
	}

	@Test
	public void shouldFibAlso1() throws FibException{
		assertEquals(1,Fibonacci.fib(2));
	}

	@Test(expected = FibException.class)
	public void shouldFibException() throws FibException{
		assertEquals(1,Fibonacci.fib(-1));
	} 

}
