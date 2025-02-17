import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), d = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[][] dp = new int[n][2];
        // 0代表不选择，1代表选择
        // dp[i]代表arr[i]
        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i = 1; i < n; ++i) {
            int num1 = arr[i], num2 = arr[i - 1];
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            if (num1 - d < arr[0]) {
                dp[i][1] = 1;
            } else {
                int j = i - 1;
                while (j >= 0 && arr[j] + d > arr[i]) j--;
                if (j < 0) dp[i][1] = 1;
                else {
                    dp[i][1] = Math.max(dp[j][0], dp[j][1]) + 1;
                }

            }
        }
        System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
        sc.close();
    }
}
