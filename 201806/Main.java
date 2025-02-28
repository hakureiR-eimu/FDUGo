import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            ans += i * (n / i);
        }
        System.out.println(ans);
    }
}
