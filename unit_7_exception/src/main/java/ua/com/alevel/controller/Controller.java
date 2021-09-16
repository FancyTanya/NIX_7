package ua.com.alevel.controller;

import myException.MyException;

import java.util.Scanner;

import static ua.com.alevel.util.DateTimeConstants.*;
import static ua.com.alevel.util.DateTimeMethods.*;

public class Controller {
    public static int patternSelection = 0;
    public static int methodsSelection = 0;
    public static int addSelection = 0;
    Scanner scanner = new Scanner(System.in);


    public  void setup() {
        startMenu();
        if (patternSelection < 0 || patternSelection > 4) {
            System.out.println("Please, enter correct number");
            startMenu();
        }
        menuWithFunctions();
        if (methodsSelection == 0) {
            startMenu();
        }
        if (methodsSelection < 0 || methodsSelection > 4) {
            System.out.println("Please, enter correct number");
            menuWithFunctions();
        }
        if (methodsSelection == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the start date for the calculation");
            String startDate = scanner.nextLine();
            System.out.println("Enter the end date for calculation");
            String endDate = scanner.nextLine();
            dateStringOutput(startDate, endDate);
        }
        if (methodsSelection == 2) {

            System.out.println("Enter the start date for the calculation");
            String startDate = scanner.nextLine();
            menuAdditionTime();
            if (addSelection < 0 || addSelection > 5) {
                System.out.println("Please, enter correct number");
                menuAdditionTime();
            }
            if (addSelection == 0) {
                startMenu();
            }
            if (addSelection == 1) {
                System.out.println("Please, enter YEAR addition");
                String addition = scanner.nextLine();
                try {
                    addYearToDate(startDate, addition);
                } catch (MyException e) {
                    System.out.println("Please, enter correct data");
                    menuWithFunctions();
                }
            }
            if (addSelection == 2) {
                System.out.println("Please, enter MONTH addition");
                String addition = scanner.nextLine();
                try {
                    addMonthToDate(startDate, addition);
                } catch (MyException e) {
                    System.out.println("Please, enter correct data");
                    menuWithFunctions();
                }
            }
            if (addSelection == 3) {
                System.out.println("Please, enter DAYS addition");
                String addition = scanner.nextLine();
                try {
                    addDaysToDate(startDate, addition);
                } catch (MyException e) {
                    System.out.println("Please, enter correct data");
                    menuWithFunctions();
                }
            }
            if (addSelection == 4) {
                System.out.println("Please, enter HOURS addition");
                String addition = scanner.nextLine();
                try {
                    addHoursToDate(startDate, addition);
                } catch (MyException e) {
                    System.out.println("Please, enter correct data");
                    menuWithFunctions();
                }
            }
            if (addSelection == 5) {
                System.out.println("Please, enter MINUTES addition");
                String addition = scanner.nextLine();
                try {
                    addMinutesToDate(startDate, addition);
                } catch (MyException e) {
                    System.out.println("Please, enter correct data");
                    menuWithFunctions();
                }
            }
        }
        if (methodsSelection == 3) {

            System.out.println("Enter the start date for the calculation");
            String startDate = scanner.nextLine();
            menuAdditionTime();
            if (addSelection < 0 || addSelection > 5) {
                System.out.println("Please, enter correct number");
                menuAdditionTime();
            }
            if (addSelection == 0) {
                startMenu();
            }
            if (addSelection == 1) {
                System.out.println("Please, enter YEAR subtraction as a negative number");
                String addition = scanner.nextLine();
                try {
                    addYearToDate(startDate, addition);
                } catch (MyException e) {
                    System.out.println("Please, enter correct data");
                    menuAdditionTime();
                }
            }
            if (addSelection == 2) {
                System.out.println("Please, enter MONTH subtraction as a negative number");
                String addition = scanner.nextLine();
                try {
                    addMonthToDate(startDate, addition);
                } catch (MyException e) {
                    System.out.println("Please, enter correct data");
                    menuAdditionTime();
                }
            }
            if (addSelection == 3) {
                System.out.println("Please, enter DAYS subtraction as a negative number");
                String addition = scanner.nextLine();
                try {
                    addDaysToDate(startDate, addition);
                } catch (MyException e) {
                    System.out.println("Please, enter correct data");
                    menuAdditionTime();
                }
            }
            if (addSelection == 4) {
                System.out.println("Please, enter HOURS subtraction as a negative number");
                String addition = scanner.nextLine();
                try {
                    addHoursToDate(startDate, addition);
                } catch (MyException e) {
                    System.out.println("Please, enter correct data");
                    menuAdditionTime();
                }
            }
            if (addSelection == 5) {
                System.out.println("Please, enter MINUTES subtraction as a negative number");
                String addition = scanner.nextLine();
                try {
                    addMinutesToDate(startDate, addition);
                } catch (MyException e) {
                    System.out.println("Please, enter correct data");
                    menuAdditionTime();
                }
            }
        }
        if (methodsSelection == 4) {

            System.out.println("Enter first date for sorting");
            String firstDate = scanner.nextLine();
            System.out.println("Enter second date for sorting");
            String secondDate = scanner.nextLine();
            try {
                dateSorting(firstDate, secondDate);
            } catch (MyException e) {
                System.out.println("Please, enter correct data");
                menuAdditionTime();
            }
        }


    }

    public  void startMenu() {
        String encoding = System.getProperty("console.encoding", "utf-8");
        Scanner scanner = new Scanner(System.in, encoding);
        System.out.println("------------------------------------");
        System.out.println("Welcome to the Calendar Application!");
        System.out.println("Please select date format for processing");
        System.out.println(PATTERN_DAY_MONTH_YEAR + " For select enter 1");
        System.out.println(PATTERN_MONTH_DAY_YEAR + " For select enter 2");
        System.out.println(PATTERN_MONTH_TITLE_DAY_YEAR + " For select enter 3");
        System.out.println(PATTERN_DAY_MONTH_YEAR_HOUR_MINUTE + " For select enter 4");
        System.out.println("------------------------------------");

        while (!scanner.hasNextInt()) {
            System.out.println("That is not a number!");
            scanner.next();
        }

        patternSelection = scanner.nextInt();
    }

    public  void menuWithFunctions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------");
        System.out.println("Please, select a function for working with dates");
        System.out.println("Find time difference between dates. For select enter 1");
        System.out.println("Add minutes, hours, days and years to the date. For select enter 2");
        System.out.println("Subtract from date minutes, hours, days and years to the date. For select enter 3");
        System.out.println("Compare list of dates in descending and ascending order. For select enter 4");
        System.out.println("If you want to return to the start menu enter 0");
        System.out.println("------------------------------------");

        while (!scanner.hasNextInt()) {
            System.out.println("That is not a number!");
            scanner.next();
        }
        methodsSelection = scanner.nextInt();
    }

    public  void menuAdditionTime() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------------------------");
        System.out.println("Please, select a function for working with dates");
        System.out.println("If you want to add a YEAR to the date, enter 1");
        System.out.println("If you want to add a MONTH to the date, enter 2");
        System.out.println("If you want to add a DAY to the date, enter 3");
        System.out.println("If you want to add a HOUR to the date, enter 4");
        System.out.println("If you want to add a MINUTE to the date, enter 5");
        System.out.println("If you want to return to the start menu enter 0");
        System.out.println("------------------------------------");

        while (!scanner.hasNextInt()) {
            System.out.println("That is not a number!");
            scanner.next();
        }
        addSelection = scanner.nextInt();
    }

}
