import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Edge>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; ++i) {
            int start = edges[i][0];
            int end = edges[i][1];
            double succ = succProb[i];
            graph.get(start).add(new Edge(start, end, succ));
            graph.get(end).add(new Edge(end, start, succ));
        }
        double minPro = 0;
        double[] maxPro = new double[n];
        Arrays.fill(maxPro, minPro);
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        //应该是最大堆
        PriorityQueue<Dis> pq = new PriorityQueue<>((a, b) ->
        {
            return Double.compare(b.val, a.val);
        });

        maxPro[start_node] = 1;
        pq.add(new Dis(start_node, 1));
        while (!pq.isEmpty()) {
            Dis dis = pq.poll();
            int cur = dis.index;
            double val = dis.val;
            if (visited[cur]) continue;
            visited[cur] = true;
            for (Edge edge : graph.get(cur)) {
                if (!visited[edge.end] && val * edge.val > maxPro[edge.end]) {
                    maxPro[edge.end] = val * edge.val;
                    pq.add(new Dis(edge.end, maxPro[edge.end]));
                }
            }
        }

        return maxPro[end_node];
    }

    class Edge {
        int start;
        int end;
        double val;

        Edge(int start, int end, double val) {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }

    class Dis {
        int index;
        double val;

        Dis(int _index, double _val) {
            this.index = _index;
            this.val = _val;
        }
    }

}

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1, 4}, {2, 4}, {0, 4}, {0, 3}, {0, 2}, {2, 3}};
        double[] succProb = {0.37, 0.17, 0.93, 0.23, 0.39, 0.04};
        int start_node = 3;
        int end_node = 4;
        Solution sol = new Solution();
        double ans = sol.maxProbability(n, edges, succProb, start_node, end_node);
        System.out.println(ans);
    }
}