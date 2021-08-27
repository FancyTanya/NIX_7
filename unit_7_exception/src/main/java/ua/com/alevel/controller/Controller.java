package ua.com.alevel.controller;

import java.util.Scanner;

import static ua.com.alevel.util.DateTimeConstants.*;
import static ua.com.alevel.util.DateTimeMethods.*;

public class Controller {
    public static int patternSelection = 0;
    public int methodsSelection = 0;

    public void setup() {
        startMenu();
        if (patternSelection < 0 || patternSelection >4) {
            System.out.println("Please, enter correct number");
            startMenu();
        }

        menuWithFunctions();
        if (methodsSelection == 0) {
            startMenu();
        }
        if (methodsSelection < 0 || methodsSelection >4) {
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



    }

    public void startMenu() {
        Scanner scanner = new Scanner(System.in);
        patternSelection = scanner.nextInt();
        System.out.println("------------------------------------");
        System.out.println("Welcome to the Calendar Application!");
        System.out.println("Please select date format for processing");
        System.out.println(PATTERN_DAY_MONTH_YEAR + " For select enter 1");
        System.out.println(PATTERN_MONTH_DAY_YEAR + " For select enter 2");
        System.out.println(PATTERN_MONTH_TITLE_DAY_YEAR + " For select enter 3");
        System.out.println(PATTERN_DAY_MONTH_YEAR_HOUR_MINUTE + " For select enter 4");
        System.out.println("------------------------------------");
    }

    public void menuWithFunctions() {
        Scanner scanner = new Scanner(System.in);
        methodsSelection = scanner.nextInt();
        System.out.println("------------------------------------");
        System.out.println("Please, select a function for working with dates");
        System.out.println("Find time difference between dates. For select enter 1");
        System.out.println("Add minutes, hours, days and years to the date. For select enter 2");
        System.out.println("Subtract from date minutes, hours, days and years to the date. For select enter 3");
        System.out.println("Compare list of dates in descending and ascending order. For select enter 4");
        System.out.println("If you want to return to the start menu enter 0");
        System.out.println("------------------------------------");
    }

}
