package sort_project;

public class QuickSortAlgorithm {
	
	private static void QuickSort(int[] list, int left, int right) {
		int q;
		
		if (left < right) {
			q = partision(list, left, right);
			QuickSort(list, left, q-1);
			QuickSort(list, q+1, right);
		}
		
	}
	
	private static int partision(int[] list, int left, int right) {
		int low = left + 1;
		int high = right;
		int pivot = list[left];
		
		while (low <= high) {
			while (low <= high && list[low] < pivot) {
				low++;
			}
			while (high >= low && list[high] > pivot) {
				high--;
			}
			if (low <= high) {
				Swap(list, low, high);
				low++;
				high--;
			}
		}
		Swap(list, left, high);
		return high;
	}

	private static void Swap(int[] list, int low, int high) {
		int tmp = list[low];
		list[low] = list[high];
		list[high] = tmp;
		
	}

	public static void main(String[] args) {
		int list[] = new int[100];
		for (int i=0; i<100; i++) {
			list[i] = (int)(Math.random() * 1000);
		}
		
		for (int i=0; i<100; i++) {
			System.out.print(list[i] + " ");
		}
		
		QuickSort(list, 0, list.length-1);
		System.out.println("After Sort : ");
		for (int i=0; i<100; i++) {
			System.out.print(list[i] + " ");
		}
	}

	

}
