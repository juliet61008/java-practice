package algorithm.sort.merge;

import util.ComUtil;

public class MergeSort {

    public static int[] result;

    public static void main(String[] args) {
        int[] a = {10,9,8,7,6,5,4,3,2,1};

        result = new int[a.length];

        mergeSort(a, 0, a.length - 1);

        ComUtil.print(a);

        result = null;
    }

    public static void mergeSort(int[] a, int left, int right) {
        if (left == right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);

        merge(a, left, mid, right);
    }

    public static void merge(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid + 1;
        int idx = left;


        while(l <= mid && r <= right) {
            if (a[l] <= a[r]) {
                result[idx] = a[l];
                l++;
                idx++;
            } else {
                result[idx] = a[r];
                r++;
                idx++;
            }
        }

        if (l > mid) {
            while(r <= right) {
                result[idx] = a[r];
                r++;
                idx++;
            }
        } else {
            while(l <= mid) {
                result[idx] = a[l];
                l++;
                idx++;
            }
        }

        for (int i = left; i <= right; i++) {
            a[i] = result[i];
        }
    }

}
