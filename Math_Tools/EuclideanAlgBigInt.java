import java.math.BigInteger;

public class EuclideanAlgBigInt {

	public static void main(String[] args) {
		BigInteger gcd = new BigInteger("0");
		BigInteger x = new BigInteger(Long.toString((long)(Math.random() * Long.MAX_VALUE)));
		BigInteger y = new BigInteger(Long.toString((long)(Math.random() * Long.MAX_VALUE)));

		BigInteger a = x.multiply(y);
		BigInteger m = y.multiply(x);
		BigInteger test1 = new BigInteger(Long.toString(Long.MAX_VALUE));
		BigInteger test2 = test1.add(new BigInteger("1"));

		BigInteger inverse = findInverseBig(test1, test2);
		System.out.println(inverse.toString());

		int count = 1;
		while (gcd.toString() != "1") {
			x = x.add(new BigInteger(Long.toString(Long.MAX_VALUE)));
			y = x.add(new BigInteger("1"));

			a = x;
			m = y;

		//	System.out.println("a = " + a.toString());
		//	System.out.println("m = " + m.toString());

			gcd = findGCDBigInt(a, m);
			System.out.println("Tries: " + count);
			count++;
		}

		System.out.println("My       gcd(" + a.toString() + ", " + m.toString() + ") = " + gcd.toString());
		System.out.println("BigInt's gcd(" + a.toString() + ", " + m.toString() + ") = " + m.gcd(a));
	}

	public static BigInteger findGCDBigInt(BigInteger x, BigInteger y) {
		BigInteger gcd = new BigInteger("10");
		BigInteger m, a, quotient, remainder, 
		previousRemainder = new BigInteger("9");

		// Assign m & a
		if      (x.equals(y)) { return x;}
		else if (x.compareTo(y) == 1) { m = x; a = y;} 
		else 	         { a = x; m = y;}

		// Rounds
		int round = 1;
		while (gcd.toString().compareTo("1") > 0) {
			quotient = m.divide(a);
			remainder = m.mod(a);

			//System.out.println(round + ": m:" + m.toString() + " = (a:" + a.toString() + " * q:" + quotient.toString() + ") + r:" + remainder.toString());

			m = a;
			a = remainder;
			gcd = remainder;

			if (gcd.toString() == "0") {

				return previousRemainder;
			}
			previousRemainder = remainder;

			round++;
		}
		
		return gcd;
	}


	public static BigInteger findInverseBig(BigInteger x, BigInteger y) {
		BigInteger gcd = new BigInteger("1");
		BigInteger m, a, M, A, 
			dividend_m_Alg, dividend_a_Alg = null, 
			dividend_m_AlgF, dividend_a_AlgF, 
			divisor_m_Alg = null, divisor_a_Alg, 
			divisor_m_AlgF, divisor_a_AlgF, 
			answer_m_Alg, answer_a_Alg = null, 
			answer_m_AlgF, answer_a_AlgF, 
			quotient, remainder; 
		//Alg is algebraic coefficient of m AlgF is to store the AlgFirst of round

		// Assign m & a
		if      (x.equals(y))		  { return x;}
		else if (x.compareTo(y) == 1) { m = x; M = x; a = y; A = y;} 
		else 	 			          { a = x; A = x; m = y; M = y;}

		dividend_m_Alg = new BigInteger("1");
		dividend_m_AlgF = new BigInteger("1");
		divisor_a_Alg = new BigInteger("1");
		divisor_a_AlgF = new BigInteger("1");

		quotient  = m.divide(a);
		remainder = m.mod(a);

		// Rounds
		while (gcd.compareTo(new BigInteger("0")) == 1) {
			divisor_m_Alg = divisor_m_Alg.multiply(quotient);
			divisor_a_Alg = divisor_a_Alg.multiply(quotient);

			answer_m_Alg = dividend_m_Alg.subtract(divisor_m_Alg);
			answer_a_Alg = dividend_a_Alg.subtract(divisor_a_Alg);

			if (answer_a_Alg.equals(new BigInteger("0"))) { answer_a_Alg = new BigInteger("1");}
			if (answer_m_Alg.equals(new BigInteger("0"))) { answer_a_Alg = new BigInteger("1");}

			// RESET FOR NEXT ROUND
			m = a;
			a = remainder;
			dividend_m_Alg  = divisor_m_Alg;
			dividend_a_Alg  = divisor_a_Alg;
			 divisor_m_Alg  = answer_m_Alg;
			 divisor_m_AlgF = answer_m_Alg;
			 divisor_a_Alg  = answer_a_Alg;
			 divisor_a_AlgF = answer_a_Alg;

			if (remainder.compareTo(new BigInteger("1")) == 1) { 
				quotient  = m.divide(a);
				remainder = m.mod(a);
			}
			else 
			if (remainder.equals(new BigInteger("1"))) { 
				break;
			}
		}

		if (answer_a_Alg.equals(A.modInverse(M))){
			System.out.println("Success!");
		} else {
			System.out.println("FAIL");
		}

		return answer_a_Alg;
	}

}

	/*
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
	private static void pressEnterKeyToContinue()
	{ 
		System.out.println("Press Enter key to continue...");
		try {
			System.in.read();
		}  
		catch(Exception e){
		}  
	}


class VarBigInt {
	private int mAlg, mAlgF, aAlg, aAlgF;

	public VarBigInt ( int aAlg, int aAlgF, int mAlg, int mAlgF) {
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
	 */