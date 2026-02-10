package algorithm.sort.quick;

import util.ComUtil;

public class QuickSortRight {
    public static void main(String[] args) {
        int[] a = {5,4,3,2,1};
        quickSort(a, 0, a.length-1);
        ComUtil.print(a);
    }

    public static void quickSort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int pivot = partition(a,lo,hi);

        quickSort(a,lo,pivot-1);
        quickSort(a,pivot+1,hi);

    }

    public static int partition(int[] a, int left, int right) {

        int lo = left;
        int hi = right;
        int pivot = a[right];

        while(hi > lo) {
            while(hi > lo && pivot > a[lo]) {
                lo++;
            }

            while(hi > lo && pivot <= a[hi]) {
                hi--;
            }

            ComUtil.swap(a,lo,hi);
        }

        ComUtil.swap(a,hi,right);

        return hi;
    }
}
