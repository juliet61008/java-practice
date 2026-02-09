package algorithm.sort.insertion;

import java.lang.reflect.Array;
import java.util.Arrays;

public class InsertionSort3 {
    public static void main(String[] args) {
        int[] a = {5,4,3,2,1};

        insertionSort3(a);

        Arrays.stream(a).forEach(System.out::print);
    }

    public static void insertionSort3(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int target = a[i];

            int j = i - 1;

            while(j >= 0 && target < a[j]) {

                a[j+1] = a[j];
                j--;
            }

            a[j+1] = target;
        }
    }
}
