import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] speed = new long[n + 1];
        long[] efficiency = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            speed[i] = sc.nextLong()
        }
        for (int i = 1; i <= n; ++i) {
            efficiency[i] = sc.nextLong();
        }
        int k=sc.nextInt();

        //01背包
        //dp[i][j] 代表1-i号中选择i号且挑选j个所能的最大值
        //初始条件：dp[0][i]代表无人可选,dp[i][0]代表名额不够
        long[][] dp=new long[n+1][k+1];
        for(int i=1;i<=n;++i){
            for(int j=1;j<=k;++j){

            }
        }
        sc.close();
    }
}
