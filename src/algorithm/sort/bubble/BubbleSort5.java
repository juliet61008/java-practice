package algorithm.sort.bubble;

import util.ComUtil;

import java.util.Arrays;

public class BubbleSort5 {
    public static void main(String[] args) {

        int[] a = {5,4,3,2,1};

        bubbleSort(a);

        ComUtil.print(a);
    }

    public static void bubbleSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    ComUtil.swap(a,j,j+1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }


}
