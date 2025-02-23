import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[][] dp = new int[n][10];
        for (int i = 0; i < n; ++i) {
            A[i] = sc.nextInt();
        }
        //dp[0][0]=A[0];
        for (int i = 0; i < 10; ++i) {
            dp[0][i] = Math.abs(A[0] - i);
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < 10; ++j) {
                int weight1 = Math.abs(A[i] - j);
                int minWeight = 0x3f3f3f3f;
                for (int k = 0; k < 10; ++k) {
                    int weight2 = (j - k) * (j - k);
                    int total = weight2 + dp[i - 1][k];
                    minWeight = Math.min(minWeight, total);
                }
                dp[i][j] = weight1 + minWeight;
            }
        }
        int min = 0x3f3f3f3f;
        for (int i = 0; i < 10; ++i) {
            min = Math.min(min, dp[n - 1][i]);
        }
        System.out.println(min);
        sc.close();
    }
}
