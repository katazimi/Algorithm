package pratice;

public class ChainedMatrixMultipulicationAlg {

	public static void main(String[] args) {
		int[] arr = {10, 30, 5, 60, 15, 10}; //���� ���
		int n = 6; //�迭�� ũ��
		
		matrixChainOrder(arr,n);

	}

	private static void matrixChainOrder(int[] p, int n) {
		int[][] m = new int[n][n]; //������ Ƚ��
		int[][] s = new int[n][n]; //������ �������� ��ġ
		
		//L�� ���� ����� ����
		for (int L=2; L<n; L++) {
			for (int i=1; i<=n-L; i++) {
				int j = i+L-1;
				m[i][j] = Integer.MAX_VALUE;
				for (int k=i; k<j; k++) {
					int q = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j];
					if (q < m[i][j]) {
						m[i][j] = q;
						s[i][j] = k;
					}
				}
			}
			System.out.println("L = " + L);
			printArray(m,n);
			System.out.println();
			printArray(s,n);
		}
		System.out.println();
		//���� ���� ����(����Լ�)
		printParen(s, 1, n-1);
	}

	private static void printParen(int[][] s, int i, int j) {
		if (i==j) {
			System.out.print("A" + i);
		}
		else {
			System.out.print("(");
			printParen(s, i, s[i][j]);
			printParen(s, s[i][j] + 1, j);
			System.out.print(")");
		}
		
	}

	private static void printArray(int[][] m, int n) {
		for (int i=1; i<n; i++) {
			for (int j=1; j<n; j++) {
				System.out.print(String.format("%8d", m[i][j]));
			}
			System.out.println();
		}
		
	}

}
