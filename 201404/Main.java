import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        while (n != 0) {
            hanota(n, 0, 0, 0);
            System.out.print("\n");
            n = sc.nextInt();
        }

    }

    static void hanota(int a, int b, int c, int num) {
        if (num % 4 == 0) {
            System.out.print("\n");
        }
        if (a == 1) {

        }
    }
}
