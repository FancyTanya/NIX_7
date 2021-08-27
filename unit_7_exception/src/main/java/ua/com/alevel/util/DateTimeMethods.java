package ua.com.alevel.util;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import myException.MyException;
import ua.com.alevel.controller.Controller;
import ua.com.alevel.timeObject.Month;
import ua.com.alevel.timeObject.TimeObject;

import java.util.Scanner;

import static ua.com.alevel.controller.Controller.patternSelection;
import static ua.com.alevel.timeObject.Month.*;
import static ua.com.alevel.util.DateTimeConstants.*;

public class DateTimeMethods {
    TimeObject timeObject = new TimeObject();
    public Month month = new Month();

    public DateTimeMethods() throws MyException {
    }

    public static int timeInMillis(int days, int month, int year) {
        int timeInMillis = MILLISECONDS_IN_HOUR * HOUR_IN_DAY * days +
                MILLISECONDS_IN_HOUR * HOUR_IN_DAY * days * month +
                MILLISECONDS_IN_HOUR * HOUR_IN_DAY * days * month * year;
        return timeInMillis;
    }

    public static int getYearPatternOne(String inputTime) {
        // Pattern dd/mm/yy
        int year = 0;
        if (inputTime.contains("/")) {
            String[] split = inputTime.split("/");
            if (split.length != 0) {
                if (split.length == 3) {
                    year = Integer.parseInt(split[2]);
                }
            }
        }
        return year;
    }

    public static int setTimeDaysMonthYear(String inputTime) {
        // Pattern dd/mm/yy
        int days = 0;
        int month = 0;
        int year = 0;
        if (inputTime.contains("/")) {
            String[] split = inputTime.split("/");
            if (split.length != 0) {
                if (split.length == 3) {
                    days = Integer.parseInt(split[0]);
                    month = Integer.parseInt(split[1]);
                    year = Integer.parseInt(split[2]);
                }
            }
        }
        return timeInMillis(days, month, year);
    }


    public static int convertHoursMinutesInMillis(int hour, int minute) {
        int timeInMillis = MILLISECONDS_IN_HOUR * hour +
                MILLISECONDS_IN_MINUTE * minute;
        return timeInMillis;
    }

    public static int getYearPatternTwo(String inputTime) {
        // Pattern m/d/yyyy
        int year = 0;
        if (inputTime.contains("/")) {
            String[] split = inputTime.split("/");
            if (split.length != 0) {
                if (split.length == 3) {

                    year = Integer.parseInt(split[2]);
                }
            }
        }
        return year;
    }

    public static int setTimeMonthDaysYear(String inputTime) {
        // Pattern m/d/yyyy
        int days = 0;
        int month = 0;
        int year = 0;
        if (inputTime.contains("/")) {
            String[] split = inputTime.split("/");
            if (split.length != 0) {
                if (split.length == 3) {
                    month = Integer.parseInt(split[0]);
                    days = Integer.parseInt(split[1]);
                    year = Integer.parseInt(split[2]);
                }
            }
        }
        return timeInMillis(days, month, year);
    }

    public static int getYearPatternThree(String inputTime) throws MyException {
        // Pattern mmm-d-yy
        int year = 0;
        if (inputTime.contains("-")) {
            String[] split = inputTime.split("-");
            if (split.length != 0) {
                if (split.length == 3) {
                    year = Integer.parseInt(split[2]);
                }
            }
        }
        return year;
    }

    public static int setTimeMonthTitleDaysYear(String inputTime) throws MyException {
        // Pattern mmm-d-yy
        int days = 0;
        int month = 0;
        int year = 0;
        if (inputTime.contains("-")) {
            String[] split = inputTime.split("-");
            if (split.length != 0) {
                if (split.length == 3) {
                    month = findMonthCount(split[0]);
                    days = Integer.parseInt(split[1]);
                    year = Integer.parseInt(split[2]);
                }
            }
        }
        return timeInMillis(days, month, year);
    }

    public static int getYearDaysMonthTitleYear(String inputTime) throws MyException {
        // Pattern dd-mmm-yyyy
        int year = 0;
        if (inputTime.contains("-")) {
            String[] split = inputTime.split("-");
            if (split.length != 0) {
                if (split.length == 3) {
                    year = Integer.parseInt(split[2]);
                }
            }
        }
        return year;
    }

    public static int setDaysMonthTitleYear(String inputTime) throws MyException {
        // Pattern dd-mmm-yyyy
        int days = 0;
        int month = 0;
        int year = 0;
        if (inputTime.contains("-")) {
            String[] split = inputTime.split("-");
            if (split.length != 0) {
                if (split.length == 3) {
                    days = Integer.parseInt(split[0]);
                    month = findMonthCount(split[1]);
                    year = Integer.parseInt(split[2]);
                }
            }
        }
        return timeInMillis(days, month, year);
    }

    public static int setTimeHourMinute(String inputTime) {
        // Pattern 00:00
        int hour = 0;
        int minute = 0;
        if (inputTime.contains(":")) {
            String[] split = inputTime.split(":");
            if (split.length != 0) {
                if (split.length == 2) {
                    hour = Integer.parseInt(split[0]);
                    minute = Integer.parseInt(split[1]);
                }
            }
        }
        return convertHoursMinutesInMillis(hour, minute);
    }

    public static int getYearPatternFour(String inputTime) throws MyException {
        // Pattern dd-mmm-yyyy 00:00
        String date = "";
        String time = "";
        if (inputTime.contains(" ")) {
            String[] split = inputTime.split(" ");
            if (split.length != 0) {
                if (split.length == 2) {
                    date = split[0];
                }
            }
        }
        return getYearDaysMonthTitleYear(date);
    }

    public static int setDaysMonthTitleYearTime(String inputTime) throws MyException {
        // Pattern dd-mmm-yyyy 00:00
        String date = "";
        String time = "";
        if (inputTime.contains(" ")) {
            String[] split = inputTime.split(" ");
            if (split.length != 0) {
                if (split.length == 2) {
                    date = split[0];
                    time = split[1];
                }
            }
        }
        return setDaysMonthTitleYear(date) + setTimeHourMinute(time);
    }

    public static int periodBetweenTwoDatesInMillis(String startDate, String finishDate) {
        int periodBetweenTwoDatesInMillis = 0;
        if (patternSelection == 1) {
            periodBetweenTwoDatesInMillis = setTimeDaysMonthYear(finishDate) - setTimeDaysMonthYear(startDate);
        }
        if (patternSelection == 2) {
            periodBetweenTwoDatesInMillis = setTimeMonthDaysYear(finishDate) - setTimeMonthDaysYear(startDate);
        }
        if (patternSelection == 3) {
            try {
                periodBetweenTwoDatesInMillis = setTimeMonthTitleDaysYear(finishDate) - setTimeMonthTitleDaysYear(startDate);
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
        if (patternSelection == 4) {
            try {
                periodBetweenTwoDatesInMillis = setDaysMonthTitleYearTime(finishDate) - setDaysMonthTitleYearTime(startDate);
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
        return periodBetweenTwoDatesInMillis;
    }

    public static String dateStringOutput(String startDate, String finishDate) {
        int year = 0;
        int month = 0;
        int days = 0;
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        int millis = 0;

        int periodBetweenTwoDatesInMillis = periodBetweenTwoDatesInMillis(startDate, finishDate);
            if (checkIsLeapYear(getYearPatternOne(startDate))) {
                year = periodBetweenTwoDatesInMillis/(DAYS_IN_LEAP_YEAR * HOUR_IN_DAY * SECONDS_IN_HOUR * MILLISECONDS_IN_SECOND);
            }
            year = periodBetweenTwoDatesInMillis/(DAYS_IN_YEAR * HOUR_IN_DAY * SECONDS_IN_HOUR * MILLISECONDS_IN_SECOND);
            month = periodBetweenTwoDatesInMillis/(MONTH_IN_YEAR * HOUR_IN_DAY * SECONDS_IN_HOUR * MILLISECONDS_IN_SECOND);
            days = periodBetweenTwoDatesInMillis/ (MILLISECONDS_IN_HOUR * HOUR_IN_DAY);
            hours = periodBetweenTwoDatesInMillis/ MILLISECONDS_IN_HOUR;
            minutes = periodBetweenTwoDatesInMillis/ MILLISECONDS_IN_MINUTE;
            seconds = periodBetweenTwoDatesInMillis/ MILLISECONDS_IN_SECOND;
            millis = periodBetweenTwoDatesInMillis;

            return "Period between two dates is: " + "\n" +
                    "year: " + year + "\n" +
                    "month: " + month + "\n" +
                    "days: " + days + "\n" +
                    "hours: " + hours + "\n" +
                    "minutes: " + minutes + "\n" +
                    "seconds: " + seconds + "\n" +
                    "millis" + millis + "\n" ;

        }



    private static int findMonthCount(String month) throws MyException {
        switch (month) {
            case JANUARY:
                return JANUARY.getMonthCount();
            break;
            case FEBRUARY:
                return FEBRUARY.getMonthCount();
            break;
            case MARCH:
                return MARCH.getMonthCount();
            break;
            case APRIL:
                return APRIL.getMonthCount();
            break;
            case MAY:
                return MAY.getMonthCount();
            break;
            case JUNE:
                return JUNE.getMonthCount();
            break;
            case JULY:
                return JULY.getMonthCount();
            break;
            case AUGUST:
                return AUGUST.getMonthCount();
            break;
            case SEPTEMBER:
                return SEPTEMBER.getMonthCount();
            break;
            case OCTOBER:
                return OCTOBER.getMonthCount();
            break;
            case NOVEMBER:
                return NOVEMBER.getMonthCount();
            break;
            case DECEMBER:
                return DECEMBER.getMonthCount();
            break;
            default:
                throw new MyException("Please enter correct month.");
        }
    }

    public static boolean checkIsLeapYear(int year) {
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }


}
