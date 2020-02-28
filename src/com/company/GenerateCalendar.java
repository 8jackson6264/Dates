package com.company;

import java.util.Arrays;

public class GenerateCalendar {
    public static void main(String[] args) {
        int firstDay = 3;
        int[][] calendar = new int[12][31];
        int day;
        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                day = (firstDay % 7 != 0 ? firstDay % 7 : 7);
                if (i == 1 && j == 29){
                    break;
                } else if (i<7 && i%2 == 1 && j==30){
                    break;
                } else if (i>6 && i%2 == 0 && j == 30){
                    break;
                }
                calendar[i][j] = day;
                firstDay++;
            }
        }

        for (int i = 0; i < calendar.length; i++) {
            System.out.println(Arrays.toString(calendar[i]));
        }

        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                switch (calendar[i][j]) {
                    case 1:
                        System.out.print("Понеделник ");
                        break;
                    case 2:
                        System.out.print("Вторник ");
                        break;
                    case 3:
                        System.out.print("Сряда ");
                        break;
                    case 4:
                        System.out.print("Четвъртък ");
                        break;
                    case 5:
                        System.out.print("Петък ");
                        break;
                    case 6:
                        System.out.print("Събота ");
                        break;
                    case 7:
                        System.out.print("Неделя ");
                        break;
                }
                if (j%7 == 6) System.out.println();
            }
            System.out.println("\n");
        }

    }
}
