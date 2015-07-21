package com.capgemini.pascalrectangle;

/**
 * Created by ldrygala on 2015-01-23. 0 1 1 1 1 2 1 2 1 3 1 3 3 1 4 1 4 6 4 1 5
 * 1 5 10 10 5 1 6 1 6 15 20 15 6 1 7 1 7 21 35 35 21 7 1 8 1 8 28 56 70 56 28 8
 * 1 9 1 9 36 84 126 126 84 36 9 1
 */

public class PascalRectangle {

	public static long iterativePascal(int c, int r) throws InvalidArgumentsException {
		if (c > r)
			throw new InvalidArgumentsException("'c' more than 'r'.");
		if (c < 0 || r < 0)
			throw new InvalidArgumentsException("Negative argument exception");
		int[][] result = new int[r + 1][r + 1];
		r++;
		c++;
		for (int ir = 0; (ir < r); ir++)
			for (int ic = 0; ic <= ir; ic++) {
				if ((ic == 0) || (ir == ic))
					result[ir][ic] = 1;
				else
					result[ir][ic] = result[ir - 1][ic] + result[ir - 1][ic - 1];
			}
		return result[r - 1][c - 1];
	}

	public static long recursivePascal(int c, int r) throws InvalidArgumentsException {
		if (c > r)
			throw new InvalidArgumentsException("'c' more than 'r'.");
		if (c < 0 || r < 0)
			throw new InvalidArgumentsException("Negative argument exception");
		if (c == 0 || r == c)
			return 1;
		return recursivePascal(c, r - 1) + recursivePascal(c - 1, r - 1);
	}

}
