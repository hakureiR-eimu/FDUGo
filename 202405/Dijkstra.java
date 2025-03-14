import java.util.*;
import java.io.*;

public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        long m = sc.nextLong();
        List<List<Edge>> vec = new ArrayList<>();
        vec.add(new ArrayList<>());
        for (int i = 1; i <= n; ++i) {
            vec.add(new ArrayList<>());
        }
        for (int i = 0; i < m; ++i) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x != y) {
                vec.get(x).add(new Edge(x, y));
                vec.get(y).add(new Edge(y, x));
            }
        }
        long max = Long.MAX_VALUE;
        long[] minDis = new long[n + 1];
        Arrays.fill(minDis, max);
        long[] nums = new long[n + 1];
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            return Long.compare(a.val, b.val);
        });
        pq.add(new Node(1, 0));
        minDis[1] = 0;
        nums[1] = 1;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.id]) {
                continue;
            }

            visited[node.id] = true;
            int cur = -1;
            long val = max;
            for (Edge edge : vec.get(node.id)) {
                if (minDis[node.id] + 1 < minDis[edge.to]) {
                    minDis[edge.to] = minDis[node.id] + 1;
                    nums[edge.to] = nums[edge.from];
                    if (val > minDis[edge.to]) {
                        val = minDis[edge.to];
                        cur = edge.to;
                    }
                } else if (minDis[node.id] + 1 == minDis[edge.to]) {
                    nums[edge.to]+=minDis[edge.from];
                }
            }
            if (val != max) {
                pq.add(new Node(cur, val));
            }
        }
        for (int i = 1; i <= n; ++i) {
            System.out.println(nums[i]);
        }
    }

    static class Edge {
        int from, to;

        Edge(int _from, int _to) {
            from = _from;
            to = _to;
        }
    }

    static class Node {
        int id;
        long val;

        Node(int _id, long _val) {
            id = _id;
            val = _val;
        }
    }
}

