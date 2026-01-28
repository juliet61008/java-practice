import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        process();

    }

    public static void process() {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        System.out.println("======원본======");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("======오른쪽90======");
        // 오른쪽 90
        for (int i = 0; i < solutionRight90(arr).length; i++) {
            System.out.println(Arrays.toString(solutionRight90(arr)[i]));
        }
        System.out.println("======왼쪽90======");
        // 왼쪽 90
        for (int i = 0; i < solutionLeft90(arr).length; i++) {
            System.out.println(Arrays.toString(solutionLeft90(arr)[i]));
        }
        System.out.println("======180======");
        // 180
        for (int i = 0; i < solution180(arr).length; i++) {
            System.out.println(Arrays.toString(solution180(arr)[i]));
        }
        System.out.println("======전치======");
        // 전치
        for (int i = 0; i < solution180(arr).length; i++) {
            System.out.println(Arrays.toString(전치(arr)[i]));
        }
    }

    public static int[][] solutionRight90(int[][] arr) {

        int n = arr.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[j][n - 1 - i] = arr[i][j];
            }
        }

        return result;
    }

    public static int[][] solutionLeft90(int[][] arr) {

        int n = arr.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[n-j-1][i] = arr[i][j];
            }
        }

        return result;
    }

    public static int[][] solution180(int[][] arr) {

        int n = arr.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[n-i-1][n-j-1] = arr[i][j];
            }
        }

        return result;
    }

    public static int[][] 전치(int[][] arr) {

        int n = arr.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result[j][i] = arr[i][j];
            }
        }

        return result;
    }
}
