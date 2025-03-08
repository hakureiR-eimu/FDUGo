import javax.xml.stream.events.StartDocument;
import java.util.*;
import java.io.*;

//left-right=target
//left+right=sum
//left=(target+sum)/2
//转换成问是否存在left使其和为。。。。
//求和为left的集合的数量
//dpij=dpi-1j+dpi-1j-arr[i]
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        int n = sc.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        int target = sc.nextInt();
        if (target < -sum) {
            System.out.println(0);
            return;
        }
        if ((sum + target) % 2 != 0 || target > sum) {
            System.out.println(0);
            return;
        }
        long mod = (long) 1e9 + 7;
        int left = (sum + target) / 2;
        long[][] dp = new long[n][left + 1];
        dp[0][0] = 1;
        if (arr[0] <= left) {
            dp[0][arr[0]]++;
        }
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= left; ++j) {
                dp[i][j] += dp[i - 1][j];
                if (j >= arr[i]) {
                    dp[i][j] += dp[i - 1][j - arr[i]];
                }
            }
        }
        System.out.println(dp[n - 1][left] % mod);

        sc.close();
    }
}
