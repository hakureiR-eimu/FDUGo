import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        long[] ids = new long[n];
        for (int i = 0; i < n; ++i) {
            ids[i] = sc.nextLong();
        }
        Map<Long, Integer> idToPos = new HashMap<>();
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                dp[i] = 0;
                idToPos.put(ids[0], 0);
            } else {
                if (!idToPos.containsKey(ids[i])) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = Math.min(dp[idToPos.get(ids[i])] + 1, dp[i - 1] + 1);
                }
                idToPos.put(ids[i], i);
            }

        }
        System.out.println(dp[n - 1]);
    }
}
