import java.util.*;

public class Main {
    public static void main(String[] args) {
        //dp[i]=dp[i-1]+dp[i-2]
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        if (n == 1) System.out.println(1);
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 2; i <= n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}
