
public class EuclideanAlgorithm {

	public static void main(String[] args) {
		int gcd = 0;
		while(gcd != 1) {
			int a = (int)(Math.random() * Integer.MAX_VALUE) + 1;
			int m = (int)(Math.random() * Integer.MAX_VALUE) + 1;
			gcd = findGCDAndPrint(a, m);

			System.out.println("\n gcd(" + a + ", " + m + ") = " + gcd);
			
			if (gcd == 1) { 
				System.out.println("\n inverse of a = " + findInverseAndPrint(a, m)); 
			}
		}
	}

	public static int findGCDAndPrint(int x, int y) {

		int gcd = 1,
			m = 0, 
			a = 0, 
			quotient = 0, 
			remainder = 0, 
			previousRemainder = 0;

		// Print formula m = a(q) + r
		System.out.printf("%n Euclidean Algorithm:");
		System.out.printf("%n %-11s = %-11s * (%-11s) + %-11s", "m", "a", "quotient", "remainder");
		System.out.printf("%n              THEN");
		System.out.printf("%n %-11s = %-11s * (%-11s) + %-11s", "a", "r", "quotient'", "remainder'");
		System.out.printf("%n ------------------------------------------------- %n");

		// Assign m & a
		if      (x == y) { return x;}
		else if (x >  y) { m = x; a = y;} 
		else 	         { a = x; m = y;}

		// Rounds
		int round = 1;
		while (gcd > 0) {
			quotient = (int)(m / a);
			remainder = m % a;
			System.out.printf("(%2d) ", round);
			System.out.printf(" %-11d = %-11d * ( %-6d ) + %-11d \n", m, a, quotient, remainder);

			if      (remainder >= 1) { gcd = remainder;}
			else if (remainder == 0) { break;}

			m = a;
			a = remainder;
			previousRemainder = remainder;
			round++;
		}

		return gcd;
	}

	public static int findGCD(int x, int y) {
		int gcd = 1,
			m, a, quotient, remainder, 
			previousRemainder;

		// Assign m & a
		if      (x == y) { return x;}
		else if (x >  y) { m = x; a = y;} 
		else 	         { a = x; m = y;}

		// Rounds
		int round = 1;
		while (gcd > 0) {
			quotient = (int)(m / a);
			remainder = m % a;

			if      (remainder >= 1) { gcd = remainder;}
			else if (remainder == 0) { break;}

			m = a;
			a = remainder;
			previousRemainder = remainder;
			round++;
		}

		return gcd;
	}

	public static int findInverseAndPrint(int x, int y) {
		int gcd       = 1,
			quotient  = 0, 
			remainder = 0,
			count     = 1,
			m, a, M, A;

		System.out.printf("%n findInverseAndPrint Method:");

		// Assign m & a
		if      (x == y) { return -10101010;}
		else if (x >  y) { m = x; M = x; a = y; A = y;} 
		else 	         { a = x; A = x; m = y; M = y;}

		Var dividend = new Var (0, 0, 1, 1);
		Var divisor  = new Var (1, 1, 0, 0);
		Var answer   = new Var (0, 0, 0, 0);

		quotient  = (int)(m / a);
		remainder =       m % a;

		// Rounds
		while (gcd > 0) {
			System.out.printf("%n- Round: "+count+" -");
			System.out.printf("%n--- Run quotient through Divisor ");
			System.out.printf("%n                                                                                                                       ");
			System.out.printf("%n dividend                                                      divisor                                                 "); 
			System.out.printf("%n ((%-11s * %-11s) + (%-11s * %-11s)) = ((%-11s * %-11s) + (%-11s * %-11s)) * (%-8s) + %-9s",
					                "a",    "aAlg",   "m",    "mAlg",     "a",    "aAlg",   "m",    "mAlg", "quotient", "remainder");
			System.out.printf("%n ((%-11d * %-11d) + (%-11d * %-11d)) = ((%-11d * %-11d) + (%-11d * %-11d)) * (%-8d) + %-9d",
					            a, dividend.getaAlg(), m, dividend.getmAlg(), 
				                a,  divisor.getaAlg(), m,  divisor.getmAlg(), quotient, remainder);

			System.out.printf("%n                                                                                                                       ");
			System.out.printf("%n     divisor.setmAlg(    %-11d * %-11d);", divisor.getmAlg(), quotient);

			divisor.setmAlg(divisor.getmAlg() * quotient);

			System.out.printf("%n     divisor.getmAlg() = " + divisor.getmAlg());
			System.out.printf("%n                                                                                                                       ");
			System.out.printf("%n     divisor.setaAlg(    %-11d * %-11d);", divisor.getaAlg(), quotient);

			divisor.setaAlg(divisor.getaAlg() * quotient);

			System.out.printf("%n     divisor.getaAlg() = " + divisor.getaAlg());
			System.out.printf("%n                                                                                                                       ");
			System.out.printf("%n                                                                                                                       ");

			System.out.printf("%n--- Move divisor (m + mAlg) over");
			System.out.printf("%n                                                                                                                       ");
			System.out.printf("%n dividend                                                      divisor                                                 "); 
			System.out.printf("%n ((%-11s * %-11s) + (%-11s * %-11s)) = ((%-11s * %-11s) + (%-11s * %-11s)) + %-9s",
					                "a",    "aAlg",   "m",    "mAlg",     "a",    "aAlg",   "m",    "mAlg", "remainder");
			System.out.printf("%n ((%-11d * %-11d) + (%-11d * %-11d)) = ((%-11d * %-11d) + (%-11d * %-11d)) + %-9d",
					            a, dividend.getaAlg(), m, dividend.getmAlg(), 
				                a,  divisor.getaAlg(), m,  divisor.getmAlg(), remainder);

			System.out.printf("%n                              - (m           * mAlg       )                                 - (m           * mAlg       )");
			System.out.printf("%n                                                                                                                       ");
			System.out.printf("%n      answer.setmAlg(dividend.getmAlg() - divisor.getmAlg());"); 

			answer.setmAlg( dividend.getmAlg() - divisor.getmAlg());

			System.out.printf("%n      answer.getmAlg() = " + answer.getmAlg());
			System.out.printf("%n                                                                                                                     %n");


			pressEnterKeyToContinue();
			System.out.printf("%n--- Move divisor (a + aAlg) - - - - - - -");
			System.out.printf("%n                                                                                                                       ");
			System.out.printf("%n dividend                       answer                         divisor  "); 
			System.out.printf("%n ((%-11s * %-11s) + (%-11s * %-11s)) = ((%-11s * %-11s) + %-9s",
					                "a",    "aAlg",   "m",    "mAlg",     "a",    "aAlg", "remainder");
			System.out.printf("%n ((%-11d * %-11d) + (%-11d * %-11d)) = ((%-11d * %-11d) + %-9d",
					            a, dividend.getaAlg(), m, answer.getmAlg(),     a,  divisor.getaAlg(), remainder);

			System.out.printf("%n -(a           * aAlg       )                                  -(a           * aAlg       )");
			System.out.printf("%n                                                                                                                       ");
			System.out.printf("%n      answer.setaAlg(dividend.getaAlg() - divisor.getaAlg());"); 

			answer.setaAlg( dividend.getaAlg() - divisor.getaAlg());

			System.out.printf("%n      answer.getaAlg() = " + answer.getaAlg());
			System.out.printf("%n                                                                                                                       ");
			System.out.printf("%n                                                                                                                       ");

			if (answer.getaAlg() == 0) { answer.setaAlg(1);}
			if (answer.getmAlg() == 0) { answer.setmAlg(1);}

			System.out.printf("%n---");
			System.out.printf("%n answer                        answer                                                                               "); 
			System.out.printf("%n (%-11s * %-11s) + (%-11s * %-11s) = %-9s",
					                "a",    "aAlg",   "m",    "mAlg",   "remainder");
			System.out.printf("%n (%-11d * %-11d) + (%-11d * %-11d) = %-9d",
					            a, answer.getaAlg(), m, answer.getmAlg(), remainder);
			System.out.printf("%n ");
			System.out.printf("%n A & M = original inputs");
			System.out.printf("%n answer                        answer                                                                               "); 
			System.out.printf("%n (%-11s * %-11s) + (%-11s * %-11s) = %-9s",
					                "A",    "aAlg",   "M",    "mAlg",   "remainder");
			System.out.printf("%n (%-11d * %-11d) + (%-11d * %-11d) = %-9d",
					            A, answer.getaAlg(), A, answer.getmAlg(), remainder);
			System.out.printf("%n ");

			// RESET FOR NEXT ROUND
			m = a;
			a = remainder;
			dividend.setmAlg (divisor.getmAlgF());
			dividend.setaAlg (divisor.getaAlgF());
		 	 divisor.setmAlg ( answer.getmAlg() );
		 	 divisor.setmAlgF( answer.getmAlg() );
			 divisor.setaAlg ( answer.getaAlg() );
			 divisor.setaAlgF( answer.getaAlg() );

			if (remainder > 1) { 
				quotient  = (int)(m / a);
				remainder =       m % a;
			}
			else 
			if (remainder == 1) { 
				break;
			}

			count++;
			pressEnterKeyToContinue();
		}

		return answer.getaAlg();
	}


	public static int findInverse(int x, int y) {

		int gcd = 1,
			m, a, M, A,
			quotient  = 0, 
			remainder = 0;

		// Assign m & a
		if      (x == y) { return -1;}
		else if (x >  y) { m = x; M = x; a = y; A = y;} 
		else 	         { a = x; A = x; m = y; M = y;}

		//  Var ( int aAlg, int aAlgF, int mAlg, int mAlgF) {
		Var dividend = new Var (0, 0, 1, 1);
		Var divisor  = new Var (1, 1, 0, 0);
		Var answer   = new Var (0, 0, 0, 0);

		quotient  = (int)(m / a);
		remainder =       m % a;

		// Rounds
		while (gcd > 0) {
			divisor.setmAlg(divisor.getmAlg() * quotient);
			divisor.setaAlg(divisor.getaAlg() * quotient);

			answer.setmAlg( dividend.getmAlg() - divisor.getmAlg());
			answer.setaAlg( dividend.getaAlg() - divisor.getaAlg());

			if (answer.getaAlg() == 0) { answer.setaAlg(1);}
			if (answer.getmAlg() == 0) { answer.setmAlg(1);}

			// RESET FOR NEXT ROUND
			m = a;
			a = remainder;
			dividend.setmAlg (divisor.getmAlgF());
			dividend.setaAlg (divisor.getaAlgF());
		 	 divisor.setmAlg ( answer.getmAlg() );
		 	 divisor.setmAlgF( answer.getmAlg() );
			 divisor.setaAlg ( answer.getaAlg() );
			 divisor.setaAlgF( answer.getaAlg() );

			if (remainder > 1) { 
				quotient  = (int)(m / a);
				remainder =       m % a;
			}
			else 
			if (remainder == 1) { 
				break;
			}
		}
		return answer.getaAlg();
	}

	private static void pressEnterKeyToContinue()
	{ 
		System.out.println("Press Enter key to continue...");
		try {
			System.in.read();
		}  
		catch(Exception e){
		}  
	}
}

class Var {
	private int mAlg, mAlgF, aAlg, aAlgF;

	public Var ( int aAlg, int aAlgF, int mAlg, int mAlgF) {
		this.aAlg  = aAlg;
		this.aAlgF = aAlgF;
		this.mAlg  = mAlg;
		this.mAlgF = mAlgF;
	}

	public void setaAlg (int a) { this.aAlg  = a;} 
	public void setmAlg (int a) { this.mAlg  = a;} 
	public void setaAlgF(int a) { this.aAlgF = a;} 
	public void setmAlgF(int a) { this.mAlgF = a;} 

	public int getaAlg()  { return aAlg;} 
	public int getmAlg()  { return mAlg;} 
	public int getaAlgF() { return aAlgF;} 
	public int getmAlgF() { return mAlgF;} 
}