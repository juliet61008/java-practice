package algorithm.sort.bubble;

public class BubbleSort3 {
    public static void main(String[] args) {
        int[] a = {845,3,7,45,12,67,256,1};

        bubbleSort(a);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            boolean swapped = false;

            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j+1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
