package a011_Tiling;

public class TilingAlg {
	
	static long[] arr = new long[100];
	static long[] arr2 = new long[100];

	public static void main(String[] args) {
		System.out.println("타일링 문제 1");
		for (int i=1; i<50; i++) 
			System.out.println("n = " + i + " 경우의 수 : " + Tile(i));
		
		System.out.println("타일링 문제 2");
		for (int i=1; i<50; i++) 
			System.out.println("n = " + i + " 경우의 수 : " + Tile2(i));
	}


	private static long Tile2(int n) {
		if (n==1) 
			return 1;
		else if (n==2)
			return 3;
		else if (arr2[n] != 0)
			return arr2[n];
		else
			return arr2[n] = Tile2(n-1) + 2 * Tile2(n-2);
	}

	private static long Tile(int n) {
		if (n==1)
			return 1;
		else if (n==2) 
			return 2;
		else if (arr[n] != 0)
			return arr[n];
		else
			return arr[n] = Tile(n-1) + Tile(n-2);
	}

}

