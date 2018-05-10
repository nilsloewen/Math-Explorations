package Math_Tools;
import java.util.Scanner;

public class wonderousNumber {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Is your number Wondrous? How long will it take...");
		int input = keyboard.nextInt();

		long[] max = {4, 2};
		for (long x = 113383; x < 10000000; x++){
			
			long count = 1;
			long w = x;
			while (w != 1) {

				if (w % 2 == 0)
					w = w / 2;
				else 
					w = w * 3 + 1;

				count++;
				if (count > max[0]){
					max[0] = count;
					max[1] = x;
				}
		//	System.out.println("w: " + w + ", count: " + count);
			if (w > Integer.MAX_VALUE){
				System.out.println("Broken!============================");
			}
			}

			System.out.println("x: " + x + ", count: " + count);


		}

		System.out.println(max[0] + " " + max[1]);
	}

}
