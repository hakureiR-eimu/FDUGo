import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        int e = sc.nextInt();
        //dpij代表0-arri期望值为j的方案数
        //dpij=dpi-1j-arri+dpi-1j
        sc.close();
    }
}
