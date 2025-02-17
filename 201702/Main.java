import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        String[] nums = input.split("-");
        int cent = 10;
        int s = 0;
        for (int i = 0; i < nums[0].length(); ++i) {
            s += (nums[0].charAt(i) - '0') * cent;
            cent--;
        }
        for (int i = 0; i < nums[1].length(); ++i) {
            s += (nums[1].charAt(i) - '0') * cent;
            cent--;
        }
        for (int i = 0; i < nums[2].length(); ++i) {
            s += (nums[2].charAt(i) - '0') * cent;
            cent--;
        }
        int m = s % 11;
        String ans;
        if (11 - m == 10) {
            ans = input += "-X";
        } else if (11 - m == 11) {
            ans = input + "-0";
        } else {
            ans = input + "-" + String.valueOf(m);
        }

        System.out.println(ans);
    }
}
