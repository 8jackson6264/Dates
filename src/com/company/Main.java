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
                System.out.println("Input the date in format d m y");
                int day = input.nextInt();
                int month = input.nextInt();
                int year = input.nextInt();
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
                    displayingDateInChosenFormat(day, month, year);
                } else System.out.println("The date is incorrect");
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
                if (day > 0 && day < 29) {
                    checkedDate = true;
                } else if (day == 29 && year % 4 == 0) {
                    checkedDate = true;
                }
                break;
            default:
                checkedDate = false;
        }

        return checkedDate;
    }

    public static void displayingDateInChosenFormat(int day, int month, int year) {
        System.out.println("Choose format: \n" +
                " 1)dd/MM/yyyy \n" +
                " 2)MM/dd/yyyy \n" +
                " 3)dd-MMM-yyyy ");
        String formattedDate = null;
        switch (month) {
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
                        formattedDate = "0" + month + "/0" + day + year;
                    } else if (day > 10) {
                        formattedDate = "/0" + month + "/" + day + year;
                    }
                    if (month > 10) {
                        if (day < 10) {
                            formattedDate = month + "/0" + day + "/" + +year;
                        } else if (day > 10) {
                            formattedDate = month + "/" + day + year;
                        }
                    }
                }
                break;
            case 3:
                switch (month) {
                    case 1:
                        if (day < 10) {
                            formattedDate = "0" + day + "-" + "Jan" + "-" + year;
                        }
                        if (day > 10) {
                            formattedDate = day + "-" + "Jan" + "-" + year;
                        }
                        break;
                    case 2:
                        if (day < 10) {
                            formattedDate = "0" + day + "-" + "Feb" + "-" + year;
                        }
                        if (day > 10) {
                            formattedDate = day + "-" + "Feb" + "-" + year;
                        }
                        break;
                    case 3:
                        if (day < 10) {
                            formattedDate = "0" + day + "-" + "Mar" + "-" + year;
                        }
                        if (day > 10) {
                            formattedDate = day + "-" + "Mar" + "-" + year;
                        }
                        break;
                    case 4:
                        if (day < 10) {
                            formattedDate = "0" + day + "-" + "Apr" + "-" + year;
                        }
                        if (day > 10) {
                            formattedDate = day + "-" + "Apr" + "-" + year;
                        }
                        break;
                    case 5:
                        if (day < 10) {
                            formattedDate = "0" + day + "-" + "May" + "-" + year;
                        }
                        if (day > 10) {
                            formattedDate = day + "-" + "May" + "-" + year;
                        }
                        break;
                    case 6:
                        if (day < 10) {
                            formattedDate = "0" + day + "-" + "Jun" + "-" + year;
                        }
                        if (day > 10) {
                            formattedDate = day + "-" + "Jun" + "-" + year;
                        }
                        break;
                    case 7:
                        if (day < 10) {
                            formattedDate = "0" + day + "-" + "Jul" + "-" + year;
                        }
                        if (day > 10) {
                            formattedDate = day + "-" + "Jul" + "-" + year;
                        }
                        break;
                    case 8:
                        if (day < 10) {
                            formattedDate = "0" + day + "-" + "Aug" + "-" + year;
                        }
                        if (day > 10) {
                            formattedDate = day + "-" + "Aug" + "-" + year;
                        }
                        break;
                    case 9:
                        if (day < 10) {
                            formattedDate = "0" + day + "-" + "Sep" + "-" + year;
                        }
                        if (day > 10) {
                            formattedDate = day + "-" + "Sep" + "-" + year;
                        }
                        break;
                    case 10:
                        if (day < 10) {
                            formattedDate = "0" + day + "-" + "Oct" + "-" + year;
                        }
                        if (day > 10) {
                            formattedDate = day + "-" + "Oct" + "-" + year;
                            break;
                            case 11:
                                if (day < 10) {
                                    formattedDate = "0" + day + "-" + "Nov" + "-" + year;
                                }
                                if (day > 10) {
                                    formattedDate = day + "-" + "Nov" + "-" + year;
                                }
                                break;
                            case 12:
                                if (day < 10) {
                                    formattedDate = "0" + day + "-" + "Dec" + "-" + year;
                                }
                                if (day > 10) {
                                    formattedDate = day + "-" + "Dec" + "-" + year;
                                }
                                break;
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value");
                }
        }
    }
}





