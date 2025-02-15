import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; ++i) {
            input[i] = sc.nextInt();
            if (!map.containsKey(input[i])) {
                map.put(input[i], 1);
            } else {
                map.put(input[i], map.get(input[i]) + 1);
            }
        }
        int maxValue = -1;
        int maxKey = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        System.out.println(maxKey);
    }
}
