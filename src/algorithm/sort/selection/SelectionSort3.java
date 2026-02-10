package algorithm.sort.selection;

import util.ComUtil;

public class SelectionSort3 {
    public static void main(String[] args) {
        int[] a = {5,4,3,2,1};

        selectionSort(a);

        ComUtil.print(a);

    }

    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }

            ComUtil.swap(a,i,minIdx);
        }
    }

}
