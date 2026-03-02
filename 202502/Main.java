import java.util.Scanner;


public class Main {
    /**
     * 本人在考场上使用的办法，得分为90分
     * 使用数学逻辑对外层的圈跳过模拟直接运算结果可以得到更好的时间/空间复杂度
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        int[][] matrix = new int[n + 1][m + 1];

        /**
         * 1 2 3
         * 8 9 4
         * 7 6 5
         */
        int lineTop = 1, lineButton = n, colLeft = 1, colRight = m;
        int num = 1;
        while (lineTop <= lineButton && colLeft <= colRight) {
            for (int col = colLeft; col <= colRight; ++col) {
                int line = lineTop;
                matrix[line][col] = num;
                num++;
            }
            for (int line = lineTop + 1; line <= lineButton; ++line) {
                int col = colRight;
                matrix[line][col] = num;
                num++;
            }
            for (int col = colRight - 1; col >= colLeft; --col) {
                int line = lineButton;
                matrix[line][col] = num;
                num++;
            }
            for (int line = lineButton - 1; line > lineTop; --line) {
                int col = colLeft;
                matrix[line][col] = num;
                num++;
            }
            lineTop++;
            lineButton--;
            colLeft++;
            colRight--;
        }

        int T = sc.nextInt();
        for (int i = 0; i < T; ++i) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            System.out.println(matrix[x][y]);
        }


    }
}
