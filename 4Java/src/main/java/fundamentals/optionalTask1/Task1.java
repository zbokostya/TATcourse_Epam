package fundamentals.optionalTask1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Task1 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = lengthNumber(arr[i][0]);
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));


        System.out.println("Shortest: " + arr[0][0]);
        System.out.println("Longest: " + arr[arr.length - 1][0]);
        out(arr);
    }

    private static int lengthNumber(int n) {
        int rez = 0;
        while (n != 0) {
            rez++;
            n /= 10;
        }
        return rez;
    }

    private static void out(int[][] arr) {
        for (int[] ints : arr) {
            System.out.println(ints[0]);
        }
    }
}
