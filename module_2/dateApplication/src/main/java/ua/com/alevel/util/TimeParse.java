package ua.com.alevel.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TimeParse {
    SimpleDateFormat formatYearFirst = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat formatDayFirst = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatMonthFirst = new SimpleDateFormat("MM-dd-yyyy");
    SimpleDateFormat formatOutput = new SimpleDateFormat("yyyyMMdd");

    List<String> formatStrings = Arrays.asList("yyyy/MM/dd", "dd/MM/yyyy", "MM-dd-yyyy");

    public Date parseString(String inputDate) {
        for(String formatString: formatStrings) {
            try {
                return new SimpleDateFormat(formatString).parse(inputDate);
            } catch (ParseException e) {
                System.out.println("String has incorrect format");
            }
        }
        return null;
    }

    public String dateToString(Date date) {
       return formatOutput.format(date);
    }

}
