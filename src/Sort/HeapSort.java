package Sort;

import java.util.Arrays;

public class HeapSort {

    public void sort(int[] arr) {
        buildHeap(arr, arr.length - 1);
        int end = arr.length - 1;
        while (end > 0) {
            swap(arr, 0, end);
            end--;
            heapify(arr, 0, end);
        }
    }

    private void heapify(int[] arr, int start, int end) {
        int parent = start;
        int left = parent * 2 + 1;
        while (left <= end) {
            if (left + 1 <= end && arr[left] < arr[left + 1]) {
                left++;
            }

            if (arr[parent] > arr[left]) {
                return;
            } else {
                swap(arr, parent, left);
                parent = left;
                left = left * 2 + 1;

            }
        }
    }

    private void buildHeap(int[] arr, int n) {
        int parent = (n - 1) / 2;
        while (parent >= 0) {
            heapify(arr, parent, n);
            parent--;
        }

    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6, 9};
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
