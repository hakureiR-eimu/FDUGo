import java.math.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        long a, b, c;
        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();
        if (a + b == c || a - b == c || a * b == c || a / b == c && a % b == 0) {
            System.out.println("YES");
        } else if (b - a == c || b / a == c && b % a == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        BigDecimal ab;
        ab = sc.nextBigDecimal();
    }

}
