package a005_Sort;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SortAlg extends JFrame{
    
    private JButton generateButton;
    private JButton bubbleSortButton;
    private JButton mergeSortButton;
    private JButton quickSortButton;
    private JTextArea outputArea;
    private int[] list;

    public SortAlg() {
        setTitle("Sorting Algorithms");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize buttons and text area
        generateButton = new JButton("랜덤 숫자 생성");
        bubbleSortButton = new JButton("버블 정렬");
        mergeSortButton = new JButton("합병 정렬");
        quickSortButton = new JButton("퀵 정렬");
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4));
        panel.add(generateButton);
        panel.add(bubbleSortButton);
        panel.add(mergeSortButton);
        panel.add(quickSortButton);
        
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Action listeners
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateRandomNumbers();
                updateOutputArea("랜덤 숫자 생성 완료");
            }
        });

        bubbleSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list != null) {
                    long startTime = System.currentTimeMillis();
                    bubbleSort(list);
                    long endTime = System.currentTimeMillis();
                    updateOutputArea("버블 정렬 완료\n실행 시간(ms): " + (endTime - startTime));
                } else {
                    updateOutputArea("먼저 랜덤 숫자를 생성하세요.");
                }
            }
        });

        mergeSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list != null) {
                    long startTime = System.currentTimeMillis();
                    mergeSort(list, 0, list.length - 1);
                    long endTime = System.currentTimeMillis();
                    updateOutputArea("합병 정렬 완료\n실행 시간(ms): " + (endTime - startTime));
                } else {
                    updateOutputArea("먼저 랜덤 숫자를 생성하세요.");
                }
            }
        });

        quickSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (list != null) {
                    long startTime = System.currentTimeMillis();
                    quickSort(list, 0, list.length - 1);
                    long endTime = System.currentTimeMillis();
                    updateOutputArea("퀵 정렬 완료\n실행 시간(ms): " + (endTime - startTime));
                } else {
                    updateOutputArea("먼저 랜덤 숫자를 생성하세요.");
                }
            }
        });
    }

    private void generateRandomNumbers() {
        list = new int[10000];
        Random random = new Random();
        for (int i = 0; i < list.length; i++) {
            list[i] = random.nextInt(10000);
        }
        updateOutputArea("랜덤 숫자가 생성되었습니다.");
    }

    private void updateOutputArea(String message) {
        outputArea.setText(message + "\n\n");
        if (list != null) {
            for (int num : list) {
                outputArea.append(num + " ");
            }
        }
    }

    // Sorting algorithms
    private void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int l = left;
        int r = mid + 1;
        int idx = left;

        while (l <= mid && r <= right) {
            if (arr[l] <= arr[r]) {
                temp[idx++] = arr[l++];
            } else {
                temp[idx++] = arr[r++];
            }
        }

        while (l <= mid) {
            temp[idx++] = arr[l++];
        }

        while (r <= right) {
            temp[idx++] = arr[r++];
        }

        System.arraycopy(temp, left, arr, left, right - left + 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int low = left + 1;
        int high = right;

        while (low <= high) {
            while (low <= right && arr[low] < pivot) {
                low++;
            }
            while (high >= left && arr[high] > pivot) {
                high--;
            }
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        swap(arr, left, high);
        return high;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SortAlg ui = new SortAlg();
            ui.setVisible(true);
        });
    }

}
