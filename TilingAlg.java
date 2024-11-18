package pratice;

public class TilingAlg {
	static int[] a = new int[100];
	
	static int Tile3(int n) {
		if (n%2 != 0) 
			return a[n] = 0;
		else if (n==0)
			return a[n] = 1;
		else if (n==2) 
			return a[n] = 3;
		
		if (a[n] != 0)
			return a[n];
		
		int x = Tile3(n-2) * Tile3(2);
		
		for (int i=n-4; i>=0; i-=2)
			x += 2*Tile3(i);
		return a[n] = x;
		
	}

	public static void main(String[] args) {
		for (int i=1; i<30; i++) 
			System.out.println("Tile3(" + i + ") : " + Tile3(i));

	}

}
