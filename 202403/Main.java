import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        int[][] mat1 = {{1,-5}};
        int[][] mat2 = {{12},{-1}};
        Solution sol = new Solution();
        int[][] ans = sol.multiply(mat1, mat2);
    }
}

class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m = mat1.length, k = mat1[0].length, n = mat2[0].length;
        Map<Integer, List<Node>> map1 = new HashMap<>();

        int[][] ans = new int[m][n];
        //ij jk
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < k; ++j) {
                if (mat1[i][j] != 0) {
                    if (!map1.containsKey(j)) {
                        List<Node> item = new ArrayList<>();
                        item.add(new Node(i, j, mat1[i][j]));
                        map1.put(j, item);
                    } else {
                        map1.get(j).add(new Node(i, j, mat1[i][j]));

                    }
                }
            }
        }
        for (int line = 0; line < k; ++line) {
            for (int col = 0; col < n; ++col) {
                if (mat2[line][col] != 0 && map1.containsKey(line)) {
                    List<Node> list = map1.get(line);
                    for (Node node : list) {
                        int x = node.x;
                        int y = col;
                        ans[x][y] += mat2[line][col] * node.val;
                    }
                }
            }
        }

        return ans;
    }

    class Node {
        int x, y, val;

        Node(int _x, int _y, int _val) {
            this.x = _x;
            this.y = _y;
            this.val = _val;
        }
    }
}