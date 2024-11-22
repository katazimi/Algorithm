package a001_Euclid;

public class EuclidAlg {
	
	private static int Euclid(int a, int b) {
		if (b==0)
			return a;
		else
			return Euclid(b,a%b);
	}

	public static void main(String[] args) {
		int euclid = Euclid(500, 25);
		System.out.println(euclid);

	}

}
