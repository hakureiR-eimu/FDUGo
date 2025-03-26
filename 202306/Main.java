import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt(), k = sc.nextInt(), T = sc.nextInt();
        int a1 = sc.nextInt(), b1 = sc.nextInt(), c1 = sc.nextInt(), d1 = sc.nextInt();
        int a2 = sc.nextInt(), b2 = sc.nextInt(), c2 = sc.nextInt(), d2 = sc.nextInt();
        int[][] A = new int[n + 1][n + 1];
        for (int x = 0; x < n; ++x) {
            for (int y = 0; y < n; ++y) {
                int num = (int) (T * (a1 * x + b1 * Math.sin(c1 * x + d1) + a2 * y + b2 * Math.sin(c2 * y + d2)));
                A[x][y] = num;
            }
        }
//        int curNum = 0;
//        int step=1;
//        int cur=-1;
        //33,32,23,31,22,13,30,21,12,03,
        //1 2 3 4 3 2 1;
        //16
//        int totalNum=n*n;
        //7 8 9 10
        //mid=6
        //k=4
        //kFan=12
        int cur = 0;
        int i = n - 1, j = n - 1;
        while (cur < k) {
            if (j != 0) {
                //33 32 31 30
                int num = i - j + 1;
                if (cur + num >= k) {
                    break;
                } else {
                    cur += num;
                    j--;
                }
            } else {
                //30 20 10 00
                int num=i-j+1;
                if(cur+num>=k){
                    break;
                }else{
                    cur+=num;
                    i--;
                }
            }
        }
        System.out.println(A[i][j]);
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                System.out.printf("%d ", A[i][j]);
//            }
//            System.out.print("\n");
//        }
    }
}
