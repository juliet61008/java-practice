package algorithm.sort.selection;

import java.util.Arrays;

public class SelectionSort3 {
    public static void main(String[] args) {
        int[] a = {5,4,3,2,1};

        selectionSort(a);

        Arrays.stream(a).forEach(System.out::print);
    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }

            swap(a, i, minIdx);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
