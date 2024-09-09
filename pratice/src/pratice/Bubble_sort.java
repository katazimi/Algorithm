package pratice;

public class Bubble_sort {
	
	static void bubble_sort (int[] arr) {
		bubble_sort(arr, arr.length);
	}
	
	static void bubble_sort (int[] arr, int size) {
		for (int i=0; i<size; i++) {
			for(int j=0; j<size-i-1; j++) {
				if (arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
				}
			}
		}
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int list[] = new int[10000];
        for (int i = 0; i < 10000; i++) {
            list[i] = (int) (Math.random() * 100000);
        }

        System.out.println("Before sorting:");
        for (int i = 0; i < 10000; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
        
        long beforeTime = System.currentTimeMillis();
        bubble_sort(list);
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
      	long diffTime = afterTime - beforeTime; // 두 개의 실행 시간
      	System.out.println("실행 시간(ms): " + diffTime); // 세컨드(초 단위 변환)

        System.out.println("After sorting:");
        for (int i = 0; i < 10000; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();

	}

}
