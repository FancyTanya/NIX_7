package ua.com.alevel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConvertStringToTimestamp {

    private static final Logger logger = LoggerFactory.getLogger(ConvertStringToTimestamp.class);

    public static Timestamp convertStringToTimestamp(String strDate) {
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date date = (Date) formatter.parse(strDate);
            Timestamp timeStampDate = new Timestamp(date.getTime());

            return timeStampDate;
        } catch (ParseException e) {
            logger.warn("Wrong time format", e);
            throw new RuntimeException(e);
        }
    }
}
