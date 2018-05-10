import java.io.*;
import java.util.*;

public class primes {

	static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args) {

		File primeStorage = new File("primes.txt");
		try {
			PrintWriter out = new PrintWriter(primeStorage);

			primes.add (2);

			Scanner      in = new Scanner    (primeStorage);
			boolean isPrime = false;
			int lineCount = 0;	

			int goal = Integer.MAX_VALUE;
			System.out.println("Goal: " + goal);
			long start = System.currentTimeMillis();
			long end = System.currentTimeMillis();
			
			int count = 2;
			for (int i = 2; i < goal; i++) {

				if (i % 100000 == 0) {
					double percent = (i / goal) * 100;
					System.out.println(" / " + i + " = " + percent + "%") ;
				}

				while (in.hasNext()) {
					int j = in.nextInt();
					lineCount++;
				}

				//System.out.println(" lineCount: " + lineCount);

				for (int x = 0; x < primes.size(); x++) {

					Scanner inLine = new Scanner(primeStorage);
			//		int temp = inLine.nextInt();
					if (i % primes.get(x) == 0) {
						isPrime = false;
						break;
					} else {
						isPrime = true;
					}

					if (primes.get(x) > (int)Math.sqrt(i))
						break;

					inLine.close();
				}
				if (isPrime) {
					count++;
					out.printf("%n %9d: %1d", count, i);
					primes.add(i);
				}

			}

			for (int x : primes) {
				System.out.printf("%n count: %-6d, x: %-1d", count, x);
			}

			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found ERR");
		}
	}
}