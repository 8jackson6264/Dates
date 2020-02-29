package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        byte choice;
        while (true) {
            System.out.println("What day of the week is 1-st January?" + "\n" +
                    "Choose from 1 to 7, where 1 equals Monday and 7 equals Sunday");
            int firstJan = input.nextInt();
            outputOptions();
            choice = input.nextByte();
            switchChoice(choice, firstJan);

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

    public static void switchChoice(byte choice, int firstJan) {
        Scanner input = new Scanner(System.in);
        int day, month, year;
        switch (choice) {
            case 1:
                System.out.print("Input the date in format d m y: ");
                day = input.nextInt();
                month = input.nextInt();
                year = input.nextInt();
                if (checkingCorrectnessOfDate(day, month, year)) {
                    System.out.println("Correct date");
                } else System.out.println("Incorrect date");
                break;
            case 2:
                System.out.print("Input the date: ");
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
                System.out.println("Write the description of the date using only lower case: ");
                String description = input.nextLine();
                dateByDescription(description, firstJan);
                break;
            case 5:
                int[][] calendar = generatingCalendar(firstJan);
                System.out.println("For which month do you want to print a calendar? \n" +
                        "Choose with numbers where 1 is for January and 12 is for December");
                month = input.nextInt();
                printCalendar(firstJan, month, calendar);
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
        System.out.println("Choose format: (1, 2, or 3)\n" +
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
        System.out.println();
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
        System.out.println();
    }

    public static void printCalendar(int firstJan, int month, int calendar[][]) {
        System.out.println("Mo Tu We Th Fr Sa Su");
        int firstDay = calendar[month - 1][0];
        int firstSunday = 8 - firstDay;
        int day = 1;
        for (int j = 0; j < firstDay - 1; j++) {
            System.out.print("   ");
        }
        for (int i = 0; i < 31; i++) {

            if (calendar[month - 1][i] == 0) {
                break;
            }
            if (day < 10) {

                System.out.print(" " + day + " ");
            } else System.out.print(day + " ");
            if ((day - firstSunday) % 7 == 0) {
                System.out.println("");
            }
            day++;
        }
        System.out.println("");
    }

    public static void dateByDescription(String description, int firstJan) {
        int dayNumber = 0, dayOfWeek = 0, month = 0;
        int[][] calendar = generatingCalendar(firstJan);
        if (description.contains("first")) {
            dayNumber = 1;
        } else if (description.contains("second")) {
            dayNumber = 2;
        } else if (description.contains("third")) {
            dayNumber = 3;
        } else if (description.contains("forth")) {
            dayNumber = 4;
        } else if (description.contains("fifth")) {
            dayNumber = 5;
        }

        if (description.contains("monday")) {
            dayOfWeek = 1;
        } else if (description.contains("tuesday")) {
            dayOfWeek = 2;
        } else if (description.contains("wednesday")) {
            dayOfWeek = 3;
        } else if (description.contains("thursday")) {
            dayOfWeek = 4;
        } else if (description.contains("friday")) {
            dayOfWeek = 5;
        } else if (description.contains("saturday")) {
            dayOfWeek = 6;
        } else if (description.contains("sunday")) {
            dayOfWeek = 7;
        }

        if (description.contains("january")) {
            month = 1;
        } else if (description.contains("february")) {
            month = 2;
        } else if (description.contains("march")) {
            month = 3;
        } else if (description.contains("april")) {
            month = 4;
        } else if (description.contains("may")) {
            month = 5;
        } else if (description.contains("june")) {
            month = 6;
        } else if (description.contains("july")) {
            month = 7;
        } else if (description.contains("august")) {
            month = 8;
        } else if (description.contains("september")) {
            month = 9;
        } else if (description.contains("october")) {
            month = 10;
        } else if (description.contains("november")) {
            month = 11;
        } else if (description.contains("december")) {
            month = 12;
        }

        if (dayNumber != 0) {
            int counter = 0;
            int date = 0;
            for (int i = 0; i < calendar[month - 1].length; i++) {
                if (calendar[month - 1][i] == dayOfWeek) {
                    date = i + 1;
                    counter++;
                }
                if (counter == dayNumber) break;
            }
            System.out.println("dd/mm ->" + date + "/" + month);
        } else if (description.contains("last")) {
            int date = 0;
            for (int i = 0; i < calendar[month - 1].length; i++) {
                if (calendar[month - 1][i] == dayOfWeek) {
                    date = i + 1;
                }
            }
            System.out.println("dd/mm ->" + date + "/" + month);
        } else {
            System.out.println("Wrong input!!!");
        }
    }
}








