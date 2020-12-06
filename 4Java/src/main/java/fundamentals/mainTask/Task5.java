package fundamentals.mainTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task5 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] month = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        System.out.println("Enter month: ");
        int n = Integer.parseInt(st.nextToken());

        if (n > 0 && n < 13) {
            System.out.println(month[n]);
        } else {
            System.out.println("Wrong month");
        }
        br.close();
    }
}
