package pratice;

public class Factorial {
	
	public long fact(int i) {
		if (i==1) 
			return 1;
		else 
			return fact(i-1) * i;
	}

	public static void main(String[] args) {
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		Factorial factorial = new Factorial();
		System.out.println(factorial.fact(2));
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long diffTime = afterTime - beforeTime; // 두 개의 실행 시간
		System.out.println("실행 시간(ms): " + diffTime); // 세컨드(초 단위 변환)
	}

}
