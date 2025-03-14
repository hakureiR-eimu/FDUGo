import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt(), m = sc.nextInt(), s = sc.nextInt();
        int u, v;
        long w;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; ++i) {
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextLong();
            graph.get(u).add(new Edge(v, w));
        }
        boolean[] visited = new boolean[n + 1];
        long max = Long.MAX_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dis, b.dis));
        long[] minDis = new long[n + 1];
        Arrays.fill(minDis, max);

        minDis[1] = 0;
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.id]) continue;
            visited[node.id] = true;

            int cur = 0;
            long dis = max;
            for (Edge edge : graph.get(node.id)) {
                if (minDis[node.id] + edge.val < minDis[edge.to]) {
                    minDis[edge.to] = minDis[node.id] + edge.val;
                    if (dis > minDis[edge.to]) {
                        dis = minDis[edge.to];
                        cur = edge.to;
                    }
                }
            }
            if (cur != 0)
                pq.add(new Node(cur, dis));
        }
        for (int i = 1; i <= n; ++i) {
            System.out.println(minDis[i]);
        }
    }

    static class Edge {
        int to;
        long val;

        Edge(int _to, long _val) {
            to = _to;
            val = _val;
        }
    }

    static class Node {
        int id;
        long dis;

        Node(int _id, long _dis) {
            this.id = _id;
            dis = _dis;
        }
    }
}
