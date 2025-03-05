import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input = "-1+1";
        Solution sol = new Solution();
        int ans2 = sol.calculate("1+2+3");
        System.out.println(ans2);
    }
}

class Solution {
    Map<Character, Integer> map = new HashMap<>();

    String preCompute(String s) {
        s = s.replace(" ", "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '-') {
                if (i == 0 || s.charAt(i - 1) == '(') {
                    sb.append('0');
                }
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();

    }

    List<String> inCompute(String s) {
        char[] arr = s.toCharArray();
        List<String> ans = new ArrayList<>();
        Stack<Character> ops = new Stack<>();
        for (int i = 0; i < arr.length; ++i) {
            if (!map.containsKey(arr[i])) {
                int j = i;
                while (!map.containsKey(arr[j])) {
                    j++;
                    if (j == arr.length) {
                        break;
                    }
                }
                j--;
                int num = 0;
                for (int k = i; k <= j; ++k) {
                    num = num * 10;
                    num += arr[k] - '0';
                }
                ans.add(String.valueOf(num));
                i = j;
            } else {
                if (arr[i] == '(') {
                    ops.add('(');
                } else if (arr[i] == '+' || arr[i] == '-') {
                    if(!ops.isEmpty()&&(ops.peek()=='+'||ops.peek()=='-')){
                        ans.add(ops.pop().toString());
                        ops.add(arr[i]);
                    }
                    else{
                        ops.add(arr[i]);
                    }
                } else {
                    while (ops.peek() != '(') {
                        Character op = ops.pop();
                        ans.add(op.toString());
                    }
                    ops.pop();
                }
            }
        }
        while (!ops.isEmpty()) {
            ans.add(ops.pop().toString());
        }
        return ans;
    }

    Solution() {
        map.put('(', 0);
        map.put('+', 1);
        map.put('-', 1);
        map.put(')', 2);
    }

    public int calculate(String s) {
        s = preCompute(s);
        List<String> inCol = inCompute(s);
        Stack<Integer> ans = new Stack<>();
        for (String str : inCol) {
            if (str.equals("+")) {
                int b = ans.pop();
                int a = ans.pop();
                ans.push(a + b);
            } else if (str.equals("-")) {
                int b = ans.pop();
                int a = ans.pop();
                ans.push(a - b);
            } else {
                int num = Integer.parseInt(str);
                ans.push(num);
            }
        }
        return ans.pop();

    }
}