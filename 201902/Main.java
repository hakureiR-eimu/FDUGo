import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (dp[i - 1] + arr[i-1] > 0) {
                dp[i] = dp[i - 1] + arr[i-1];
            } else {
                dp[i] = 0;
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
