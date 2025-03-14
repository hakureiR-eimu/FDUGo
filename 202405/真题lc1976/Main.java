import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        Solution sol = new Solution();
        int ans = sol.countPaths(n, roads);
        System.out.println(ans);
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = 1000000007;
        boolean[] visited = new boolean[n];
        int[] minDis = new int[n];
        int max = Integer.MAX_VALUE;
        Arrays.fill(minDis, max);
        List<List<Edge>> vector = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            vector.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; ++i) {
            int id = roads[i][0];
            int to = roads[i][1];
            int time = roads[i][2];
            vector.get(id).add(new Edge(to, time));
            vector.get(to).add(new Edge(id, time));
        }
        int start = 0, end = n - 1;
        minDis[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.minDis - b.minDis);
        pq.add(new Node(minDis[start], start));

        long[] countPaths = new long[n];
        countPaths[start] = 1;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.id]) continue;

            visited[node.id] = true;

            List<Edge> edges = vector.get(node.id);

            for (Edge edge : edges) {
                if (!visited[edge.to] && minDis[node.id] + edge.time < minDis[edge.to]) {
                    minDis[edge.to] = minDis[node.id] + edge.time;
                    countPaths[edge.to] = countPaths[node.id];
                    pq.add(new Node(minDis[edge.to], edge.to));
                } else if (!visited[edge.to] && minDis[node.id] + edge.time == minDis[edge.to]) {
                    countPaths[edge.to] += countPaths[node.id];
                    countPaths[edge.to] = countPaths[edge.to] % mod;
                }
            }

        }

        return (int) countPaths[end] % mod;
    }

    class Edge {
        int to;
        int time;

        Edge(int to, int time) {
            this.to = to;
            this.time = time;
        }
    }

    class Node {
        int minDis, id;

        Node(int minDis, int id) {
            this.minDis = minDis;
            this.id = id;
        }
    }
}