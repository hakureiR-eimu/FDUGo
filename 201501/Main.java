import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int big = Math.max(n, m), lit = Math.min(n, m);
        int num = 0;
        while (big != lit) {
            big -= lit;
            int tmpBig = Math.max(big, lit), tmpLit = Math.min(big, lit);
            big = tmpBig;
            lit = tmpLit;
            num++;
        }
        num++;
        System.out.println(num);


    }
}
