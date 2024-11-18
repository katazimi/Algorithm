package pratice;

public class Sorting {
	static int N = 100;
	static int[] a= new int[N];

	public static void main(String[] args) {
		RandomInt();
		PrintArray();
		BubbleSort();
		
		System.out.println();
		
		RandomInt();
		PrintArray();
		SelectionSort();
		
		System.out.println();
		
		RandomInt();
		PrintArray();
		InsertionSort();
		
		System.out.println();

		
		RandomInt();
		PrintArray();
		ShellSort();
	}

	private static void ShellSort() {
		int[] h = {0, 1, 4, 10, 23, 57, 132, 201, 701, 1750};
		int index = 0;
		while (h[index] < N/2)
			index++;
		int gap = h[--index];
		
		while(gap>0) {
			System.out.println("gap = " + gap);
			for (int i=gap; i<N; i++) {
				int current = a[i];
				int j=i;
				while (j >= gap && a[j-gap] > current) {
					a[j] = a[j-gap];
					j = j-gap;
				}
				a[j] = current;
			}
			PrintArray();
			gap = h[--index];
		}
		
		System.out.println("Shell Sort Result");
		PrintArray();
	}

	private static void InsertionSort() {
		for (int i=1; i<N-2; i++) {
			int current = a[i];
			int j = i-1;
			
			while(j>=0 && a[j] > current) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = current;
		}
		System.out.println("Insertion Sort Result");
		PrintArray();
	}

	private static void SelectionSort() {
		for (int i=0; i<N-1; i++) {
			int min = i;
			for (int j=i+1; j<N; j++) {
				if (a[j] < a[min])
					min = j;
			}
			swap(i,min);
		}
		System.out.println("Selection Sort Result");
		PrintArray();
	}

	private static void BubbleSort() {
		for (int pass=1; pass<N; pass++) {
			for (int i=1; i<N-pass-1; i++) {
				if (a[i-1] > a[i])
					swap(i-1, i);
			}
		}
		System.out.println("Bubble Sort Result");
		PrintArray();
	}

	private static void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}

	private static void PrintArray() {
		for (int i=0; i<N; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	private static void RandomInt() {
		for (int i=0; i<N; i++)
			a[i] = (int)(Math.random()*1000);	
	}

}
