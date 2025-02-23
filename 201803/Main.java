import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else {
                dp[i] = (dp[i - 1] + dp[i - 2])%999983;
            }
        }
        System.out.println(dp[n]%999983 );
        sc.close();
    }
}
