import java.util.Scanner;
import java.lang.Math;

public class Main {

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int[] input = new int[2];
		int[] isPrime = new int[2];

		input[1] = 3;
		System.out.println("\nPlease Enter the Input Number: ");
		input[0] = scanner.nextInt();
		isPrime = primeNumberChecking(input);
		if (isPrime[1] == -1)
			System.out.printf("\n%d , %d is prime", isPrime[1], isPrime[0]);
		else
			System.out.printf("\n%d , %d is not prime", input[1], input[0]);
	}

	public static int[] primeNumberChecking(int[] input) {
		double input0 = (double) input[0];
		double input1 = (double) input[1];
		if (input0 % 2.0 == 0.0 && input[0] != 2) {
			input[1] = 2;
			return input;
		}
		if (input0 % input1 == 0.0 && input[0] != 3) {
			return input;
		}
		if (input1 > Math.sqrt(input[0])) {
			input[1] = -1;
			return input;
		}

		input[1] = input[1] + 2;
		primeNumberChecking(input);
		return input;
	}
}