import java.util.Scanner;

/**
 * 
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            int h = sc.nextInt();
            float w = sc.nextFloat();
            float bmi = w * 100 * 100 / (h * h);
            String result="";
            if (bmi < 18.5)
                result = "过轻";
            else if (bmi >= 18.5 && bmi < 24)
                result = "正常";
            else if (bmi >= 24 && bmi < 28)
                result = "超重";
            else if (bmi >= 28)
                result = "肥胖";
            System.out.printf("%.2f %s\n", bmi, result);
        }
    }
}
