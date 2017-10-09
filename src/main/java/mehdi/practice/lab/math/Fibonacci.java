package mehdi.practice.lab.math;

public class Fibonacci {

	public static int recursiveFibonacci(int order) {
		int result = 0;

		if (order == 0) {
			return 0;
		} else if (order == 1) {
			return 1;
		}

		result += recursiveFibonacci(order - 2) + recursiveFibonacci(order - 1);

		return result;

	}

	public static int nonRecursiveFibonacci(int order) {
		int result = 0;
		int previous = 1;

		for (int i = 1; i <= order; i++) {
			result = result + previous;
			previous = result - previous;
		}
		
		return result;
	}

}
