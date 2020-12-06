package fundamentals.mainTask;

public class Task4 {
    public static void main(String[] args) {
        int n = 0;
        for (String arg : args) {
            n += Integer.parseInt(arg);
        }
        System.out.println("Sum = " + n);
    }
}
