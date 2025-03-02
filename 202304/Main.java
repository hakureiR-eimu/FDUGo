import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] preorder = new int[n];
        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }
        int[] inorder = preorder.clone();
        Arrays.sort(inorder);
        Node root = build(preorder, inorder);
        flatorder(root);

    }

    static Node build(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; ++i) {
            inorderMap.put(inorder[i], i);
        }


        return dfs(preorder, inorder, inorderMap, 0, preorder.length - 1, 0, preorder.length - 1);
    }

    static Node dfs(int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) return null;
        else if (preLeft == preRight) return new Node(preorder[preLeft]);
        else {
            int rootVal = preorder[preLeft];
            //不包括root的节点数
            //root preleft rootPos
            //left
            //int totalNum = preRight - preLeft;
            int rootPos = inorderMap.get(rootVal);
            int leftNum = rootPos - inLeft;
            int rightNum = inRight - rootPos;//inright-rootPos
            Node root = new Node(rootVal);
            root.left = dfs(preorder, inorder, inorderMap, preLeft + 1, preLeft + leftNum, rootPos - leftNum, rootPos - 1);
            root.right = dfs(preorder, inorder, inorderMap, preLeft + leftNum + 1, preRight, rootPos + 1, rootPos + rightNum);
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