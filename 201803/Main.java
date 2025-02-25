import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long pre = 1, next = 2;
        if (n == 1) System.out.println(1);
        else if (n == 2) System.out.println(2);
        else {
            long temp;
            for (int k = 3; k <= n; ++k) {
                temp = (pre + next) % 999983;
                pre = next;
                next = temp;
            }
            System.out.println(next);
        }

        sc.close();
    }
}
