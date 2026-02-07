package algorithm.sort.bubble;

public class BubbleSort2 {
    public static void main(String[] args) {
        BubbleSort2 s = new BubbleSort2();

        int [] a = {1,5,2,29,3,67,23,6,4};

        s.bubbleSort(a);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    public void bubbleSort(int[] a) {
        // round는 최대 size-1 횟수
        for (int i = 1; i < a.length; i++) {

            // 스왑여부
            boolean swapped = false;

            // 버블정렬은 매 라운드마다 가장우측이 큰값으로 정렬된다는 특징이 있음. 따라서 전체길이-현재라운드
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j+1]) {
                    this.swap(a, j);
                    swapped = true;
                }
            }

            // 스왑되지 않았다면 이미 정렬된 것으로 간주
            if (!swapped) {
              break;
            }
        }
    }

    public void swap (int[] a, int j) {
        int temp = a[j];
        a[j] = a[j+1];
        a[j+1] = temp;
    }
}
