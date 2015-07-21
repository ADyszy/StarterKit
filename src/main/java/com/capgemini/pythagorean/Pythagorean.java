package com.capgemini.pythagorean;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a2 + b2 = c2
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

public class Pythagorean {
		
	private static int max(int a, int b) {
		return ( a > b )? a : b;
	}
	
	private static int min(int a, int b) {
		return ( a <= b )? a : b;
	}
	
	public static int greatestCommonDivisor(int x, int y) {
		int a, b, tmp;
		a = max(x, y);
		b = min(x, y);
		while (a%b != 0) {
			tmp = a;
			a = b;
			b = tmp%a;
		}
		return b;
	}
	
	private static boolean isDivisor(int num, int div) {
		return num%div == 0;
	}

	//Euclides method
	public static int pythagoreanTriplet(int sum) {
		// returns -1 if triplet not found
		int a=0, b=0, c=0, A; 
		int maxM = (int) Math.sqrt(sum);
		for (int m=2; m<=maxM; m++){
			if ((sum/2)%m == 0) {
				A = (m%2 == 0)? m+1 : m+2; // A have to be odd
				while (A < 2*m && A <= sum/(2*m)){
					if (isDivisor(sum/(2*m),A) && greatestCommonDivisor(A, m) == 1){
						int d = sum/(2*m*A);
						int n = A-m;
						a = d*(m*m - n*n);
						b = d*2*m*n;
						c = d*(m*m + n*n);  
						return a*b*c;
					}
					A += 2;
				}
			}
		}
		return -1;
	}

}
