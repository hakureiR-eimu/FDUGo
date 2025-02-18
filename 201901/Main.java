import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time1 = 20190205, time2 = sc.nextInt();
        // time2>=time1
        if (time1 > time2) {
            int temp = time1;
            time1 = time2;
            time2 = temp;
        }
        int day = 0;
        int[][] month = {{0, 0}, {31, 31}, {28, 29}, {31, 31}, {30, 30}, {31, 31}, {30, 30}, {31, 31}, {31, 31}, {30, 30}, {31, 31}, {30, 30}, {31, 31}};
        int year1 = time1 / 10000;
        int month1 = (time1 % 10000) / 100;
        int day1 = time1 % 100;

        int year2 = time2 / 10000;
        int month2 = (time2 % 10000) / 100;
        int day2 = time2 % 100;
        while (year1 < year2 || month1 < month2 || day1 < day2) {
            day1++;
            day++;
            if (day1 == month[month1][isRun(year1)] + 1) {
                day1 = 1;
                month1++;
            }
            if (month1 == 13) {
                month1 = 1;
                year1++;
            }

        }
        System.out.println(day);
    }


    static int isRun(int year) {
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            return 1;
        }
        return 0;
    }
}
