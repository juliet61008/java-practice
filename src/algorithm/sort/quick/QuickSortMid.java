package algorithm.sort.quick;

import util.ComUtil;

public class QuickSortMid {
    public static void main(String[] args) {
        int[] a = {3,1,2,1,3};
        quickSort(a,0,a.length-1);
        ComUtil.print(a);
    }

    public static void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }


        int pivot = partition(a, lo, hi);

        quickSort(a,lo,pivot-1);
        quickSort(a,pivot+1,hi);

    }

    public static int partition(int[] a, int left, int right) {
        int lo = left;
        int hi = right;
        int pivot = a[(left+right)/2];

        while(lo <= hi) {
            while(lo < hi && a[lo] < pivot) {
                lo++;
            }
            while(lo < hi && a[hi] > pivot) {
                hi--;
            }

            if (lo <= hi) {
                ComUtil.swap(a,lo,hi);
                lo++;
                hi--;
            }
        }

        return hi;
    }
}
