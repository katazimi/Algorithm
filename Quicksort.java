package pratice;

public class Quicksort {
    
    void quick_sort(int list[], int left, int right) {
        int q;
        if (left < right) {
            q = partition(list, left, right);
            quick_sort(list, left, q - 1);
            quick_sort(list, q + 1, right);
        }
    }

    int partition(int[] list, int left, int right) {
        int low = left + 1;
        int high = right;
        int pivot = list[left];

        while (low <= high) {
            while (low <= right && list[low] < pivot) {
                low++;
            }
            while (high >= left && list[high] > pivot) {
                high--;
            }
            if (low <= high) {
                SWAP(list, low, high);
                low++;
                high--;
            }
        }
        SWAP(list, left, high);
        return high;
    }

    void SWAP(int list[], int i, int j) {
        int tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

    public static void main(String[] args) {
        Quicksort quicksort = new Quicksort();
        int list[] = new int[100];
        for (int i = 0; i < 100; i++) {
            list[i] = (int)(Math.random() * 100);
        }

        System.out.println("Before sorting:");
        for (int i = 0; i < 100; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
        
        long beforeTime = System.currentTimeMillis();
        quicksort.quick_sort(list, 0, list.length - 1);
        long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
      	long diffTime = afterTime - beforeTime; // �� ���� ���� �ð�
      	System.out.println("���� �ð�(ms): " + diffTime); // ������(�� ���� ��ȯ)

        System.out.println("After sorting:");
        for (int i = 0; i < 100; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }
}
