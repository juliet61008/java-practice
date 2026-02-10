package algorithm.sort.quick;

import util.ComUtil;

public class QuickSort3 {
    public static void main(String[] args) {
        int[] a = {5,4,3,2,1};

        quickSort(a, 0, a.length - 1);

        ComUtil.print(a);
    }

    public static void quickSort(int[] a, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int pivot = partition(a, lo, hi);

        quickSort(a, lo, pivot - 1);
        quickSort(a, pivot + 1, hi);

    }

    public static int partition(int[] a, int left, int right) {

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

            ComUtil.swap(a,hi,lo);
        }

        ComUtil.swap(a,lo,left);

        return lo;
    }
}
