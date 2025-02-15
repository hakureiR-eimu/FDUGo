import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        int len1 = str1.length();
        String str2 = sc.nextLine();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        //
        int ans = 0;
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(ans);
    }
}
