package com.cabin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {


    /**
     * Parse a passed in date string in format yyyy-MM-dd to a SimpleDateFormat object
     * @param dateString
     * @return Date
     */
    public Date parseDate(String dateString) {
        Date date = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.parse(dateString);
        } catch (ParseException pe) {
            System.out.println("There was an issue parsing a date");
            pe.printStackTrace();
        }
        return date;
    }

    /**
     * Compare 2 dates and return days apart from each other
     * @param one
     * @param two
     * @return date differences in days
     */
    long daysBetween(Date one, Date two) {
        long difference = (one.getTime()-two.getTime())/86400000;
        return Math.abs(difference);
    }

}
