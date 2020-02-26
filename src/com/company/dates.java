package com.company;

import java.util.Scanner;

public class dates {

    int[][][] year = new int[12][6][7];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte choice;
        while (true) {
            System.out.println("What day of the week is 1-st January?" + "\n" +
                    "Choose from 1 to 7, where 1 equals Monday and 7 equals Sunday");
            int firstJan = input.nextInt();
            date(firstJan);
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("Choose one of the functions you want the program to complete for you: ");
            System.out.println("1) Check the correctness of the data");
            System.out.println("2) displaying te data in the console in choiosen by you format");
            System.out.println("3) write down in the console a data and based on it the prgram will define what day of the week it is");
            System.out.println("4) using a description of day of the week the program will define the data which refers to the described day");
            System.out.println("5) print a calendar for a month choosed by you");
            System.out.println("If you want to close the program, intype 0.");
            choice = input.nextByte();


        }
    }

    public static void switchChoice(byte choice) {
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 0:
                System.exit(0);
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + choice);
        }
    }

    public static void generatingCalendar(int firstJan) {
//        String[] fullCalendar = new String[373];
//        int reminderDivisionSeven;
//        for (int i = 0; i < fullCalendar.length; i++) {
//            reminderDivisionSeven = i % 7;
//            switch (reminderDivisionSeven) {
//                case 0:
//                    fullCalendar[i] = "Понеделник";
//        int january = new[6][7];
//        int february = new[6][7];
//        int march = new[6][7];
//        int april = new[6][7];
//        int may = new[6][7];
//        int june = new[6][7];
//        int july = new[6][7];
//        int august = new[6][7];
//        int september = new[6][7];
//        int octomber = new[6][7];
//        int november = new[6][7];
//        int december = new[6][7];
//        int date = 1;
//        int lastDate;

    }

    static void date(int firstJanuary){
        int[][] calendar = new int[12][31];

        calendar[1][28] = 1;

        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j <calendar[i].length ; j++) {
                if (calendar[i][j] == 1) System.out.println("Понеделник");
                if ((j+1)%7 == 0) System.out.println();
            }
            System.out.println("\n \n \n");
        }
    }
}



