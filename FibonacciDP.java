package pratice;

public class FibonacciDP {
	static long[] d = new long[50];
	
	static int Fibonacci(int n) {
		if (n==1 || n==2)
			return 1;
		else
			return Fibonacci(n-1) + Fibonacci(n-2);
	}
	
	static long FibonacciDPAlg(int n) {
		if (n==1 || n==2)
			return 1;
		else if (d[n] == 0 ) {
			d[n] = FibonacciDPAlg(n-1) + FibonacciDPAlg(n-2);
			return d[n];
		}
		else 
			return d[n];
	}
	

	public static void main(String[] args) {
		for (int i=1; i<=45; i++) {
			System.out.println(i + " : " + Fibonacci(i));
		}
		
		for (int i=1; i<=45; i++) {
			System.out.println("DP("+i + ")" + " : " + FibonacciDPAlg(i));
		}

	}

}
