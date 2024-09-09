package pratice;

public class Euclidalg {
	
	public int euclidfn(int a, int b) {
		if (b==0) {
			return a; }
		else {
			return euclidfn(b, a%b); }
	}
	
	public static void main(String[] args) {
		Euclidalg euclid = new Euclidalg();
		int result = euclid.euclidfn(1679, 874);
		System.out.println(result);

	}

}
