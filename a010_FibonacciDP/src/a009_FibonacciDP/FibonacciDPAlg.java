package a009_FibonacciDP;

public class FibonacciDPAlg {
	
	static long[] d = new long[100];
	
	private static long Fibo(int n) {
		if (n==1 || n==2)
			return d[n-1] = 1;
		else if (d[n-1] != 0)
			return d[n-1];
		else {
			return d[n-1] = Fibo(n-1) + Fibo(n-2);
		}
	}

	public static void main(String[] args) {
		System.out.println(Fibo(10));
	}

}
