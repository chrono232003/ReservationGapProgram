package com.test;


import com.cabin.DateUtils;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateUtilsTest {
    private DateUtils dateUtils = new DateUtils();

    @Test
    public void parseDateTestSuccess() {
        try {
            String dateString = "2018-06-04";
            Date date = dateUtils.parseDate(dateString);
            assert date.getTime() == 1528092000000L;
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    @Test
    public void parseDateTestFail() {
        String dateString = "20180604";
        assertThrows(ParseException.class, () -> {
            Date date = dateUtils.parseDate(dateString);
        });
    }

    @Test
    public void daysBetweenTestSuccess() {
        try {
            Date one = dateUtils.parseDate("2018-06-01");;
            Date two = dateUtils.parseDate("2018-06-04");
            assert dateUtils.daysBetween(one, two) == 3;
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    @Test
    public void daysBetweenTestException() {
        try {
            Date one = null;
            Date two = dateUtils.parseDate("2018-06-04");
            assertThrows(NullPointerException.class, () -> {
                dateUtils.daysBetween(one, two);
            });
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }
}
