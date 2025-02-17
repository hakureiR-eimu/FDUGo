import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = build(arr, 0, arr.length - 1);
        flatorder(root);

    }

    static Node build(int[] arr, int left, int right) {
        if (left > right || left >= arr.length || right >= arr.length) {
            return null;
        } else if (left == right) {
            return new Node(arr[left]);
        } else {
            Node root = new Node(arr[left]);
            int leftNum = 0;
            for (int i = left + 1; i <= right; ++i) {
                if (arr[i] < arr[left]) {
                    leftNum++;
                }
            }

            int leftLeft = left + 1, leftRight = left + leftNum, rightLeft = left + leftNum + 1, rightRight = right;
            root.left = build(arr, leftLeft, leftRight);
            root.right = build(arr, rightLeft, rightRight);
            return root;
        }
    }

    static void flatorder(Node root) {
        if (root == null) return;
        Queue<Node> que = new ArrayDeque<>();
        que.add(root);
        while (!que.isEmpty()) {
            for (int i = 0; i < que.size(); ++i) {
                Node node = que.poll();
                System.out.printf("%d ", node.val);
                if (node.left != null) que.offer(node.left);
                if (node.right != null) que.offer(node.right);
            }
        }
    }
}

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}