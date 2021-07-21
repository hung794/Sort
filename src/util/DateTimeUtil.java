package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeUtil {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public boolean isValidDate(String strDateTime) {
        try {
            simpleDateFormat.parse(strDateTime);
            simpleDateFormat.setLenient(false);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static Date parseDateFromString(String strDateTime) {
        try {
            return simpleDateFormat.parse(strDateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Calendar.getInstance().getTime();
    }

    public static String formatDateToString(Date date) {
        return simpleDateFormat.format(date);
    }
}