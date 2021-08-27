package ua.com.alevel.timeObject;

import myException.MyException;

import static ua.com.alevel.util.DateTimeConstants.YEAR;
import static ua.com.alevel.util.DateTimeMethods.checkIsLeapYear;

public enum Month  {
    JANUARY("Январь", 31, 1),
    FEBRUARY("Февраль", 28, 2),
    MARCH("Март", 31, 3),
    APRIL("Апрель", 30, 4),
    MAY("Май", 31, 5),
    JUNE("Июнь", 30, 6),
    JULY("Июль", 31, 7),
    AUGUST("Август", 31, 8),
    SEPTEMBER("Сентябрь", 30, 9),
    OCTOBER("Октябрь", 31, 10),
    NOVEMBER("Ноябрь", 30, 11),
    DECEMBER("Декабрь", 31, 12);

    private String name;
    private int daysCount;
    private int monthCount;

    public int getMonthCount() {
        return monthCount;
    }

    public void setYearCount(int monthCount) {
        this.monthCount = monthCount;
    }

    public Month(String name, int daysCount, int monthCount) throws MyException{
        this.name = name;
        this.daysCount = daysCount;
        this.monthCount = monthCount;
        if (monthCount < 0 || monthCount > 12) {
            throw new MyException("Please enter correct data.");
        }
        if (!name.equals(this.name)) {
            throw new MyException("Please enter correct data.");
        }
        if (daysCount <0 || daysCount >31) {
            throw new MyException("Please enter correct data.");
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
