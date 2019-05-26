package mehdi.practice.lab.math;

public class Fibonacci {

	public static int recursiveFibonacci(int order) {
		return order == 0 ? 0 :
				order == 1 ? 1 :
						recursiveFibonacci(order - 1) + recursiveFibonacci(order - 2);
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
