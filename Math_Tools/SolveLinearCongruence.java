import java.util.InputMismatchException;
import java.util.Scanner;

public class SolveLinearCongruence {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int a = 0, k = 0, m =0;

		System.out.println(" Linear Congruence Solver * Limit Numbers < Integer.MAX_VALUE = " + Integer.MAX_VALUE);
		System.out.println(" ------------------------                                                           ");
		System.out.println("                                                                                    ");

		boolean isInputValid = false;
		while (!isInputValid) {
			// Take Input from Keyboard
			System.out.println(" Format: ax = k (mod m)                                                             ");
			System.out.println("                                                                                    ");
			System.out.print  (" Enter as String: ");

			try {
				String input = keyboard.nextLine();

				// Parse String
				a = Integer.parseInt(input.substring(0, input.indexOf('x')));
				k = Integer.parseInt(input.substring(input.indexOf('=') + 2, input.indexOf('(') - 1));
				m = Integer.parseInt(input.substring(input.indexOf('d') + 2, input.indexOf(')')));
				isInputValid = true;
				if (k >= m) {
					System.out.println(" ¡Error! k cannot be larger than m");
					isInputValid = false;
				}
			}
			catch (InputMismatchException e) {
				System.out.println(" ¡Error! Please try new input!");
			}
			catch (StringIndexOutOfBoundsException e) {
				System.out.println(" ¡Error! Please try new input!");
			}
		}

		int[] inversesArray = findInverseAndPrint(a, k, m);
		if (inversesArray[0] == 0) {
			System.out.println(" There are no answers for x.");
		} 
		else {
			for (int e : inversesArray) {
				System.out.println(" x = " + e);
			}
		}

		keyboard.close();
	}

	public static int[] findInverse(int a, int k, int m) {
		int x, firstGCD, gcd, inverse;
		int[] inversesArray;
		boolean kDividesGCD;

		//find gcd(a, m)
		gcd = EuclideanAlgorithm.findGCD(a, m);
		firstGCD = gcd;
		inversesArray = new int[gcd];

		// Test k | gcd
		kDividesGCD = (k % gcd == 0) ? true: false;

		if (!kDividesGCD) {
			return inversesArray;
		}
		else
		{
			// reduce original equation by gcd
			a = a / gcd; k = k/gcd; m = m / gcd;

			gcd = EuclideanAlgorithm.findGCD(a, m);	
			inverse = EuclideanAlgorithm.findInverse(a, m);
			x = inverse * k;

			// reduce x (mod m)
			if (x > 0) {
				while (x > 0) {
					x = x - m;
				}
			} 
			else
				if (x <= 0) {
					while (x < 0) {
						x = x + m;
					}
				}

			// find all inverses 0 < i < original m
			for (int i = 0; i < firstGCD; i++) {
				inversesArray[i] = x + m * i;
			}
		}
		return inversesArray;
	}

	public static int[] findInverseAndPrint(int a, int k, int m) {
		int aFirst, kFirst, mFirst, x, firstGCD, gcd, inverse;
		int[] inversesArray;
		boolean kDividesGCD;
		// store input for final printout
		aFirst = a; kFirst = k; mFirst = m;

		System.out.printf("%n                                                            ");
		System.out.printf("%n   Solving for x of " + a + "x = " + k + " (mod " + m + ")%n");

		gcd = EuclideanAlgorithm.findGCD(a, m);
		System.out.printf("%n                    a            m                          ");
		System.out.printf("%n     1. Finding gcd(%-11d, %-11d) = %-1d", a, m, gcd         );
		System.out.printf("%n					                                         ");	

		// Test k | gcd 
		kDividesGCD = ( k % gcd == 0) ? true: false;

		// Store gcd for final printout
		firstGCD = gcd;

		inversesArray = new int[gcd];

		System.out.printf("%n        If gcd != 1...                                      ");	
		System.out.printf("%n					                                         ");	
		System.out.print ("\n          Test if gcd divides k:   ** if (k % gcd == 0 )    ");
		System.out.printf("%n                          gcd   k                           ");	
		System.out.printf("%n                  %11d | %-11d = %-1s", gcd, k, kDividesGCD  );
		System.out.printf("%n					                                         ");	
		System.out.printf("%n            true : There are %1d answers for x.", gcd        );
		System.out.printf("%n            false: There are No Answers for x."              );
		if (!kDividesGCD)
			return inversesArray;
		System.out.printf("%n					                                         ");	
		System.out.printf("%n		   If gcd > 1, Divide a, k, and m by gcd             ");	

		a = a / gcd; k = k/gcd; m = m / gcd;
		gcd = EuclideanAlgorithm.findGCD(a, m);	

		System.out.printf("%n					                                         ");	
		System.out.printf("%n            Now solving for x of " + a + "x = " + k + " (mod " + m + ")%n");
		System.out.printf("%n            Finding new gcd(%-11d, %-11d) = %-1d", a, m, gcd);
		System.out.printf("%n					                                        ");	

		if (kDividesGCD) {
			inverse = EuclideanAlgorithm.findInverse(a, m);
			System.out.printf("%n					                                        ");	
			System.out.printf("%n      ... finding inverse of a ...  ");
			System.out.printf("%n      inverse of a (a`) = %-1d", inverse);
			System.out.printf("%n					                                        ");	
			System.out.printf("%n    Therefore (a`)(a)x = (a`)k (mod m) ", inverse);
			System.out.printf("%n					                                        ");	
			System.out.printf("%n              %-11s   %-11s     = %-11s   %-11s      %-11s  ", "a`", "a", "a`", "k", "m");
			System.out.printf("%n    Therefore %-11d * %-11d * x = %-11d * %-11d (mod %-11d) ", inverse, a, inverse, k, m);

			x = inverse * k;
			System.out.printf("%n %40s x = %-11d (mod %-1d) ", " ", x, m);
			if (x > 0) {
				while (x - m > 0) {
					x = x - m;
				}
			} 
			else
			{
				while (x < 0) {
					x = x + m;
				}
			}
			System.out.printf("%n Reduce x Modulo m ... ");	
			System.out.printf("%n %40s x = %-11d (mod %-1d) ", " ", x, m);
			System.out.printf("%n					                                        ");	
			System.out.printf("%n  Solved for x of " + aFirst + "x = " + kFirst + " (mod " + mFirst + ")%n");
			System.out.printf("%n  Answers for x are: ");

			if (firstGCD == 1 ) {
				System.out.printf("%n       x = %1d ", x);
			}
			else {
				for (int i = 0; i < firstGCD; i++) {
					System.out.printf("%n       x = %1d + %1d * %1d = %1d ", x, i, m, (x + m*i));
					inversesArray[i] = x + m*i;
				}
			}
		}

		return inversesArray;
	}
}