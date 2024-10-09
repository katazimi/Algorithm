package week2;

public class FibonacciAlgorithm {
	
	private static int Fibonacci(int n) {
		if (n==1 || n==2) 
			return 1;
		else 
			return Fibonacci(n-1) + Fibonacci(n-2);
	}

	public static void main(String[] args) {
		int fibo = Fibonacci(10);
		System.out.println(fibo);

	}
	
}
