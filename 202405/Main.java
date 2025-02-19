import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        int p1, p2, p3;
        for (int i = 0; i < m; ++i) {
            p1 = sc.nextInt();
            p2 = sc.nextInt();
            p3 = sc.nextInt();
            graph[p1][p2] = p3;
        }
        dijkstra(graph, n, m);
    }

    static void dijkstra(int[][] graph, int n, int m) {
        int max = 0x3f3f3f3f;
        int start = 1, end = n;

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, max);

        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);

        minDist[start] = 0;
//        visited[start]=true;
        for (int i = 1; i <= n; ++i) {
            int minVal = max;
            int cur = 1;
            for (int v = 1; v <= n; ++v) {
                if (!visited[v] && minDist[v] < minVal) {
                    minVal = minDist[v];
                    cur = v;
                }
            }

            visited[cur] = true;

            for (int v = 1; v <= n; ++v) {
                if (!visited[v] && graph[cur][v] != 0 && minDist[cur] + graph[cur][v] < minDist[v]) {
                    minDist[v] = minDist[cur] + graph[cur][v];
                }
            }
        }

        if (minDist[end] == max) System.out.println(-1);
        else System.out.println(minDist[end]);
    }
}
