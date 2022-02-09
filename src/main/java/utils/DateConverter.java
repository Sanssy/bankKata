package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {

    private static final SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");

    public static String formatDate(Date date) {
        return dateFormat.format(date);
    }

    public static Date convertToDate(String stringDate) throws ParseException {
        return dateFormat.parse(stringDate);
    }
}
