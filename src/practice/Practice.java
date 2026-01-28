package practice;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {

        int[] arr = {1,5,2,5,6,6,3,6,78,3};
        int[][] twoDepthArr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        printArr(twoDepthArr, "원본");
        int[][] arrRight = turnRight90(twoDepthArr);
        printArr(arrRight, "right");
        int[][] arrLeft = turnLeft90(twoDepthArr);
        printArr(arrLeft, "left");
        int[][] arrTurnOver = turnOver(twoDepthArr);
        printArr(arrTurnOver, "turnOver");

    }

    public static Integer[] intToInteger(int[] arr) {
        return Arrays
                .stream(arr)
                .boxed()
                .toArray(Integer[]::new);
    }

    public static Integer[][] intToInteger(int[][] arr) {
        return Arrays
                .stream(arr)
                .map(obj -> Arrays.stream(obj).boxed().toArray(Integer[]::new))
                .toArray(Integer[][]::new);
    }

    public static int[][] turnRight90(int[][] arr) {

        int n = arr.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[j][n - 1 - i] = arr[i][j];
            }
        }

        return result;
    }

    public static int[][] turnLeft90(int[][] arr) {

        int n = arr.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[n - 1 - j][i] = arr[i][j];
            }
        }

        return result;
    }

    public static int[][] turnOver(int[][] arr) {
        int n = arr.length;
        int[][] result = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                result[n - i - 1][n - j - 1] = arr[i][j];
            }
        }

        return result;
    }

    public static void printArr(int[] arr, String s) {
        System.out.printf("=====Start %s=====%n",s);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.printf("=====End %s=====%n",s);
    }

    public static void printArr(int[][] arr, String s) {
        System.out.printf("=====Start %s=====%n",s);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.printf("=====End %s=====%n",s);
    }
}

