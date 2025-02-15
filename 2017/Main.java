import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        do {
            n = sc.nextInt();
            if (n == 0) continue;
            int[] arr = new int[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            if (n % 2 == 0) {
                int left = arr[n / 2 - 1];
                int right = arr[n / 2];
                System.out.println((left + right) / 2);
            } else {
                System.out.println(arr[n / 2]);
            }
        } while (n != 0);
    }
}
