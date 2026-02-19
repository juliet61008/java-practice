package algorithm.sort.insertion;

import util.ComUtil;

public class InsertionSort5 {
    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};

        insertionSort(a);

        ComUtil.print(a);
    }

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int target = a[i];

            int j = i - 1;

            while (j >= 0 && target < a[j]) {
                a[j + 1] = a[j];
                j--;
            }

            a[j + 1] = target;
        }
    }
}
