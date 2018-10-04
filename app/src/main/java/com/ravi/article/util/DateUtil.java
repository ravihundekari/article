package com.ravi.article.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static Date parseDate(String pattern, String date) {
        try {
            return new SimpleDateFormat(pattern, Locale.getDefault()).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getFormattedDate(String pattern, Date date) {
        return new SimpleDateFormat(pattern, Locale.getDefault()).format(date);
    }

}
