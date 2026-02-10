package util;

import java.util.Arrays;

public class ComUtil {
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void print(int[] a) {
        Arrays.stream(a).forEach(System.out::print);
    }
}
