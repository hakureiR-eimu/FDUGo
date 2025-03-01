import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        String[] inputs = sc.nextLine().split("=");
        char[] left = inputs[0].toCharArray();
        char[] right = inputs[1].toCharArray();

        int leftNum = 0, leftX = 0, rightNum = 0, rightX = 0;

        for (int i = 0; i <= left.length; ++i) {
            if (i == left.length) {
                if (i == 1) {
                    leftNum += (int) (left[i - 1] - '0');
                } else if (left[i - 1] == 'x') {
                    leftX += getXNum(left, i - 2);
                } else {
                    leftNum += getXNum(left, i - 1);
                }
            } else if (left[i] == '+' || left[i] == '-') {
                if (i - 1 == 0) {
                    if (left[i - 1] == 'x') {
                        leftX++;
                    } else leftNum += (int) (left[i - 1] - '0');
                } else if (left[i - 1] == 'x') {
                    leftX += getXNum(left, i - 2);
                } else {
                    leftNum += getXNum(left, i - 1);
                }
            }

        }
        for (int i = 0; i <= right.length; ++i) {
            if (i == right.length) {
                if (i == 1) {
                    rightNum += (int) (right[i - 1] - '0');
                } else if (right[i - 1] == 'x') {
                    rightX += getXNum(right, i - 2);
                } else {
                    rightNum += getXNum(right, i - 1);
                }
            } else if (right[i] == '+' || right[i] == '-') {
                if (i - 1 == 0) {
                    if (right[i - 1] == 'x') {
                        rightX++;
                    } else rightNum += (int) (right[i - 1] - '0');
                } else if (right[i - 1] == 'x') {
                    rightX += getXNum(right, i - 2);
                } else {
                    rightNum += getXNum(right, i - 1);
                }
            }

        }
        //System.out.printf("%d %d %d %d\n", leftNum, leftX, rightNum, rightX);
        int Xnum = leftX - rightX;
        int num = rightNum - leftNum;
        if (Xnum == 0 && num == 0) {
            System.out.println("infinite solutions");
        } else if (Xnum == 0 && num != 0) {
            System.out.println("no solution");
        } else {
            int res = num / Xnum;
            System.out.printf("x=%d", res);
        }
        sc.close();
//        char[] arr = "2x+5".toCharArray();
//        System.out.println(getXNum(arr, 3));
    }

    static int getXNum(char[] arr, int index) {
        if (index < 0) return 1;
        else {
            int ans = 0;
            int cur = 1;
            while (index >= 0) {
                if (arr[index] == '+' || arr[index] == '-') {
                    if (arr[index] == '-') ans = -ans;
                    return ans;
                } else {
                    ans += (int) (arr[index] - '0') * cur;
                    cur *= 10;
                    index--;
                }
            }
            return ans;
        }
    }
}
