package pratice;

public class Hanoi {
	
	public void hanoi(int n, String from, String to, String by) {
		if (n==1)
			System.out.println("Move : "+from+" -> "+to);
		else {
			hanoi(n-1,from,by,to);
			System.out.println("Move : "+from+" -> "+to);
			hanoi(n-1,by,to,from);
		}
	}

	public static void main(String[] args) {
		Hanoi hanoitower = new Hanoi();
		hanoitower.hanoi(4, "A", "C", "B");
	}

}
