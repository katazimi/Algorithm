package sort_project;

public class BubbleSortAlgorithm {
	
	private static void bubble_sort(int[] list) {
		bubble_sort(list, list.length);
		
	}

	private static void bubble_sort(int[] list, int length) {
		for (int i=0; i<length; i++) {
			for (int j=0; j<length-i-1; j++) {
				if (list[j] > list[j+1]) {
					swap(list,j);
				}
			}
		}
		
	}

	private static void swap(int[] list, int j) {
		int tmp = list[j];
		list[j] = list[j+1];
		list[j+1] = tmp;
	}

	public static void main(String[] args) {
		int list[] = new int[100];
        for (int i = 0; i < 100; i++) {
            list[i] = (int) (Math.random() * 1000);
        }

        System.out.println("Before sorting:");
        for (int i = 0; i < 100; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
        
        bubble_sort(list);

        System.out.println("After sorting:");
        for (int i = 0; i < 100; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();


	}

	

}
