package com.company;

import java.util.Scanner;

public class Main {

    int[][][] year = new int[12][6][7];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte choice;
        while (true) {
            System.out.println("What day of the week is 1-st January?" + "\n" +
                    "Choose from 1 to 7, where 1 equals Monday and 7 equals Sunday");
            int firstJan = input.nextInt();
            outputOptions();
            choice = input.nextByte();
            switchChoice(choice);


        }
    }

    public static void outputOptions() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("Choose one of the functions you want the program to complete for you: ");
        System.out.println("1) Check the correctness of the date");
        System.out.println("2) displaying the date in the console in chosen by you format");
        System.out.println("3) write down in the console a date and based on it the program will define what day of the week it is");
        System.out.println("4) using a description of day of the week the program will define the date which refers to the described day");
        System.out.println("5) print a calendar for a month chosen by you");
        System.out.println("If you want to close the program, type 0.");
    }

    public static void switchChoice(byte choice) {
        Scanner input = new Scanner(System.in);
        switch (choice) {
            case 1:
                checkingCorrectnessOfDate(checkedDate);
                break;
            case 2:
                displayingDateInChosenFormat(d, m, y);
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
        int[][] calendar = new int[12][31];
        int day;
        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                day = (firstJan % 7 != 0 ? firstJan % 7 : 7);
                if (i == 1 && j == 29) {
                    break;
                } else if (i < 7 && i % 2 == 1 && j == 30) {
                    break;
                } else if (i > 6 && i % 2 == 0 && j == 30) {
                    break;
                }
                calendar[i][j] = day;
                firstJan++;
            }
        }
    }

    public static boolean checkingCorrectnessOfDate(boolean checkedDate) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input the date in format dd mm yyyy ");
        int day = input.nextInt();
        int month = input.nextInt();
        int year = input.nextInt();
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 0 && day < 32) {
                    checkedDate = true;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 0 && day < 31) {
                    System.out.println("correct date");
                } else System.out.println("incorrect date");
                break;
            case 2:
                if (day > 0 && day < 29) {
                    System.out.println("correct date");
                } else if (day == 29 && year % 4 == 0) {
                    System.out.println("correct date");
                } else System.out.println("incorrect date");
                break;
            default:
                checkedDate
        }


    }

    public static void displayingDateInChosenFormat(int d, int m, int y) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the date");
        d = input.nextInt();
        m = input.nextInt();
        y = input.nextInt();
        System.out.println("Choose format: \n" +
                " 1)dd/MM/yyyy \n" +
                " 2)MM/dd/yyyy \n" +
                " 3)dd-MMM-yyyy ");
        int formatDate = input.nextInt();
        String formattedDate = null;
        switch (formatDate) {
            case 1:
                switch (m) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                        if (d > 0 && d < 10) {
                            formattedDate = "0" + d + "/0" + m + "/" + y;
                        } else formattedDate= d + "/0" + m + "/" + y;
                    case 10:
                    case 12:
                        if (d > 0 && d < 10) {
                            formattedDate = "0" + d + "/" + m + "/" + y;
                        } else formattedDate = d + "/" + m + "/" + y;

                }
                System.out.println(formattedDate);
                break;
            case 2:
                switch (m) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                        if (d > 0 && d < 10) {
                            formattedDate = "0" + d + "/0" + m + "/" + y;
                        } else formattedDate = d + "/0" + m + "/" + y;
                    case 10:
                    case 12:
                        if (d > 0 && d < 10) {
                            formattedDate = "0" + d + "/" + m + "/" + y;
                        } else formattedDate = d + "/" + m + "/" + y;
                    case 2:
                        if (d > 0)

                }
                System.out.println(formattedDate);
                break;
            case 3:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + formatDate);
        }
    }
}





