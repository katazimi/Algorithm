package pratice;

public class Merge_sort {
    static int[] temp;

    static void merge(int[] arr, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;

        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[idx] = arr[l];
                l++;
            } else {
                temp[idx] = arr[r];
                r++;
            }
            idx++;
        }

        // Copy remaining elements from left subarray if any
        while (l <= mid) {
            temp[idx] = arr[l];
            l++;
            idx++;
        }

        // Copy remaining elements from right subarray if any
        while (r <= right) {
            temp[idx] = arr[r];
            r++;
            idx++;
        }

        // Copy sorted elements back into the original array
        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }

    static void merge_sort(int[] arr) {
        temp = new int[arr.length];
        merge_sort(arr, 0, arr.length - 1);
    }

    static void merge_sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            merge_sort(arr, left, mid);
            merge_sort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
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
        merge_sort(list);
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
