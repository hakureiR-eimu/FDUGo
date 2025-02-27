import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        dijkstraHeapMatrix();
    }

    static void dijkstra() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        int[][] graph = new int[n + 1][n + 1];
        int p1, p2, p3;
        for (int i = 0; i < graph.length; ++i) {
            Arrays.fill(graph[i], 0x3f3f3f3f);
        }
        for (int i = 0; i < m; ++i) {
            p1 = sc.nextInt();
            p2 = sc.nextInt();
            p3 = sc.nextInt();
            graph[p1][p2] = p3;
        }
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
                if (!visited[v] && graph[cur][v] != max && minDist[cur] + graph[cur][v] < minDist[v]) {
                    minDist[v] = minDist[cur] + graph[cur][v];
                }
            }
        }

        if (minDist[end] == max) System.out.println(-1);
        else System.out.println(minDist[end]);
    }

    static void dijkstraHeap() throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<List<Edge>> graph = new ArrayList<>(n + 1);
        int p1, p2, p3;
        for (int i = 0; i < m; ++i) {
            p1 = sc.nextInt();
            p2 = sc.nextInt();
            p3 = sc.nextInt();
            if (p1 > n) throw new Exception();
            graph.get(p1).add(new Edge(p2, p3));

        }
        int start = 1, end = n;
        int max = 0x3f3f3f3f;
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, max);

        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            return b.dis - a.dis;
        });

        pq.add(new Pair(start, 0));
        minDist[start] = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            if (visited[cur.node]) continue;

            visited[cur.node] = true;

            for (Edge edge : graph.get(cur.node)) {
                if (!visited[edge.tar] && minDist[cur.node] + edge.val < minDist[edge.val]) {
                    minDist[edge.tar] = minDist[cur.node] + edge.val;
                    pq.add(new Pair(edge.tar, minDist[edge.tar]));
                }
            }
        }

        if (minDist[end] == max) System.out.println(-1);
        else System.out.println(minDist[end]);
        sc.close();
    }

    static void dijkstraHeapMatrix() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int max = 0x3f3f3f3f;
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; ++i) {
            Arrays.fill(graph[i], max);
        }
        int p1, p2, p3;
        for (int i = 0; i < m; ++i) {
            p1 = sc.nextInt();
            p2 = sc.nextInt();
            p3 = sc.nextInt();
            graph[p1][p2] = p3;
        }

        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, max);
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        //优先队列 id代表几号车站，dis代表距离原点的距离
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            //小顶堆，如果大于则true
            return a.dis - b.dis;
        });
        minDist[1] = 0;
        pq.offer(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.id]) continue;

            visited[cur.id] = true;

            for (int v = 1; v <= n; ++v) {
                if (!visited[v] && graph[cur.id][v] != max && minDist[cur.id] + graph[cur.id][v] < minDist[v]) {
                    minDist[v] = minDist[cur.id] + graph[cur.id][v];
                    pq.offer(new Node(v, minDist[v]));
                }
            }
        }
        if (minDist[n] == max) System.out.println(-1);
        else System.out.println(minDist[n]);
        sc.close();
    }
}

class Node {
    int id;
    int dis;

    Node(int id, int dis) {
        this.id = id;
        this.dis = dis;
    }
}

class Edge {
    int tar;
    int val;

    Edge(int tar, int val) {
        this.tar = tar;
        this.val = val;
    }
}

class Pair {
    int node;
    int dis;

    Pair(int node, int dis) {
        this.dis = dis;
        this.node = node;
    }
}