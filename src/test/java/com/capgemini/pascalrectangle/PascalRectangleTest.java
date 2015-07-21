package com.capgemini.pascalrectangle;

import org.junit.Assert;
import org.junit.Test;

public class PascalRectangleTest {

	@Test
	public void shouldGive6() throws InvalidArgumentsException {
		Assert.assertEquals(6, PascalRectangle.iterativePascal(2, 4));
	}

	@Test
	public void shouldGive35() throws InvalidArgumentsException {
		Assert.assertEquals(35, PascalRectangle.iterativePascal(3, 7));
	}

	@Test(expected = InvalidArgumentsException.class)
	public void shouldInvalidArgumentException() throws InvalidArgumentsException {
		Assert.assertEquals(35, PascalRectangle.iterativePascal(-1, 7));
	}

	@Test(expected = InvalidArgumentsException.class)
	public void shouldInvalidArgumentException2() throws InvalidArgumentsException {
		Assert.assertEquals(35, PascalRectangle.iterativePascal(-1, -7));
	}

	@Test(expected = InvalidArgumentsException.class)
	public void shouldInvalidArgumentException4() throws InvalidArgumentsException {
		Assert.assertEquals(35, PascalRectangle.iterativePascal(1, -7));
	}

	@Test(expected = InvalidArgumentsException.class)
	public void shouldInvalidArgumentException3() throws InvalidArgumentsException {
		Assert.assertEquals(35, PascalRectangle.iterativePascal(9, 2));
	}

	@Test(expected = InvalidArgumentsException.class)
	public void shouldInvalidArgumentExceptionForRecursivePascal() throws InvalidArgumentsException {
		Assert.assertEquals(35, PascalRectangle.recursivePascal(-1, 7));
	}
	
	@Test(expected = InvalidArgumentsException.class)
	public void shouldInvalidArgumentExceptionForRecursivePascal2() throws InvalidArgumentsException {
		Assert.assertEquals(35, PascalRectangle.recursivePascal(-1, -7));
	}
	
	@Test(expected = InvalidArgumentsException.class)
	public void shouldInvalidArgumentExceptionForRecursivePascal4() throws InvalidArgumentsException {
		Assert.assertEquals(35, PascalRectangle.recursivePascal(1, -7));
	}
	
	@Test(expected = InvalidArgumentsException.class)
	public void shouldInvalidArgumentExceptionForRecursivePascal3() throws InvalidArgumentsException {
		Assert.assertEquals(35, PascalRectangle.recursivePascal(9, 2));
	}

	@Test
	public void shouldGive35Also() throws InvalidArgumentsException {
		Assert.assertEquals(35, PascalRectangle.recursivePascal(3, 7));
	}

}
