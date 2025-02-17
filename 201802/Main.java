import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Set<Integer> setA = new HashSet<>();
        Set<Integer> jiaoJi = new HashSet<>();
        Set<Integer> bingJi = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            int item = sc.nextInt();
            setA.add(item);
            bingJi.add(item);
        }
        for (int i = 0; i < m; ++i) {
            int item = sc.nextInt();
            if (setA.contains(item)) {
                jiaoJi.add(item);
            } else {
                bingJi.add(item);
            }
        }
        System.out.printf("%d %d", jiaoJi.size(), bingJi.size());
    }
}
