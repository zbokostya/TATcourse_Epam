package fundamentals.mainTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task3 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            System.out.println((int) (Math.random() * 100));
        }

        for (int i = 0; i < n; i++) {
            System.out.print((int) (Math.random() * 100) + " ");
        }
        br.close();
    }


}
