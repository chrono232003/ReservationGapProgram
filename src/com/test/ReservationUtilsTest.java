package com.test;

import com.cabin.DateUtils;
import com.cabin.ReservationUtils;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ReservationUtilsTest {

    private ReservationUtils resUtils = new ReservationUtils();
    private  DateUtils dateUtils = new DateUtils();
    private String filePathGoodJson = "src/com/test/test-case.json";
    private String filePathBadJson = "src/com/test/bad-test-case.json";

    @Test
    public void parseFileToJsonSuccessTest() {
        JSONObject json = resUtils.parseFileToJson(filePathGoodJson);

        JSONObject search = (JSONObject) json.get("search");
        String startDate = (String) search.get("startDate");
        assert json != null;
        assert startDate.equals("2018-06-04");
    }

     @Test
    public void parseFileToJsonBadTest() {

        JSONObject json = resUtils.parseFileToJson(filePathBadJson);
        assert json == null;
    }


    @Test
    public void parseFileToJsonFileNotFoundTest() {

        JSONObject json = resUtils.parseFileToJson("fake-" + filePathGoodJson);
        assert json == null;
    }


    @Test
    public void isValidGapTrueTest() {
        long gap = 4;
        Date reservationDate = dateUtils.parseDate("2019-05-10");
        Date inputDate = dateUtils.parseDate("2019-05-15");
        boolean isValidGap = resUtils.isValidGap(inputDate, reservationDate, gap);
        assert isValidGap;
    }

    @Test
    public void isValidGapFalseTest() {
        long gap = 4;
        Date reservationDate = dateUtils.parseDate("2019-05-10");
        Date inputDate = dateUtils.parseDate("2019-05-13");
        boolean isValidGap = resUtils.isValidGap(inputDate, reservationDate, gap);
        assert !isValidGap;
    }

    @Test
    public void isValidGapErrorTest() {
        long gap = 4;
        Date reservationDate = dateUtils.parseDate("2019-05-10");
        Date inputDate = null;
        assertThrows(NullPointerException.class, () -> {
            resUtils.isValidGap(inputDate, reservationDate, gap);
        });
    }
}
