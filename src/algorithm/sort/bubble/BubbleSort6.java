package algorithm.sort.bubble;

import util.ComUtil;

public class BubbleSort6 {
    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};

        bubbleSort(a);

        ComUtil.print(a);
    }

    public static void bubbleSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            boolean swapped = false;

            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    ComUtil.swap(a, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
