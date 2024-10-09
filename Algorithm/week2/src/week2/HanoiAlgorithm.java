package week2;

public class HanoiAlgorithm {
	
	static void Hanoi(int n, String from, String to, String by) {
		if (n==1)
			System.out.println("Move : " + from + " -> " + to);
		else {
			Hanoi(n-1, from, by, to);
			System.out.println("Move : " + from + " -> " + to);
			Hanoi(n-1, by, to, from);
		}
			
	}

	public static void main(String[] args) {
		Hanoi(4, "A", "C", "B");
	}

}
