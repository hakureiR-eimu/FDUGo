import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        int x4 = sc.nextInt();
        int y4 = sc.nextInt();

        if ((y2 - y1) * (x4 - x3) == (y4 - y3) * (x2 - x1)) {
            System.out.println("Parallel or coincident");
        } else if (x1 == x2) {
            //x=x1
            //y=k2x+b2;
            double k2 = (double) (y4 - y3) / (x4 - x3);
            double b2 = -x3 * (double) (y4 - y3) / (x4 - x3) + y3;
            double x = (double) x1;
            double y = k2 * x + b2;
            System.out.printf("%.2f %.2f", x, y);
        } else if (x3 == x4) {
            double k1 = (double) (y2 - y1) / (x2 - x1);
            double b1 = -x1 * (double) (y2 - y1) / (x2 - x1) + y1;
            double x = (double) x3;
            double y = k1 * x + b1;
            System.out.printf("%.2f %.2f", x, y);
        } else {
            double k2 = (double) (y4 - y3) / (x4 - x3);
            double b2 = -x3 * (double) (y4 - y3) / (x4 - x3) + y3;
            double k1 = (double) (y2 - y1) / (x2 - x1);
            double b1 = -x1 * (double) (y2 - y1) / (x2 - x1) + y1;
            double x = (b2 - b1) / (k1 - k2);
            double y=k1*x+b1;
            System.out.printf("%.2f %.2f", x, y);
        }
    }
}
