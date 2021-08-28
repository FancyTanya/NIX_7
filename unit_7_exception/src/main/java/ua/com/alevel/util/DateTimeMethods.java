package ua.com.alevel.util;

import myException.MyException;
import ua.com.alevel.timeObject.Month;

import static ua.com.alevel.controller.Controller.patternSelection;
import static ua.com.alevel.timeObject.Month.*;
import static ua.com.alevel.util.DateTimeConstants.*;

public class DateTimeMethods {

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
                    month = findMonthCount(valueOf(split[0]));
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
                    month = findMonthCount(valueOf(split[1]));
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
            year = periodBetweenTwoDatesInMillis / (DAYS_IN_LEAP_YEAR * HOUR_IN_DAY * SECONDS_IN_HOUR * MILLISECONDS_IN_SECOND);
        }
        year = periodBetweenTwoDatesInMillis / (DAYS_IN_YEAR * HOUR_IN_DAY * SECONDS_IN_HOUR * MILLISECONDS_IN_SECOND);
        month = periodBetweenTwoDatesInMillis / (MONTH_IN_YEAR * HOUR_IN_DAY * SECONDS_IN_HOUR * MILLISECONDS_IN_SECOND);
        days = periodBetweenTwoDatesInMillis / (MILLISECONDS_IN_HOUR * HOUR_IN_DAY);
        hours = periodBetweenTwoDatesInMillis / MILLISECONDS_IN_HOUR;
        minutes = periodBetweenTwoDatesInMillis / MILLISECONDS_IN_MINUTE;
        seconds = periodBetweenTwoDatesInMillis / MILLISECONDS_IN_SECOND;
        millis = periodBetweenTwoDatesInMillis;

        return "Period between two dates is: " + "\n" +
                "year: " + year + "\n" +
                "month: " + month + "\n" +
                "days: " + days + "\n" +
                "hours: " + hours + "\n" +
                "minutes: " + minutes + "\n" +
                "seconds: " + seconds + "\n" +
                "millis" + millis + "\n";

    }


    private static int findMonthCount(Month month) throws MyException {
        switch (month) {
            case JANUARY:
                return JANUARY.getMonthCount();
            case FEBRUARY:
                return FEBRUARY.getMonthCount();

            case MARCH:
                return MARCH.getMonthCount();

            case APRIL:
                return APRIL.getMonthCount();

            case MAY:
                return MAY.getMonthCount();

            case JUNE:
                return JUNE.getMonthCount();

            case JULY:
                return JULY.getMonthCount();

            case AUGUST:
                return AUGUST.getMonthCount();

            case SEPTEMBER:
                return SEPTEMBER.getMonthCount();

            case OCTOBER:
                return OCTOBER.getMonthCount();

            case NOVEMBER:
                return NOVEMBER.getMonthCount();

            case DECEMBER:
                return DECEMBER.getMonthCount();

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

    public static String addYearToDate(String startDate, String addition) throws MyException {
        String days = "";
        String month = "";
        String year = "";
        if (patternSelection == 1) {
            // Pattern dd/mm/yy

            if (startDate.contains("/")) {
                String[] split = startDate.split("/");
                if (split.length != 0) {
                    if (split.length == 3) {
                        days = split[0];
                        month = split[1];
                        int temporaryYear = Integer.parseInt(addition) + Integer.parseInt(split[2]);
                        year += temporaryYear;
                    }
                }
            }
            return days + "/" + month + "/" + year;
        }
        if (patternSelection == 2) {
            // Pattern m/d/yyyy
            if (startDate.contains("/")) {
                String[] split = startDate.split("/");
                if (split.length != 0) {
                    if (split.length == 3) {
                        month = split[0];
                        days = split[1];
                        int temporaryYear = Integer.parseInt(addition) + Integer.parseInt(split[2]);
                        year += temporaryYear;
                    }
                }
                return month + "/" + days + "/" + year;
            }
        }
        if (patternSelection == 3) {
            // Pattern mmm-d-yy
            if (startDate.contains("-")) {
                String[] split = startDate.split("-");
                if (split.length != 0) {
                    if (split.length == 3) {
                        month = split[0];
                        days = split[1];
                        int temporaryYear = Integer.parseInt(addition) + Integer.parseInt(split[2]);
                        year += temporaryYear;
                    }
                }
            }
            return month + "-" + days + "-" + year;
        }
        if (patternSelection == 4) {
            // Pattern dd-mmm-yyyy 00:00
            String date = "";
            String time = "";
            if (startDate.contains(" ")) {
                String[] split = startDate.split(" ");
                if (split.length != 0) {
                    if (split.length == 2) {
                        date = split[0];
                        time = split[1];
                        if (date.contains("-")) {
                            String[] splitDate = date.split("-");
                            if (splitDate.length != 0) {
                                if (splitDate.length == 3) {
                                    days = splitDate[0];
                                    month = splitDate[1];
                                    int temporaryYear = Integer.parseInt(addition) + Integer.parseInt(splitDate[2]);
                                    year += temporaryYear;
                                }
                            }
                        }
                    }

                }
            }
            return days + "-" + month + "-" + year + " " + time;
        }
        return days + "/" + month + "/" + year;
    }

    public static String addMonthToDate(String startDate, String addition) throws MyException {
        String days = "";
        String month = "";
        String year = "";
        if (patternSelection == 1) {
            // Pattern dd/mm/yy

            if (startDate.contains("/")) {
                String[] split = startDate.split("/");
                if (split.length != 0) {
                    if (split.length == 3) {
                        days = split[0];
                        int temporaryMonth = Integer.parseInt(addition) + Integer.parseInt(split[1]);
                        month += temporaryMonth;
                        year = split[2];
                    }
                }
            }
            return days + "/" + month + "/" + year;
        }
        if (patternSelection == 2) {
            // Pattern m/d/yyyy
            if (startDate.contains("/")) {
                String[] split = startDate.split("/");
                if (split.length != 0) {
                    if (split.length == 3) {
                        int temporaryMonth = Integer.parseInt(addition) + Integer.parseInt(split[0]);
                        month += temporaryMonth;
                        days = split[1];
                        year = split[2];
                    }
                }
                return month + "/" + days + "/" + year;
            }
        }
        if (patternSelection == 3) {
            // Pattern mmm-d-yy
            if (startDate.contains("-")) {
                String[] split = startDate.split("-");
                if (split.length != 0) {
                    if (split.length == 3) {
                        int temporaryMonth = Integer.parseInt(addition) + Integer.parseInt(split[0]);
                        month += temporaryMonth;
                        days = split[1];
                        year = split[2];
                    }
                }
            }
            return month + "-" + days + "-" + year;
        }
        if (patternSelection == 4) {
            // Pattern dd-mmm-yyyy 00:00
            String date = "";
            String time = "";
            if (startDate.contains(" ")) {
                String[] split = startDate.split(" ");
                if (split.length != 0) {
                    if (split.length == 2) {
                        date = split[0];
                        time = split[1];
                        if (date.contains("-")) {
                            String[] splitDate = date.split("-");
                            if (splitDate.length != 0) {
                                if (splitDate.length == 3) {
                                    days = splitDate[0];
                                    int temporaryMonth = Integer.parseInt(addition) + Integer.parseInt(split[1]);
                                    month += temporaryMonth;
                                    year = splitDate[2];
                                }
                            }
                        }
                    }

                }
            }
            return days + "-" + month + "-" + year + " " + time;
        }
        return days + "/" + month + "/" + year;
    }

    public static String addDaysToDate(String startDate, String addition) throws MyException {
        String days = "";
        String month = "";
        String year = "";
        if (patternSelection == 1) {
            // Pattern dd/mm/yy

            if (startDate.contains("/")) {
                String[] split = startDate.split("/");
                if (split.length != 0) {
                    if (split.length == 3) {
                        int temporaryDays = Integer.parseInt(addition) + Integer.parseInt(split[0]);
                        days += temporaryDays;
                        month = split[1];
                        year = split[2];
                    }
                }
            }
            return days + "/" + month + "/" + year;
        }
        if (patternSelection == 2) {
            // Pattern m/d/yyyy
            if (startDate.contains("/")) {
                String[] split = startDate.split("/");
                if (split.length != 0) {
                    if (split.length == 3) {
                        month = split[0];
                        int temporaryDays = Integer.parseInt(addition) + Integer.parseInt(split[0]);
                        days += temporaryDays;
                        year = split[2];
                    }
                }
                return month + "/" + days + "/" + year;
            }
        }
        if (patternSelection == 3) {
            // Pattern mmm-d-yy
            if (startDate.contains("-")) {
                String[] split = startDate.split("-");
                if (split.length != 0) {
                    if (split.length == 3) {
                        month = split[0];
                        int temporaryDays = Integer.parseInt(addition) + Integer.parseInt(split[0]);
                        days += temporaryDays;
                        year = split[2];
                    }
                }
            }
            return month + "-" + days + "-" + year;
        }
        if (patternSelection == 4) {
            // Pattern dd-mmm-yyyy 00:00
            String date = "";
            String time = "";
            if (startDate.contains(" ")) {
                String[] split = startDate.split(" ");
                if (split.length != 0) {
                    if (split.length == 2) {
                        date = split[0];
                        time = split[1];
                        if (date.contains("-")) {
                            String[] splitDate = date.split("-");
                            if (splitDate.length != 0) {
                                if (splitDate.length == 3) {
                                    int temporaryDays = Integer.parseInt(addition) + Integer.parseInt(split[0]);
                                    days += temporaryDays;
                                    month = splitDate[1];
                                    year = splitDate[2];
                                }
                            }
                        }
                    }

                }
            }
            return days + "-" + month + "-" + year + " " + time;
        }
        return days + "/" + month + "/" + year;
    }

    public static String addHoursToDate(String startDate, String addition) throws MyException {
        String days = "";
        String month = "";
        String year = "";
        String hour = "";
        String minute = ":00";
        if (patternSelection == 1) {
            // Pattern dd/mm/yy

            if (startDate.contains("/")) {
                String[] split = startDate.split("/");
                if (split.length != 0) {
                    if (split.length == 3) {
                        days = split[0];
                        month = split[1];
                        year = split[2];
                    }
                }
            }
            return days + "/" + month + "/" + year + " " + hour + minute;
        }
        if (patternSelection == 2) {
            // Pattern m/d/yyyy
            if (startDate.contains("/")) {
                String[] split = startDate.split("/");
                if (split.length != 0) {
                    if (split.length == 3) {
                        month = split[0];
                        days = split[1];
                        year = split[2];
                    }
                }
                return month + "/" + days + "/" + year + " " + hour + minute;
            }
        }
        if (patternSelection == 3) {
            // Pattern mmm-d-yy
            if (startDate.contains("-")) {
                String[] split = startDate.split("-");
                if (split.length != 0) {
                    if (split.length == 3) {
                        month = split[0];
                        days = split[1];
                        year = split[2];
                    }
                }
            }
            return month + "-" + days + "-" + year + " " + hour + minute;
        }
        if (patternSelection == 4) {
            // Pattern dd-mmm-yyyy 00:00
            String date = "";
            String time = "";
            if (startDate.contains(" ")) {
                String[] split = startDate.split(" ");
                if (split.length != 0) {
                    if (split.length == 2) {
                        date = split[0];
                        time = split[1];
                        if (date.contains("-")) {
                            String[] splitDate = date.split("-");
                            if (splitDate.length != 0) {
                                if (splitDate.length == 3) {
                                    days = splitDate[0];
                                    month = splitDate[1];
                                    year = splitDate[2];
                                }
                            }
                        }
                        if (time.contains(":")) {
                            String[] splitTime = time.split(":");
                            if (splitTime.length != 0) {
                                if (splitTime.length == 2) {
                                    int temporaryHours = Integer.parseInt(splitTime[0]) + Integer.parseInt(addition);
                                    hour += temporaryHours;
                                    minute = splitTime[1];
                                }
                            }
                        }
                    }

                }
            }
            return days + "-" + month + "-" + year + " " + hour + ":" + minute;
        }
        return days + "/" + month + "/" + year;
    }

    public static String addMinutesToDate(String startDate, String addition) throws MyException {
        String days = "";
        String month = "";
        String year = "";
        String hour = "";
        String minute = "";
        if (patternSelection == 1) {
            // Pattern dd/mm/yy

            if (startDate.contains("/")) {
                String[] split = startDate.split("/");
                if (split.length != 0) {
                    if (split.length == 3) {
                        days = split[0];
                        month = split[1];
                        year = split[2];
                    }
                }
            }
            return days + "/" + month + "/" + year + " 00:" + minute;
        }
        if (patternSelection == 2) {
            // Pattern m/d/yyyy
            if (startDate.contains("/")) {
                String[] split = startDate.split("/");
                if (split.length != 0) {
                    if (split.length == 3) {
                        month = split[0];
                        days = split[1];
                        year = split[2];
                    }
                }
                return month + "/" + days + "/" + year + " 00:" + minute;
            }
        }
        if (patternSelection == 3) {
            // Pattern mmm-d-yy
            if (startDate.contains("-")) {
                String[] split = startDate.split("-");
                if (split.length != 0) {
                    if (split.length == 3) {
                        month = split[0];
                        days = split[1];
                        year = split[2];
                    }
                }
            }
            return month + "-" + days + "-" + year + " 00:" + minute;
        }
        if (patternSelection == 4) {
            // Pattern dd-mmm-yyyy 00:00
            String date = "";
            String time = "";
            if (startDate.contains(" ")) {
                String[] split = startDate.split(" ");
                if (split.length != 0) {
                    if (split.length == 2) {
                        date = split[0];
                        time = split[1];
                        if (date.contains("-")) {
                            String[] splitDate = date.split("-");
                            if (splitDate.length != 0) {
                                if (splitDate.length == 3) {
                                    days = splitDate[0];
                                    month = splitDate[1];
                                    year = splitDate[2];
                                }
                            }
                        }
                        if (time.contains(":")) {
                            String[] splitTime = time.split(":");
                            if (splitTime.length != 0) {
                                if (splitTime.length == 2) {
                                    int temporaryMinutes = Integer.parseInt(splitTime[1]) + Integer.parseInt(addition);
                                    hour = hour;
                                    minute += temporaryMinutes;
                                }
                            }
                        }
                    }

                }
            }
            return days + "-" + month + "-" + year + " " + hour + ":" + minute;
        }
        return days + "/" + month + "/" + year;
    }

    public static void dateSorting(String firstDate, String secondDate) throws MyException {
        int firstMillis = 0;
        int secondMillis = 0;

        if (patternSelection == 1) {
            firstMillis = setTimeDaysMonthYear(firstDate);
            secondMillis = setTimeDaysMonthYear(secondDate);
        }
        if (patternSelection == 2) {
            firstMillis = setTimeMonthDaysYear(firstDate);
            secondMillis = setTimeMonthDaysYear(secondDate);
        }
        if (patternSelection == 3) {
            firstMillis = setTimeMonthTitleDaysYear(firstDate);
            secondMillis = setTimeMonthTitleDaysYear(secondDate);
        }
        if (patternSelection == 4) {
            firstMillis = setDaysMonthTitleYearTime(firstDate);
            secondMillis = setDaysMonthTitleYearTime(secondDate);
        }
        if (firstMillis > secondMillis) {
            System.out.println(firstDate + " > " + secondDate);
        }
        if (firstMillis < secondMillis) {
            System.out.println(firstDate + " < " + secondDate);
        }
        if (firstMillis == secondMillis) {
            System.out.println(firstDate + " = " + secondDate);
        }
    }


}
