// 题目信息
// 给一个序列a1到an，和一个d。an数组排序后，后一个数减去前一个数的最大值不小于d，
// 请问最多能从an中选出多少满足条件的数字

//3 1 5 7
//1

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] stringArr = input.split(" ");
        int[] arr = new int[stringArr.length];
        for (int i = 0; i < stringArr.length; i++) {
            arr[i] = Integer.parseInt(stringArr[i]);
        }

        int d = sc.nextInt();
        Arrays.sort(arr);
        if (arr.length == 0) {
            System.out.println(0);
            return;
        } else {
            int pre, cur;
            pre = arr[0];
            int ans = 0;
            for (int i = 1; i < arr.length; i++) {
                cur = arr[i];
                if (cur - pre >= d) {
                    ans++;
                    pre = cur;
                }
            }
            if (ans != 0) ans++;
            System.out.println(ans);
        }


//        System.out.println(Arrays.toString(arr));
//        System.out.println(d);

    }
}