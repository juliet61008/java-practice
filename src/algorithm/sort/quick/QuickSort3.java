package algorithm.sort.quick;

import util.ComUtil;

public class QuickSort3 {
    public static void main(String[] args) {
        int[] a1 = {5,4,3,2,1};
        int[] a2 = {5,4,3,2,1};
        int[] a3 = {5,4,3,2,1};

        quickSortLeft(a1, 0, a1.length - 1);
        quickSortRight(a2, 0, a2.length - 1);
        quickSortMid(a3, 0, a3.length - 1);

        ComUtil.print(a1);
        ComUtil.print(a2);
        ComUtil.print(a3);
    }

    public static void quickSortLeft(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = partitionLeft(a, lo, hi);

        quickSortLeft(a, lo, pivot - 1);
        quickSortLeft(a, pivot + 1, hi);
    }

    public static int partitionLeft(int[] a, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = a[left];

        while(lo < hi) {
            while(lo < hi && pivot < a[hi]) {
                hi--;
            }

            while(lo < hi && pivot >= a[lo]) {
                lo++;
            }

            ComUtil.swap(a,lo,hi);
        }

        ComUtil.swap(a,lo,left);

        return lo;
    }

    /**
     * quickSort pivot 우측
     * @param a
     * @param lo
     * @param hi
     */
    public static void quickSortRight(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = partitionRight(a, lo, hi);

        quickSortRight(a, lo, pivot - 1);
        quickSortRight(a, pivot + 1, hi);

    }

    public static int partitionRight(int[] a, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = a[right];

        while (lo < hi) {
            while (lo < hi && pivot > a[lo]) {
                lo++;
            }

            while (lo < hi && pivot <= a[hi]) {
                hi--;
            }

            ComUtil.swap(a,lo,hi);
        }

        ComUtil.swap(a,hi,right);

        return hi;
    }

    public static void quickSortMid(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        int pivot = partitionMid(a, lo, hi);
        quickSortMid(a, lo, pivot);
        quickSortMid(a, pivot + 1, hi);

    }

    public static int partitionMid(int[] a, int left, int right) {
        int lo = left-1;
        int hi = right+1;
        int pivot = a[(left + right) / 2];

        while (true) {
            do {
                lo++;
            } while (pivot > a[lo]);

            do {
                hi--;
            } while (pivot < a[hi]);

            if (lo >= hi) {
                return hi;
            }

            ComUtil.swap(a, lo, hi);
        }
    }


}
