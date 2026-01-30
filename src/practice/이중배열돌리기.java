package practice;

import java.util.Arrays;

public class 이중배열돌리기 {

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        for (int[] i : arr) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        이중배열돌리기 cl = new 이중배열돌리기();

        cl.turnRight90(arr);
        int[][] arr2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        cl.turnLeft90(arr2);
        int[][] arr3 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        cl.turn180(arr3);

    }

    public void turnRight90 (int[][] arr) {
        System.out.println("===S.오른쪽90===");

        int[][] result = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[j][arr.length - i - 1] = arr[i][j];
            }
        }

        for (int[] i : result)                                                                                                     {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("===E.오른쪽90===");
    }

    public void turnLeft90 (int[][] arr) {
        System.out.println("===S.왼쪽===");

        int[][] result = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[arr.length - j - 1][i] = arr[i][j];
            }
        }

        for (int[] i : result) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("===E.왼쪽90===");
    }

    public void turn180 (int[][] arr) {
        System.out.println("===S.180===");

        int[][] result = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[arr.length - 1 - i][arr.length - 1 - j] = arr[i][j];
            }
        }

        for (int[] i : result) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("===E.180===");
    }

}
