package algorithm.sort.bubble;

import java.util.Arrays;

public class BubbleSort5 {
    public static void main(String[] args) {

        int[] a = {5,4,3,2,1};

        bubbleSort(a);

        Arrays.stream(a).forEach(System.out::print);
    }

    public static void bubbleSort(int[] a) {
        for (int i = 1; i < a.length; i++) {

            boolean swapped = false;

            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j+1]) {
                    swapped = true;
                    swap(a,j,j+1);
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
