import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int startTime = 0;
        int endTime;
        for (int i = 0; i < n; ++i) {
            int a = sc.nextInt();
            int t = sc.nextInt();
            int b = sc.nextInt();
            if (startTime > a + b) {
                System.out.printf("-1 ");
            } else {
                startTime = Math.max(a, startTime);
                endTime = startTime + t;
                System.out.printf("%d ", startTime);
                startTime = endTime;
            }
        }
    }
}
