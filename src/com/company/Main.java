package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int firstJan = input.nextInt();
        int[][] calendar = generatingCalendar(firstJan);

        printCalendar(firstJan, 11, calendar);
        byte choice;
//        while (true) {
//            System.out.println("What day of the week is 1-st January?" + "\n" +
//                    "Choose from 1 to 7, where 1 equals Monday and 7 equals Sunday");
//            firstJan = input.nextInt();
//            outputOptions();
//            choice = input.nextByte();
//            switchChoice(choice);
//
//
//        }
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

    public static void switchChoice(byte choice, int firstJan) {
        Scanner input = new Scanner(System.in);
        int day, month, year;
        switch (choice) {
            case 1:
                System.out.println("Input the date in format d m y");
                day = input.nextInt();
                month = input.nextInt();
                year = input.nextInt();
                if (checkingCorrectnessOfDate(day, month, year)) {
                    System.out.println("Correct date");
                } else System.out.println("Incorrect date");
                break;
            case 2:
                System.out.print("Input the date");
                day = input.nextInt();
                month = input.nextInt();
                year = input.nextInt();
                if (checkingCorrectnessOfDate(day, month, year)) {
                    displayDateInChosenFormat(day, month, year);
                } else System.out.println("The date is incorrect");
                break;
            case 3:
                day = input.nextInt();
                month = input.nextInt();
                defineDayOfWeekByDate(day, month, firstJan);
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

    public static int[][] generatingCalendar(int firstJan) {
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
        return calendar;
    }

    public static boolean checkingCorrectnessOfDate(int day, int month, int year) {
        System.out.println("Input the date in format dd mm yyyy ");
        boolean checkedDate = false;
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
                    checkedDate = true;
                }
                break;
            case 2:
                if (day > 0 && day < 30) {
                    checkedDate = true;
                } else if (day == 29) {
                    checkedDate = true;
                }
                break;
            default:
                checkedDate = false;
        }

        return checkedDate;
    }

    public static void displayDateInChosenFormat(int day, int month, int year) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose format: \n" +
                " 1)dd/MM/yyyy \n" +
                " 2)MM/dd/yyyy \n" +
                " 3)dd-MMM-yyyy ");
        byte chosenFormat = input.nextByte();
        String formattedDate = null;
        switch (chosenFormat) {
            case 1:
                if (month < 10) {
                    if (day < 10) {
                        formattedDate = "0" + day + "/0" + month + year;
                    } else if (day > 10) {
                        formattedDate = day + "/0" + month + year;
                    }
                    if (month > 10) {
                        if (day < 10) {
                            formattedDate = "0" + day + "/" + month + year;
                        } else if (day > 10) {
                            formattedDate = day + "/" + month + year;
                        }
                    }
                }
                break;
            case 2:
                if (month < 10) {
                    if (day < 10) {
                        formattedDate = "0" + month + "/0" + day + "/" + year;
                    } else if (day > 10) {
                        formattedDate = "/0" + month + "/" + day + "/" + year;
                    }
                    if (month > 10) {
                        if (day < 10) {
                            formattedDate = month + "/0" + day + "/" + +year;
                        } else if (day > 10) {
                            formattedDate = month + "/" + day + "/" + year;
                        }
                    }
                }
                break;
            case 3:
                if (day < 10) {
                    System.out.print("0" + day + "-");
                }
                if (day > 10) {
                    System.out.print(day + "-");
                }
                switch (month) {
                    case 1:
                        System.out.print("Jan-");
                        break;
                    case 2:
                        System.out.print("Feb-");
                        break;
                    case 3:
                        System.out.print("Mar-");
                        break;
                    case 4:
                        System.out.print("Apr-");
                        break;
                    case 5:
                        System.out.print("May-");
                        break;
                    case 6:
                        System.out.print("Jun");
                        break;
                    case 7:
                        System.out.print("Jul");
                        break;
                    case 8:
                        System.out.print("Aug-");
                        break;
                    case 9:
                        System.out.print("Sep-");
                        break;
                    case 10:
                        System.out.print("Oct-");
                        break;
                    case 11:
                        System.out.print("Nov-");
                        break;
                    case 12:
                        System.out.print("Dec-");
                        break;
                }
                System.out.print(year);
        }
    }

    public static void defineDayOfWeekByDate(int day, int month, int firstJan) {
        int[][] year = generatingCalendar(firstJan);
        switch (year[month - 1][day - 1]) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
        }
    }

    public static void printCalendar(int firstJan, int month, int calendar[][]) {
//        int help = 0;
//        System.out.println("Mo Tu We Th Fr Sа Su");
//        for (int k = firstJan - 1; k > 1; k--) {
//            System.out.print("   ");
//        }
//        for (int i = 0; i < calendar[month - 1].length; i++) {
//            if (i<9){
//                System.out.print((calendar[month][i]+help) + "  ");
//            } else {
//                System.out.print((calendar[month][i]+help) + " ");
//            }
//            if(calendar[month][i] == 7){
//                System.out.println();
//                help +=7;
//            }
//        }
    }
}







