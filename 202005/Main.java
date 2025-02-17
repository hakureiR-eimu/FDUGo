import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] input = new int[n];
        Map<Integer, Integer> faMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            input[i] = sc.nextInt();
        }
        Node no = new Node(0);
        Node root = no.build(input, faMap);
        for (int i = 1; i <= n; ++i) {
            System.out.printf("%d ", faMap.get(i));
        }
    }
}

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }

    Node build(int[] arr, Map<Integer, Integer> faMap) {
        if (arr.length == 0) return null;
        else {
            Node root = new Node(arr[0]);
            faMap.put(root.val, 0);
            for (int i = 1; i < arr.length; ++i) {
                Node locNode = loc(arr, root, i);
                faMap.put(arr[i], locNode.val);
                if (arr[i] > locNode.val) locNode.right = new Node(arr[i]);
                else locNode.left = new Node(arr[i]);
            }
            return root;
        }
    }

    Node loc(int[] arr, Node root, int index) {
        int val = arr[index];
        Node node = root;
        while (node != null) {
            if (val < node.val && node.left == null) return node;
            else if (val < node.val && node.left != null) node = node.left;
            else if (val > node.val && node.right == null) return node;
            else node = node.right;
        }
        return node;
    }
}
