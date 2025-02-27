import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str1 = sc.nextLine().toCharArray();
        char[] str2 = sc.nextLine().toCharArray();
//        System.out.println(str1);
//        System.out.println(str2);
        TreeNode root1 = buildTree(str1);
        TreeNode root2 = buildTree(str2);
        Solution sol = new Solution();
        System.out.println(sol.isSubStructure(root1, root2));
        //preorder(root1);

    }

    static TreeNode buildTree(char[] str) {
        if (str == null || str.length == 0) return null;
        TreeNode[] nodes = new TreeNode[str.length];
        for (int i = 0; i < str.length; i++) {
            nodes[i] = new TreeNode(str[i]);
        }
        for (int i = 0; i < str.length / 2; ++i) {
            if (str[i] != '#') {
                int left = i * 2 + 1;
                int right = i * 2 + 2;

                if (str[left] != '#') {
                    nodes[i].left = new TreeNode(str[left]);
                }
                if (str[right] != '#') {
//                    if (right == 6) {
//                        System.out.printf("%c %d\n", str[right], i);
//                    }
                    nodes[i].right = new TreeNode(str[right]);
                }
            }
        }
        return nodes[0];
    }

    static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.printf("%c", root.val);
        preorder(root.left);
        preorder(root.right);
    }
}

class TreeNode {
    char val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(char val) {
        this.val = val;
    }

    TreeNode(char val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;

        if (check(A, B)) return true;
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    boolean check(TreeNode A, TreeNode B) {
        if (A != null && B != null) {
            if (A.val == B.val) return check(A.left, B.left) && check(A.right, B.right);
            else return false;
        } else {
            if (A == null && B != null) return false;
            else return true;
        }
//        if (B == null) return true;
//        if (A == null || A.val != B.val) return false;
//        return check(A.left, B.left) && check(A.right, B.right);
//        if (A == null && B == null) return true;
//        if (A == null || B == null) return false;
//        if (A.val != B.val) return false;
//        return check(A.left, B.left) && check(A.right, B.right);
    }
}