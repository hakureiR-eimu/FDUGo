import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strA = sc.nextLine();
        String strB = sc.nextLine();
        String strC = sc.nextLine();
        //System.out.printf("strAlen:%d\n",strA.length());
        StringBuilder[][][] dp = new StringBuilder[strA.length() + 1][strB.length() + 1][strC.length() + 1];
        for (int i = 0; i <= strA.length(); ++i) {
            for (int j = 0; j <= strB.length(); ++j) {
                for (int k = 0; k <= strC.length(); ++k) {
                    if (i == 0 || j == 0 || k == 0) dp[i][j][k] = new StringBuilder();

//                    System.out.println(dp[i][j][k].toString());
                }
            }
        }
        for (int i = 1; i <= strA.length(); ++i) {
            for (int j = 1; j <= strB.length(); ++j) {
                for (int k = 1; k <= strC.length(); ++k) {
                    if (strA.charAt(i - 1) == strB.charAt(j - 1) && strA.charAt(i - 1) == strC.charAt(k - 1)) {
                        dp[i][j][k] = new StringBuilder(dp[i - 1][j - 1][k - 1]);
                        dp[i][j][k].append(strA.charAt(i - 1));

                    } else {
                        int l1 = dp[i - 1][j][k].length();
                        int l2 = dp[i][j - 1][k].length();
                        int l3 = dp[i][j][k - 1].length();
                        int maxLen = Math.max(l1, Math.max(l2, l3));
                        if (maxLen == l1) dp[i][j][k] = new StringBuilder(dp[i - 1][j][k]);
                        else if (maxLen == l2) dp[i][j][k] = new StringBuilder(dp[i][j - 1][k]);
                        else dp[i][j][k] = new StringBuilder(dp[i][j][k - 1]);
                    }
                }
            }
        }
//        System.out.println(dp[1][1][1]);
//        System.out.println(dp[2][3][2]);
//        System.out.println(dp[3][2][3]);
        System.out.println(dp[strA.length()][strB.length()][strC.length()].toString());
    }
}
