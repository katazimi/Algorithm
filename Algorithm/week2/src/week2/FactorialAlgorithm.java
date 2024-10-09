package week2;

public class FactorialAlgorithm {
	
	private static long Factorial(int f) {
		if (f==1) 
			return 1;
		else
			return Factorial(f-1) * f;
	}

	public static void main(String[] args) {
		long fact = Factorial(5);
		System.out.println(fact);

	}



}
