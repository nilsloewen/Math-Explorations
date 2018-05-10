/*
package Math_Tools;

import java.math.BigInteger;
import java.math.*;
import java.io.*;

public class GCD {

	public static void main(String[] args) {
		int gcd = 0;
		while(gcd != 1) {
		int a = (int)(Math.random() * Integer.MAX_VALUE);
		int m = (int)(Math.random() * Integer.MAX_VALUE);
		 gcd = findGCD(a, m);
	
			System.out.println("\n gcd(" + a + ", " + m + ") = " + gcd);
			if (gcd == 1) { System.out.println("\n inverse of a = " + findInverse(a, m));}
		}
	}
	
	 public static int findGCD(int x, int y) {
		
		if (x == y) { return x;}
		
		int gcd = 1,
			m = 0, 
			a = 0, 
			quotient = 0, 
			remainder = 0, 
			previousRemainder = 0;
			
		// Print formula m = a(q) + r
		System.out.printf("%n Euclidean Algorithm:");
		System.out.printf("%n %-10s = %-10s * (%-8s) + %-10s", "m", "a", "quotient", "remainder");
		System.out.printf("%n              THEN");
		System.out.printf("%n %-10s = %-10s * (%-8s) + %-10s", "a", "r", "quotient", "remainder'");
		System.out.printf("%n ------------------------------------------------- %n");
	
		// Assign m & a
		if (x > y) { m = x; a = y;} 
		else 	   { a = x; m = y;}

		// Rounds
		while (gcd > 0) {
			
			quotient = (int)(m / a);
			remainder = m % a;
		
			System.out.printf(" %-10d = %-10d * ( %-6d ) + %-10d \n", m, a, quotient, remainder);

			if      (remainder >= 1) { gcd = remainder;}
			else if (remainder == 0) { break;}

			m = a;
			a = remainder;
			previousRemainder = remainder;
		}
		
		return gcd;
	 }


	 public static int findInverse(int x, int y) {

		if (x == y) { return -1;}

		int gcd = 1,
			m, mAlg1 = 1, mAlg2 = 0, mAlg3 = 0,
			a, aAlg1 = 0, aAlg2 = 1, aAlg3 = 0,
			quotient = 0, 
			remainder = 0, 
			previousRemainder = 0,
			count = 0;
			
		System.out.printf("%n findInverse");
		// Print formula m = a(q) + r

		System.out.printf("%n Dividend = Divisor * (Quotient) + Remainder %n");
		System.out.println("--------------------------------------------------");
	
		// Assign m & a
		if (x > y) { m = x; a = y;} 
		else 	   { a = x; m = y;}

		Var Dividend1 = new Var (0, 0, m, 1);
		Var Divisor1  = new Var (a, 1, 0, 0);

		quotient  = (int)(Dividend1.getm() / Divisor1.geta());
		remainder =       Dividend1.getm() % Divisor1.geta();
	
		// Rounds
		while (gcd > 0) {
			System.out.printf("%n-"+count+"------------------------------------------------------------");
   
//     Dividend                     = Divisor                   * (Quotient) + Remainder 
// 	   (a * aAlg1) + (m * mAlg1)    = (a * aAlg2) + (m * mAlg2) * (quotient) + remainder
		   System.out.printf("%n- Step 1 - - - - - - -");
		   System.out.printf("%n (%-10s * %-5s) + (%-10s * %-5s) = (%-10s * %-5s) + (%-10s * %-5s) * (quotient) + remainder",
								  "a",   "aAlg1",  "m",  "mAlg1",  "a",   "aAlg2",  "m",  "mAlg2","remainder");
		   System.out.printf("%n (%-10d * %-5d) + (%-10d * %-5d) = (%-10d * %-5d) + (%-10d * %-5d) * (%-8d) + %-5d",
								   a,    aAlg1,     m,     mAlg1,  a,      aAlg2,    m,    mAlg2,    quotient, remainder);


// 	   (a * aAlg1) + (m * mAlg1)    = (a * aAlg2) + (m * mAlg2) * (quotient) + remainder
//											  			mAlg2 = mAlg2 * quotient;
//										   aAlg2 = aAlg2 * quotient;								  

			System.out.printf("%n %68s %-5s = %-5s * %-5s;", " ", "mAlg2", "mAlg2", "quotient");
			System.out.printf("%n %68s %-5s = %-5d * %-5d   = ", " ", "mAlg2", mAlg2, quotient);

			mAlg2 = mAlg2 * quotient;
			
			System.out.printf("%-5d", mAlg2);
			
			System.out.printf("%n %46s %-5s = %-5s * %-5s;", " ", "aAlg2", "aAlg2", "quotient");
			System.out.printf("%n %46s %-5s = %-5d * %-5d  = ", " ", "aAlg2", aAlg2, quotient);				

	  	    aAlg2 = aAlg2 * quotient;								  
			
	  	    System.out.printf("%-5d", aAlg2);
			System.out.printf("%n");

//	   (a          * aAlg1) + (m          * mAlg1) = (a          * aAlg2) + (m          * mAlg2) * (quotient) + remainder
//               		    - (m * mAlg2)                                 - (m * mAlg2)
//                          mAlg3 = mAlg1 - mAlg2;

		   System.out.printf("%n- Move m over - - - -");
		   System.out.printf("%n (%-10s * %-5s) + (%-10s * %-5s) = (%-10s * %-5s) + (%-10s * %-5s) + remainder",
								  "a",   "aAlg1",  "m",  "mAlg1",  "a",   "aAlg2",  "m",  "mAlg2","remainder");
		   System.out.printf("%n (%-10d * %-5d) + (%-10d * %-5d) = (%-10d * %-5d) + (%-10d * %-5d) + %-5d",
								   a,    aAlg1,     m,     mAlg1,  a,      aAlg2,    m,    mAlg2, remainder);
		   System.out.printf("%n %20s - (%-10s * %-5s)", " ", "m", "mAlg2");
		   System.out.printf(" %22s - (%-10s * %-5s)", " ", "m", "mAlg2");
		   System.out.printf("%n %20s mAlg3 = mAlg1 - mAlg2;", " "); 
		   System.out.printf("%n %20s mAlg3 = %-5d - %-5d = ", " ", mAlg1, mAlg2);
		   if (mAlg1 + mAlg2 == 0 && mAlg2 == -1) {
			  mAlg3 = -1;
		   } else if (mAlg1 + mAlg2 == 0 && mAlg2 == 1) {
			   mAlg3 = 1;
		   }
		   else {
			   mAlg3 = mAlg1 - mAlg2;
		   }
           System.out.printf(" %-5d %n", mAlg3);

//	   (a          * aAlg1) + (m          * mAlg1) = (a          * aAlg2) + (m          * mAlg2) * (quotient) + remainder
//	   -(a         * aAlg2)                         -(a          * aAlg2)
//     aAlg3 = aAlg1 - aAlg2;

		   System.out.printf("%n- Move a over - - - - - - -");
 		   System.out.printf("%n (%-10s * %-5s) + (%-10s * %-5s) = (%-10s * %-5s) + remainder",
								  "a",   "aAlg1",  "m",  "mAlg3",  "a",   "aAlg2", "remainder");
		   System.out.printf("%n (%-10d * %-5d) + (%-10d * %-5d) = (%-10d * %-5d) + %-5d",
								   a,    aAlg1,     m,     mAlg3,  a,      aAlg2, remainder);
		   System.out.printf("%n-(%-10s * %-5s)", "a", "aAlg2");
		   System.out.printf(" %23s -(%-10s * %-5s)", " ", "a", "aAlg2");
		   

        System.out.printf("%n%n %-5s = %-5s - %-5s", "aAlg3", "aAlg1", "aAlg2");
        System.out.printf("%n %-5s = %-5d - %-5d = ", "aAlg3", aAlg1, aAlg2);
        aAlg3 = aAlg1 - aAlg2;
        System.out.printf(" %-5d %n", aAlg3);
 
    
			
//	   ((a * aAlg3) + (m * mAlg3) = remainder
		   System.out.printf("%n- - - - - - - -");
	   System.out.printf("%n (%-10s * %-5s) - (%-10s * %-5s) = %-10s",
			                  "a",   "aAlg3",  "m",  "mAlg3", "remainder");
	   System.out.printf("%n (%-10d * %-5d) - (%-10d * %-5d) = %-10d %n",
			                   a,    aAlg3,     m,     mAlg3,  remainder);

	   if ((a * aAlg3) + (m * mAlg3) == remainder) {
		   System.out.println("\n **********SUCCESS");
	   } else {
		   System.out.println("**********Fail");
	   }

	   // RESET FOR NEXT ROUND
//       Dividend = oldDivisor, Divisor = oldRemainder
			m = a;
			mAlg1 = mAlg2;
			aAlg1 = aAlg2; 

			a = remainder;
		    mAlg2 = mAlg3; 
			aAlg2 = aAlg3;


			if (remainder > 1) { 
				quotient = (int)(m / a);
				remainder = m % a;
			}
			else if (remainder == 1) { break;}
			
	
			// Last number before remainder = 0
			previousRemainder = remainder;

			count++;
		}
		
		return aAlg3;
	}
}

class Var {
	private int m, mAlg, a, aAlg;
	
	public Var ( int a, int aAlg, int m, int mAlg) {
		this.m = m;
		this.mAlg = mAlg;
		this.a = a;
		this.aAlg = aAlg;
	}

	public int getm() {
		return m;
	} 
	public int getmAlg() {
		return mAlg;
	} 
	public int getaAlg() {
		return aAlg;
	} 
	public int geta() {
		return a;
	} 
}
*/
/*
	 public static int findInverse(int x, int y) {

		if (x == y) { return -1;}

		int gcd = 1,
			m, mAlg1 = 1, mAlg2 = 0, mAlg3 = 0,
			a, aAlg1 = 0, aAlg2 = 1, aAlg3 = 0,
			quotient = 0, 
			remainder = 0, 
			previousRemainder = 0,
			count = 0;
			
		System.out.printf("%n findInverse");
		// Print formula m = a(q) + r
		System.out.printf("%n %-10s = %-10s * (%-8s) + %-10s \n", 
				             "m",   "a", "quotient", "remainder");
		System.out.println("--------------------------------------------------");
	
		// Assign m & a
		if (x > y) { m = x; a = y;} 
		else 	   { a = x; m = y;}

		quotient = (int)(m / a);
		remainder = m % a;
	
		// Rounds
		while (gcd > 0) {
			System.out.printf("%n-"+count+"------------------------------------------------------------");
//		Dividend = Divisor * (Quotient) + Remainder
   
// 		Dividend = (a * aAlg1) + (m * mAlg1), Divisor = (a * aAlg2) + (m * mAlg2)  

//     Dividend                     = Divisor                   * (Quotient) + Remainder 
// 	   (a * aAlg1) + (m * mAlg1)    = (a * aAlg2) + (m * mAlg2) * (quotient) + remainder
		   System.out.printf("%n- Step 1 - - - - - - -");
		   System.out.printf("%n (%-10s * %-5s) + (%-10s * %-5s) = (%-10s * %-5s) + (%-10s * %-5s) * (quotient) + remainder",
								  "a",   "aAlg1",  "m",  "mAlg1",  "a",   "aAlg2",  "m",  "mAlg2","remainder");
		   System.out.printf("%n (%-10d * %-5d) + (%-10d * %-5d) = (%-10d * %-5d) + (%-10d * %-5d) * (%-8d) + %-5d",
								   a,    aAlg1,     m,     mAlg1,  a,      aAlg2,    m,    mAlg2,    quotient, remainder);


// 	   (a * aAlg1) + (m * mAlg1)    = (a * aAlg2) + (m * mAlg2) * (quotient) + remainder
//											  			mAlg2 = mAlg2 * quotient;
//										   aAlg2 = aAlg2 * quotient;								  

			System.out.printf("%n %68s %-5s = %-5s * %-5s;", " ", "mAlg2", "mAlg2", "quotient");
			System.out.printf("%n %68s %-5s = %-5d * %-5d   = ", " ", "mAlg2", mAlg2, quotient);

			mAlg2 = mAlg2 * quotient;
			
			System.out.printf("%-5d", mAlg2);
			
			System.out.printf("%n %46s %-5s = %-5s * %-5s;", " ", "aAlg2", "aAlg2", "quotient");
			System.out.printf("%n %46s %-5s = %-5d * %-5d  = ", " ", "aAlg2", aAlg2, quotient);				

	  	    aAlg2 = aAlg2 * quotient;								  
			
	  	    System.out.printf("%-5d", aAlg2);
			System.out.printf("%n");

//	   (a          * aAlg1) + (m          * mAlg1) = (a          * aAlg2) + (m          * mAlg2) * (quotient) + remainder
//               		    - (m * mAlg2)                                 - (m * mAlg2)
//                          mAlg3 = mAlg1 - mAlg2;

		   System.out.printf("%n- Move m over - - - -");
		   System.out.printf("%n (%-10s * %-5s) + (%-10s * %-5s) = (%-10s * %-5s) + (%-10s * %-5s) + remainder",
								  "a",   "aAlg1",  "m",  "mAlg1",  "a",   "aAlg2",  "m",  "mAlg2","remainder");
		   System.out.printf("%n (%-10d * %-5d) + (%-10d * %-5d) = (%-10d * %-5d) + (%-10d * %-5d) + %-5d",
								   a,    aAlg1,     m,     mAlg1,  a,      aAlg2,    m,    mAlg2, remainder);
		   System.out.printf("%n %20s - (%-10s * %-5s)", " ", "m", "mAlg2");
		   System.out.printf(" %22s - (%-10s * %-5s)", " ", "m", "mAlg2");
		   System.out.printf("%n %20s mAlg3 = mAlg1 - mAlg2;", " "); 
		   System.out.printf("%n %20s mAlg3 = %-5d - %-5d = ", " ", mAlg1, mAlg2);
		   if (mAlg1 + mAlg2 == 0 && mAlg2 == -1) {
			  mAlg3 = -1;
		   } else if (mAlg1 + mAlg2 == 0 && mAlg2 == 1) {
			   mAlg3 = 1;
		   }
		   else {
			   mAlg3 = mAlg1 - mAlg2;
		   }
           System.out.printf(" %-5d %n", mAlg3);

//	   (a          * aAlg1) + (m          * mAlg1) = (a          * aAlg2) + (m          * mAlg2) * (quotient) + remainder
//	   -(a         * aAlg2)                         -(a          * aAlg2)
//     aAlg3 = aAlg1 - aAlg2;

		   System.out.printf("%n- Move a over - - - - - - -");
 		   System.out.printf("%n (%-10s * %-5s) + (%-10s * %-5s) = (%-10s * %-5s) + remainder",
								  "a",   "aAlg1",  "m",  "mAlg3",  "a",   "aAlg2", "remainder");
		   System.out.printf("%n (%-10d * %-5d) + (%-10d * %-5d) = (%-10d * %-5d) + %-5d",
								   a,    aAlg1,     m,     mAlg3,  a,      aAlg2, remainder);
		   System.out.printf("%n-(%-10s * %-5s)", "a", "aAlg2");
		   System.out.printf(" %23s -(%-10s * %-5s)", " ", "a", "aAlg2");
		   

        System.out.printf("%n%n %-5s = %-5s - %-5s", "aAlg3", "aAlg1", "aAlg2");
        System.out.printf("%n %-5s = %-5d - %-5d = ", "aAlg3", aAlg1, aAlg2);
        aAlg3 = aAlg1 - aAlg2;
        System.out.printf(" %-5d %n", aAlg3);
 
    
			
//	   ((a * aAlg3) + (m * mAlg3) = remainder
		   System.out.printf("%n- - - - - - - -");
	   System.out.printf("%n (%-10s * %-5s) - (%-10s * %-5s) = %-10s",
			                  "a",   "aAlg3",  "m",  "mAlg3", "remainder");
	   System.out.printf("%n (%-10d * %-5d) - (%-10d * %-5d) = %-10d %n",
			                   a,    aAlg3,     m,     mAlg3,  remainder);

	   if ((a * aAlg3) + (m * mAlg3) == remainder) {
		   System.out.println("\n **********SUCCESS");
	   } else {
		   System.out.println("**********Fail");
	   }

	   // RESET FOR NEXT ROUND
//       Dividend = oldDivisor, Divisor = oldRemainder
			m = a;
			mAlg1 = mAlg2;
			aAlg1 = aAlg2; 

			a = remainder;
		    mAlg2 = mAlg3; 
			aAlg2 = aAlg3;


			if (remainder > 1) { 
				quotient = (int)(m / a);
				remainder = m % a;
			}
			else if (remainder == 1) { break;}
			
	
			// Last number before remainder = 0
			previousRemainder = remainder;

			count++;
		} */
/*
/*	// ALGEBRA ----------------------------------
 * 			m = 0, mAlg1 = 0, mAlg2 = 1, mAlg3 = 0,
			a = 0, aAlg1 = 1, aAlg2 = 0, aAlg3 = 0,
	
		Dividend = Divisor * (Quotient) + Remainder
   
 1 		Dividend = (a * aAlg1) + (m * mAlg1), Divisor = (a * aAlg2) + (m * mAlg2)  

       Dividend                     = Divisor                   * (Quotient) + Remainder 
   	   (a * aAlg1) + (m * mAlg1)    = (a * aAlg2) + (m * mAlg2) * (quotient) + remainder

	   (a * 1)     + (m * 0)        = (a * 0 * quotient) + (m * 1 * quotient) + remainder                                  
                                                        mAlg2 = mAlg2 * quotient;
									  aAlg2 = aAlg2 * quotient;
									  
	   (a * aAlg1) + ( 0 )          = (a * aAlg2)        + (m * mAlg2)     + remainder                                  
       			   - (m * mAlg2)                         - (m * mAlg2)
                   [mAlg2 * -1;]
                   mAlg3 = mAlg1 + mAlg2;

       -(a * aAlg2)                  -(a * aAlg2)
       [aAlg2 * -1;]
	   aAlg3 = aAlg1 + aAlg2;	
			
	   ((a * aAlg3) + (m * mAlg3) = remainder
	   
 *2* ------------------------------------------
//       Dividend = oldDivisor, Divisor = oldRemainder
			m = 0; mAlg1 = mAlg2; mAlg2 = mAlg3; // mAlg3 = mAlg3;
			a = 0; aAlg1 = aAlg2; aAlg2 = mAlg3; // aAlg3 = aAlg3;
	
//		Dividend = Divisor * (Quotient) + Remainder
   
// 		Dividend = (a * aAlg1) + (m * mAlg1), Divisor = (a * aAlg2) + (m * mAlg2)  

//     Dividend                     = Divisor                   * (Quotient) + Remainder 
// 	   (a * aAlg1) + (m * mAlg1)    = (a * aAlg2) + (m * mAlg2) * (quotient) + remainder

//     (a * 1)     + (m * 0)        = (a * 0 * quotient) + (m * 1 * quotient) + remainder                                  
                                                        mAlg2 = mAlg2 * quotient;
									  aAlg2 = aAlg2 * quotient;
									  
//	   (a * aAlg1) + ( 0 )          = (a * aAlg2)        + (m * mAlg2)     + remainder                                  
//     			   - (m * mAlg2)                         - (m * mAlg2)
//                 [mAlg2 * -1;]
                   mAlg3 = mAlg1 + mAlg2;

//     -(a * aAlg2)                  -(a * aAlg2)
//     [aAlg2 * -1;]
	   aAlg3 = aAlg1 + aAlg2;	
			
//	   ((a * aAlg3) + (m * mAlg3) = remainder

*/

