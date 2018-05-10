import java.io.*;
import java.util.*;

public class primesSQRT {

	static File primes = new File("primes.txt");

	public static void main(String[] args) {
		try {
			PrintWriter printWriter = new PrintWriter(primes);
			printWriter.print(1);

			// Test these Numbers 1 ... 100
			int limit = 100;
			for (int i = 1; i < limit + 1; i++) {

				boolean isPrime = isPrimeSQRT(i);
				if (isPrime) {
					printWriter.print(" Prime");
					System.out.print(i + " Prime");
				}
				printWriter.println("");
				System.out.println("");
			}

			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
			e.printStackTrace();
		}
	}

	public static boolean isPrimeSQRT(int n) throws FileNotFoundException {
		Scanner scanner = new Scanner(primes);

		int sqrtN = (int)Math.sqrt(n);
		boolean isPrime = true;
		
		while (scanner.hasNextLine()) {
			int temp = scanner.nextInt();
			System.out.println("nextInt:" + temp);
			if (n % scanner.nextInt() != 0) {
				isPrime = false;
			}
		}

		return isPrime;
	}
}

