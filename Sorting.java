package pratice;

package pratice;

public class Sorting {
	static int N = 100;
	static int[] a= new int[N];

	public static void main(String[] args) {
		RandomInt();
		System.out.print("정렬 전 : ");
		PrintArray();
		BubbleSort();
		
		System.out.println();
		
		RandomInt();
		System.out.print("정렬 전 : ");
		PrintArray();
		SelectionSort();
		
		System.out.println();
		
		RandomInt();
		System.out.print("정렬 전 : ");
		PrintArray();
		InsertionSort();
		
		System.out.println();
		
		RandomInt();
		System.out.print("정렬 전 : ");
		PrintArray();
		ShellSort();
		
		System.out.println();
		
		RandomInt();
		System.out.print("정렬 전 : ");
		PrintArray();
		HeapSort();
		
		System.out.println();
		
		RandomInt();
		System.out.print("정렬 전 : ");
		PrintArray();
		RadixSort();
		
	}
	
	//기수 정렬
	private static void RadixSort() {
		System.out.println("기수정렬");
		int max = GetMax();
		
		for (int exp=1; max/exp > 0; exp*=10)
			CountingSort(a, exp);
		
		PrintArray();

	}

	private static void CountingSort(int[] a, int exp) {
		int[] count = new int[10];
		int[] output = new int[N];
		
		for (int i=0; i<N; i++)
			count[(a[i]/exp) % 10]++;
		
		// count[]의 누적 계산
		for (int i=1; i<10; i++)
			count[i] += count[i-1];
		
		//a[]을 뒤에서부터 해당 자릿수를 count[]에 저장
		for (int i=N-1; i>=0; i--) {
			int pos = count[a[i]/exp%10] - 1;
			output[pos] = a[i];
			count[a[i]/exp%10]--;
		}
		
		//output을 a[]에 복사
		for (int i=0; i<N; i++)
			a[i] = output[i];
		
	}

	private static int GetMax() {
		int max = a[0];
		
		for (int i=0; i<N; i++) {
			if(a[i] > max)
				max = a[i];
		}
		return max;
	}

	//힙정렬
	private static void HeapSort() {
		System.out.println("힙정렬");
		
		for (int i=N/2-1; i>=0; i--) {
			DownHeap(a, N, i);
		}
		
		for (int i=N-1; i>=0; i--) {
			swap(0,i);
			DownHeap(a,i,0);
		}
		
		PrintArray();
		
	}

	private static void DownHeap(int[] a, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if (left < n && a[left] > a[largest])
			largest = left;
		if (right < n && a[right] > a[largest])
			largest = right;
		
		if(largest != i) {
			swap(i, largest);
			DownHeap(a, n, largest);
		}
		
	}

	//쉘정렬
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

	//삽입정렬
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

	//선택정렬
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

	//버블정렬
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
