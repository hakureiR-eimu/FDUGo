import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        //dp_n=dp_0+do_1+...+dp_n-1;
        for (int i = 0; i <= n; ++i) {
            if (i == 0) dp[i] = 0;
            else if (i == 1) dp[i] = 1;
            else {
                long ans = 0;
                for (int j = 0; j < i; ++j) {
                    if (j == 0) {
                        ans += dp[i - 1];
                    } else if (j == i - 1) {
                        ans += dp[i-1];
                    } else {
                        ans += dp[j] * dp[i - j - 1];
                    }

                }
                dp[i] = ans;
            }
        }
        System.out.println(dp[n]);
    }

}
