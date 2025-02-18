import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(",");
        //3 1 4 3 null 1 5
        Node[] tree = new Node[arr.length];
        Node root = build(arr, tree, 0);
        int ans = dfs(root);
        System.out.println(ans);
    }

    static Node build(String[] arr, Node[] tree, int index) {

        if (arr[index].equals("null")) return null;
        else {
            int val = Integer.parseInt(arr[index]);
            Node node = new Node(val);
            tree[index] = node;
            if (index * 2 + 1 < arr.length) {
                node.left = build(arr, tree, index * 2 + 1);
            }
            if (index * 2 + 2 < arr.length) {
                node.right = build(arr, tree, index * 2 + 2);
            }

            if (index != 0) node.fa = tree[(index - 1) / 2];
            return node;
        }
    }

    static boolean isImportant(Node node) {
        if (node == null) return false;
        else {
//            boolean flag=true;
            int val = node.val;
            while (node != null) {
                node = node.fa;
                if (node == null) break;
                if (node.val > val) {
                    return false;
                }
            }
        }
        return true;
    }

    static int dfs(Node root) {
        if (root == null) return 0;
        else {
            if (isImportant(root)) {
                return 1 + dfs(root.left) + dfs(root.right);
            } else {
                return dfs(root.left) + dfs(root.right);
            }
        }
    }
}

class Node {
    int val;
    Node left, right, fa;

    Node(int _val) {
        val = _val;
    }
}
