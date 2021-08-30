package ua.com.alevel.timeObject;

import myException.MyException;

import static ua.com.alevel.util.DateTimeConstants.YEAR;
import static ua.com.alevel.util.DateTimeMethods.checkIsLeapYear;

public enum Month  {
    JANUARY("January", 31, 1),
    FEBRUARY("February", 28, 2),
    MARCH("March", 31, 3),
    APRIL("April", 30, 4),
    MAY("May", 31, 5),
    JUNE("June", 30, 6),
    JULY("July", 31, 7),
    AUGUST("August", 31, 8),
    SEPTEMBER("September", 30, 9),
    OCTOBER("October", 31, 10),
    NOVEMBER("November", 30, 11),
    DECEMBER("December", 31, 12);

    private String name;
    private int daysCount;
    private int monthCount;

    public int getMonthCount() {
        return monthCount;
    }

    public void setYearCount(int monthCount) {
        this.monthCount = monthCount;
    }

    Month(String name, int daysCount, int monthCount) {
        this.name = name;
        this.daysCount = daysCount;
        this.monthCount = monthCount;
        if (monthCount < 0 || monthCount > 12) {
            try {
                throw new MyException("Please enter correct data.");
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
        if (!name.equals(this.name)) {
            try {
                throw new MyException("Please enter correct data.");
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
        if (daysCount <0 || daysCount >31) {
            try {
                throw new MyException("Please enter correct data.");
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
        if (name == "Февраль") {
            if (checkIsLeapYear(YEAR)) {
                daysCount = 29;
            }
            daysCount = 28;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDaysCount() {
        return daysCount;
    }

    public void setDaysCount(int daysCount) {
        this.daysCount = daysCount;
    }

    @Override
    public String toString() {
        return "Month{" +
                "name='" + name + '\'' +
                ", daysCount=" + daysCount +
                '}';
    }
}
