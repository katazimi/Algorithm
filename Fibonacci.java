package pratice;
import java.util.ArrayList;

public class Fibonacci {
	
	public int fibo(int i) {
		if (i==1 ||i==2)
			return 1;
		else 
			return fibo(i-1) + fibo(i-2); 
	}

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		System.out.println(fibonacci.fibo(15));
		
		//반복문 피보나치
		ArrayList<Integer> fb = new ArrayList<>();
		for (int i=0; i<15; i++) {
			if (i==0 || i==1) {
				fb.add(1);
			}
			else {
				fb.add(fb.get(i-1) + fb.get(i-2));
			}
		}
		System.out.println(fb.get(14));
		

	}

}
