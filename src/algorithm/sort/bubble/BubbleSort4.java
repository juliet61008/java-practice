package algorithm.sort.bubble;

import java.util.Arrays;

public class BubbleSort4 {

    public static void main(String[] args) {
        int[] a = {4,3,2,1};

        bubbleSort(a);

        Arrays.stream(a).forEach(System.out::print);
    }

    public static void bubbleSort(int[] a) {

        for (int i = 1; i < a.length; i++) {
            boolean swapped = false;

            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j+1]) {
                    swap(a, j, j+1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
